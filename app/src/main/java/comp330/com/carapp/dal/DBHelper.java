package comp330.com.carapp.dal;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * DBHelper extends library found at https://github.com/jgilfelt/android-sqlite-asset-helper
 */
public class DBHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "carData.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

}