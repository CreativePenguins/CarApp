package comp330.com.carapp.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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

    public
}
