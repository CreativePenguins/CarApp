package comp330.com.carapp.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import comp330.com.carapp.model.Maintenance;
import comp330.com.carapp.model.MaintenanceInterface;

/**
 * Created by Tyler on 4/10/16.
 */
public class MaintDAO {

    private final Context mContext;
    private SQLiteDatabase database;
    private DBHelper mDBHelper;

    public final static String MAINT_TABLE = "Maintenance";
    public final static String MAINT_ID = "maintenance_id";
    public final static String MAINT_MILE_ID = "mileage_id";
    public final static String MAINT_TYPE = "type";
    public final static String MAINT_VALUE = "value";
    public final static String MAINT_DETAILS = "details";

    public MaintDAO(Context context) {
        this.mContext = context;
        mDBHelper = new DBHelper(mContext);
        database = mDBHelper.getWritableDatabase();
    }

    public void addMaint(MaintenanceInterface newMaint) {
        try {
            ContentValues values = new ContentValues();
            //values.put(MAINT_MILE_ID, newMaint.getMileage());
            values.put(MAINT_TYPE, newMaint.getType());
            values.put(MAINT_VALUE, newMaint.getValue());
            values.put(MAINT_DETAILS, newMaint.getDetails());

            database.insert(MAINT_TABLE, null, values);
        } catch (Exception e) {
            System.err.println("MaintDAO: Threw an exception adding to the vehicle table.");
            System.err.println(e.getMessage());
        }
    }

    public MaintenanceInterface getMaint(int maintID) {
        MaintenanceInterface maint = new Maintenance();
        String selectMaintQuery = "SELECT * FROM Maintenance WHERE maintenance_id = " + maint;
        try {
            Cursor cursor = database.rawQuery(selectMaintQuery, null);
            try {
                if (cursor.moveToFirst()) {
                    do {
                        maint.setDetails(cursor.getString(4));
                        //maint.setMileage(cursor.getString(1));
                        maint.setType(cursor.getString(2));
                        maint.setValue(cursor.getString(3));
                    } while (cursor.moveToNext());
                }
                return maint;
            } finally {
                try {
                    cursor.close();
                } catch (Exception e) {
                    System.err.println("MaintDAO: Threw an exception getting a vehicle.");
                    System.err.println(e.getMessage());
                }
            }
        } finally {
            try {
                database.close();
            } catch (Exception e) {
                System.err.println("MaintDAO: Threw an exception getting a vehicle.");
                System.err.println(e.getMessage());
            }
        }
    }
}
