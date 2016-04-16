package comp330.com.carapp.dal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Tyler on 4/10/16.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "carData";
    private static final int DATABASE_VER = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
