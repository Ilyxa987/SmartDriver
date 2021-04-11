package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class ProfileActivity extends AppCompatActivity {
    MySQLOpenHelper mySQLOpenHelper;
    SQLiteDatabase sdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mySQLOpenHelper = new MySQLOpenHelper(getBaseContext());
        sdb = mySQLOpenHelper.getWritableDatabase();
    }
}