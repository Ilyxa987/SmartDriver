package com.example.test;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Registration extends AppCompatActivity {
    Button registration_bt;
    EditText login_reg, psw_reg,number_reg,name_reg, surname_reg, driver_license, license;
    TextView on_enter;

    MySQLOpenHelper mySQLOpenHelper;
    SQLiteDatabase sdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        registration_bt = findViewById(R.id.registration);
        login_reg = findViewById(R.id.login_reg);
        psw_reg = findViewById(R.id.psw_reg);
        number_reg = findViewById(R.id.number_bus);
        name_reg = findViewById(R.id.name);
        surname_reg = findViewById(R.id.surname);
        driver_license = findViewById(R.id.driver_license);
        license = findViewById(R.id.lecense_bus);
        on_enter = findViewById(R.id.on_enter);

        mySQLOpenHelper = new MySQLOpenHelper(getBaseContext());
        sdb = mySQLOpenHelper.getWritableDatabase();

        registration_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(MySQLOpenHelper.COLUMN_LOGIN,
                        login_reg.getText().toString());
                contentValues.put(MySQLOpenHelper.COLUMN_PSW,
                        psw_reg.getText().toString());
                contentValues.put(MySQLOpenHelper.COLUMN_NAME,
                        name_reg.getText().toString());
                contentValues.put(MySQLOpenHelper.COLUMN_SURNAME,
                        surname_reg.getText().toString());
                contentValues.put(MySQLOpenHelper.COLUMN_NUMBER,
                        number_reg.getText().toString());
                contentValues.put(MySQLOpenHelper.COLUMN_DRIVER_LICENSE,
                        driver_license.getText().toString());
                contentValues.put(MySQLOpenHelper.COLUMN_LICENSE,
                        license.getText().toString());
                sdb.insert(MySQLOpenHelper.TABLE_NAME,null,contentValues);
                Intent intent = new Intent(Registration.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        on_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registration.this, Enter.class);
                startActivity(intent);
            }
        });
    }
}