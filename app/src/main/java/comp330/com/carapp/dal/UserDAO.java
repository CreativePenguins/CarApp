package comp330.com.carapp.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Settings;

import org.apache.http.client.UserTokenHandler;

import comp330.com.carapp.model.UserInterface;

/**
 * Created by Tyler on 4/10/16.
 */
public class UserDAO {

    private final Context mContext;
    private SQLiteDatabase database;
    private DBHelper mDBHelper;

    public final static String USER_TABLE="Users";
    public final static String USER_ID="user_id";
    public final static String USER_VEHICLE_ID="vehicle_id";
    public final static String USER_NAME="name";
    public final static String USER_D_LICENSE="license_no";
    public final static String USER_UNAME="userName";
    public final static String USER_PW="userPW";

    public UserDAO(Context context) {
        this.mContext = context;
        mDBHelper = new DBHelper(mContext);
        database = mDBHelper.getWritableDatabase();
    }

    public void addUser(UserInterface newUser) {

        try {
            ContentValues values = new ContentValues();
            values.put(USER_NAME, newUser.getName());
            //values.put(USER_VEHICLE_ID, newUser.getVehicle());
            values.put(USER_D_LICENSE, newUser.getLicNo());
            values.put(USER_NAME, newUser.getName());
            values.put(USER_UNAME, newUser.getUsername());
            values.put(USER_PW, newUser.getPassword());

            database.insert(USER_TABLE, null, values);
        }
        catch (Exception e) {
            System.err.println("UserDAO: Threw an exception adding to user table...");
            System.err.println(e.getMessage());
        }
    }

    //TODO Resume coding here...
}
