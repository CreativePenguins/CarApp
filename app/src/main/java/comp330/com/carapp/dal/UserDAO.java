package comp330.com.carapp.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Settings;

import org.apache.http.client.UserTokenHandler;

import java.util.ArrayList;

import comp330.com.carapp.model.User;
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

    public UserInterface getUser(int userID) {

        UserInterface user = new User();

        String selectUserQuery = "SELECT * FROM Users where user_id = " + userID;

        try {
            Cursor cursor = database.rawQuery(selectUserQuery, null);
            try {
                if(cursor.moveToFirst()) {
                    do {
                        user.setUsername(cursor.getString(2));
                        user.setPassword(cursor.getString(3));
                        user.setName(cursor.getString(4));
                        user.setLicNo(cursor.getString(5));
                    } while(cursor.moveToNext());
                } return user;
            } finally {
                try {
                    cursor.close();
                } catch (Exception e) {
                    System.err.println("UserDAO: threw an error getting a user.");
                    System.err.println(e.getMessage());
                }
            }
        } finally {
            try {
                database.close();
            } catch (Exception e) {
                System.err.println("UserDAO: threw an error getting a user.");
                System.err.println(e.getMessage());
            }
        }
    }

    public Cursor selectUser() {
        String[] cols = new String[] {
                USER_ID,
                USER_VEHICLE_ID,
                USER_UNAME,
                USER_PW,
                USER_NAME,
                USER_D_LICENSE
        }; Cursor mCursor = database.query(true, USER_TABLE, cols, null, null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        } return mCursor;
    }

    /**
     * Gets all the user entries from the database.
     * @return an ArrayList of User objects.
     */
    public ArrayList<UserInterface> getUserList() {
        ArrayList<UserInterface> list = new ArrayList<>();
        String selectUsersQuery = "SELECT * FROM Users";

        try {
            Cursor cursor = database.rawQuery(selectUsersQuery, null);
            try {
                if (cursor.moveToFirst()) {
                    do {
                        UserInterface user = new User();
                        user.setUsername(cursor.getString(2));
                        user.setPassword(cursor.getString(3));
                        user.setName(cursor.getString(4));
                        user.setLicNo(cursor.getString(5));

                        list.add(user);
                    } while (cursor.moveToNext());
                }
            } finally {
                try {
                    cursor.close();
                } catch (Exception e) {
                    System.err.println("UserDAO: Threw an exception getting list of vehicles.");
                    System.err.println(e.getMessage());
                }
            }
        } finally {
            try {
                database.close();
            } catch (Exception e) {
                System.err.println("UserDAO: Threw an exception getting list of vehicles.");
                System.err.println(e.getMessage());
            }
        } return list;
    }
}
