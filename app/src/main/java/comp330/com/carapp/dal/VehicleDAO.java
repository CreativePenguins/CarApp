package comp330.com.carapp.dal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.*;
import android.content.Context;

/**
 * Created by Tyler on 4/10/16.
 */
public class VehicleDAO {
    private DBHelper dbHelper;
    private SQLiteDatabase database;

    public final static String VEHICLE_TABLE="VehicleData";
    public final static String VEHICLE_ID="vehicle_id";
    public final static String VEHICLE_NAME="name";
    public final static String VEHICLE_MAKE="make";
    public final static String VEHICLE_MODEL="model";
    public final static String VEHICLE_YEAR="year";
    public final static String VEHICLE_COLOR="color";
    public final static String VECHILE_LicensePlate="licenseplate";

    /*
     * @param context
     *
     */

    public VehicleDAO(Context context) {
        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
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
}