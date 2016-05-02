package comp330.com.carapp.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import comp330.com.carapp.model.Maintenance;
import comp330.com.carapp.model.MaintenanceInterface;
import comp330.com.carapp.model.Mileage;
import comp330.com.carapp.model.MileageInterface;

/**
 * Maintenance data access object
 */
public class MaintDAO {

    private final Context mContext;
    private SQLiteDatabase database;
    private DBHelper mDBHelper;

    public final static String MAINT_TABLE = "Maintenance";
    public final static String MILEAGE_TABLE = "Mileage";
    public final static String VEHICLE_ID = "vehicle_id";
    public final static String DATE = "date";
    public final static String MAINT_MILE = "mileage";
    public final static String MAINT_TYPE = "type";
    public final static String MAINT_VALUE = "value";
    public final static String MAINT_DETAILS = "details";

    public MaintDAO(Context context) {
        this.mContext = context;
        mDBHelper = new DBHelper(mContext);
        database = mDBHelper.getWritableDatabase();
    }

    /**
     * Add a maintenance object to the maintenance and mileage tables.
     * @param newMaint new maintenance to be added
     */
    public void addMaint(MaintenanceInterface newMaint) {
        //adds to the maintenance table
        try {
            ContentValues values = new ContentValues();
            values.put(VEHICLE_ID, newMaint.getMileage().getVehicleID());
            values.put(DATE, newMaint.getMileage().getDate());
            values.put(MAINT_MILE, newMaint.getMileage().getMileage());
            values.put(MAINT_TYPE, newMaint.getType());
            values.put(MAINT_VALUE, newMaint.getValue());
            values.put(MAINT_DETAILS, newMaint.getDetails());

            database.insert(MAINT_TABLE, null, values);
        } catch (Exception e) {
            System.err.println("MaintDAO: Threw an exception adding to the maintenance table.");
            System.err.println(e.getMessage());
        }

        //adds to the mileage table
        try {
            ContentValues values = new ContentValues();
            values.put(VEHICLE_ID, newMaint.getMileage().getVehicleID());
            values.put(DATE, newMaint.getMileage().getDate());
            values.put(MAINT_MILE, newMaint.getMileage().getMileage());

            database.insert(MILEAGE_TABLE, null, values);
        } catch (Exception e) {
            System.err.println("MaintDAO: Threw an exception adding to the mileage table.");
            System.err.println(e.getMessage());
        }
    }

    /**
     * Gets a list of maintenance objects of a particular type for a particular vehicle
     * @param vehicleID vehicle to filter by
     * @param type of maintenance to filter by
     * @return array list of maintenance objects
     */
    public ArrayList<MaintenanceInterface> getMaintListByType(int vehicleID, String type) {
        ArrayList<MaintenanceInterface> list = new ArrayList<>();

        String selectMaintQuery = "SELECT * FROM Maintenance WHERE type = '" + type +
                "' AND vehicle_id = " + vehicleID + " ORDER BY mileage ASC";

        try {

            Cursor cursor = database.rawQuery(selectMaintQuery, null);
            try {

                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        MaintenanceInterface maint = new Maintenance();
                        MileageInterface mileage = new Mileage();
                        mileage.setVehicleID(cursor.getInt(1));
                        mileage.setDate(cursor.getString(2));
                        mileage.setMileage(cursor.getInt(3));
                        maint.setMileage(mileage);
                        maint.setType(cursor.getString(4));
                        maint.setValue(cursor.getString(5));
                        maint.setDetails(cursor.getString(6));

                        list.add(maint);
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

    /**
     * Gets all of the maintenance for a particular vehicle
     * @param vehicleID vehicle to filter by
     * @return ArrayList of maintenance performed on a specific vehicle
     */
    public ArrayList<MaintenanceInterface> getMaintList(int vehicleID) {
        ArrayList<MaintenanceInterface> list = new ArrayList<>();

        String selectMaintQuery = "SELECT * FROM Maintenance WHERE vehicle_id = " + vehicleID;

        try {
            Cursor cursor = database.rawQuery(selectMaintQuery, null);
            try {
                if (cursor.moveToFirst()) {
                    do {
                        MaintenanceInterface maint = new Maintenance();
                        MileageInterface mileage = new Mileage();
                        mileage.setVehicleID(cursor.getInt(1));
                        mileage.setDate(cursor.getString(2));
                        mileage.setMileage(cursor.getInt(3));
                        maint.setMileage(mileage);
                        maint.setType(cursor.getString(4));
                        maint.setValue(cursor.getString(5));
                        maint.setDetails(cursor.getString(6));
                        list.add(maint);
                    } while (cursor.moveToNext());
                }

            } finally {
                try {
                    cursor.close();
                } catch (Exception e) {
                    System.err.println("MaintDAO: Threw an exception getting a maintenance object.");
                    System.err.println(e.getMessage());
                }
            }
        } finally {
            try {
                database.close();
            } catch (Exception e) {
                System.err.println("MaintDAO: Threw an exception getting a maintenance object.");
                System.err.println(e.getMessage());
            }
        }
        return list;
    }
}