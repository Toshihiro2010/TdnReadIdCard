package com.stecon.patipan_on.steconidcard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by patipan_on on 4/26/2018.
 */

public class MyDBHelpler extends SQLiteOpenHelper {

    public static final String DB_NAME = "DB_ThaiIdCard";
    public static final int DB_VERSION = 1;

    private String idCardTable = DatabaseIdCardData.TABLE_NAME;

    private String strSqIDCardData = DatabaseIdCardData.strSqlCreate;



    public MyDBHelpler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(strSqIDCardData);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("onUpgrade => ", "old > " + oldVersion + "/new > " + newVersion);
        db.execSQL("DROP TABLE IF EXISTS " + idCardTable);
        onCreate(db);

    }
}
