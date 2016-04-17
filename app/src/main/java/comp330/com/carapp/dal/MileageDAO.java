package comp330.com.carapp.dal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import comp330.com.carapp.model.Mileage;

/**
 * Mileage data access object
 */
public class MileageDAO {

    protected static final String TAG = "MileageDAO";

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
    public ArrayList<Mileage> getMileageList(int vehicleID) {
        ArrayList<Mileage> list = new ArrayList<>();

        String selectMileageQuery = "SELECT * FROM Mileage WHERE vehicle_id = " + vehicleID;

        try {

            Cursor cursor = database.rawQuery(selectMileageQuery, null);
            try {

                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        Mileage mileage = new Mileage();
                        //only one column
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

}
