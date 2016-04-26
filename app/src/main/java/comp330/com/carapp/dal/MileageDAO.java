package comp330.com.carapp.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import comp330.com.carapp.model.Mileage;
import comp330.com.carapp.model.MileageInterface;

/**
 * Mileage data access object
 */
public class MileageDAO {

    private final Context mContext;
    private SQLiteDatabase database;
    private DBHelper mDbHelper;

    private final static String VEHICLE_ID = "vehicle_id";
    private final static String DATE = "date";
    private final static String MILEAGE = "mileage";

    public MileageDAO(Context context) {
        this.mContext = context;
        mDbHelper = new DBHelper(mContext);
        database = mDbHelper.getWritableDatabase();
    }

    /**
     * Gets all the mileage entries from the database for a particular vehicle.
     * @param vehicleID selected vehicle to get the mileage for
     * @return an ArrayList of Mileage objects
     */
    public ArrayList<MileageInterface> getMileageList(int vehicleID) {
        ArrayList<MileageInterface> list = new ArrayList<>();

        String selectMileageQuery = "SELECT * FROM Mileage WHERE vehicle_id = " + vehicleID;

        try {

            Cursor cursor = database.rawQuery(selectMileageQuery, null);
            try {

                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        MileageInterface mileage = new Mileage();
                        mileage.setVehicleID(cursor.getInt(1));
                        mileage.setDate(cursor.getString(2));
                        mileage.setMileage(cursor.getInt(3));

                        list.add(mileage);
                    } while (cursor.moveToNext());
                }

            } finally {
                try { cursor.close(); } catch (Exception ignore) {}
            }

        } finally {
            try { database.close(); } catch (Exception ignore) {}
        }

        return list;
    }

    public void addMileage(MileageInterface newMileage) {

        try {
            ContentValues values = new ContentValues();
            values.put("vehicle_id", newMileage.getVehicleID());
            values.put("date", newMileage.getDate());
            values.put("mileage", newMileage.getMileage());

            database.insert("Mileage", null, values);
        }
        catch (Exception se) {
            System.err.println("MileageDAO: Threw an exception adding to the mileage table.");
            System.err.println(se.getMessage());
        }

    }

}
