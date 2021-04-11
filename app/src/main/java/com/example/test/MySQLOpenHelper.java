package com.example.test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySQLOpenHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "drivers.bd";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "drivers";

    public static final String COLUMN_LOGIN = "login";
    public static final String COLUMN_PSW = "password";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SURNAME= "surname";
    public static final String COLUMN_NUMBER = "number";
    public static final String COLUMN_DRIVER_LICENSE= "driverLicense";
    public static final String COLUMN_LICENSE= "license";



    public MySQLOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME
                + "(_login TEXT PRIMARY KEY, " +
                COLUMN_PSW + " TEXT, "
                + COLUMN_NAME + " TEXT, "
                + COLUMN_SURNAME + " TEXT, "
                + COLUMN_NUMBER + "INTEGER, "
                + COLUMN_DRIVER_LICENSE + " INTEGER, "
                + COLUMN_LICENSE +" INTEGER);";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(sqLiteDatabase);

    }
}
