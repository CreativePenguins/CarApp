package comp330.com.carapp.dal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.*;
import android.content.Context;

import java.util.ArrayList;

import comp330.com.carapp.model.Vehicle;
import comp330.com.carapp.model.VehicleInterface;

/**
 * Vehicle data access object
 */
public class VehicleDAO {

    private final Context mContext;
    private SQLiteDatabase database;
    private DBHelper mDbHelper;

    public final static String VEHICLE_TABLE="VehicleData";
    public final static String VEHICLE_ID="vehicle_id";
    public final static String VEHICLE_NAME="name";
    public final static String VEHICLE_MAKE="make";
    public final static String VEHICLE_MODEL="model";
    public final static String VEHICLE_YEAR="year";
    public final static String VEHICLE_COLOR="color";
    public final static String VECHILE_LicensePlate="license_plate";


    public VehicleDAO(Context context) {
        this.mContext = context;
        mDbHelper = new DBHelper(mContext);
        database = mDbHelper.getWritableDatabase();
    }

    public long createVehicle(String name, String make, String model, String year, String color, String plate) {
        ContentValues values = new ContentValues();
        values.put(VEHICLE_NAME, name);
        values.put(VEHICLE_MAKE, make);
        values.put(VEHICLE_MODEL, model);
        values.put(VEHICLE_YEAR, year);
        values.put(VEHICLE_COLOR, color);
        values.put(VECHILE_LicensePlate, plate);
        return database.insert(VEHICLE_TABLE, null, values);
    }

    public Cursor selectVehicle() {
        String[] cols = new String[] {
                VEHICLE_ID,
                VEHICLE_NAME,
                VEHICLE_MAKE,
                VEHICLE_MODEL,
                VEHICLE_YEAR,
                VEHICLE_COLOR,
                VECHILE_LicensePlate
        };
        Cursor mCursor = database.query(true, VEHICLE_TABLE, cols, null, null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    /**
     * Gets all the vehicle entries from the database.
     * @return an ArrayList of Vehicle objects
     */
    public ArrayList<VehicleInterface> getVehicleList() {
        ArrayList<VehicleInterface> list = new ArrayList<>();

        String selectVehiclesQuery = "SELECT * FROM VehicleData";

        try {

            Cursor cursor = database.rawQuery(selectVehiclesQuery, null);
            try {

                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        VehicleInterface vehicle = new Vehicle();
                        vehicle.setName(cursor.getString(1));
                        vehicle.setMake(cursor.getString(2));
                        vehicle.setModel(cursor.getString(3));
                        vehicle.setYear(cursor.getInt(4));
                        vehicle.setColor(cursor.getString(5));
                        vehicle.setLicensePlate(cursor.getString(6));

                        list.add(vehicle);
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