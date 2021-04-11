package com.example.test;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Enter extends AppCompatActivity {
    Button enter_bt;
    EditText login_ent, psw_ent;
    TextView on_registration;

    MySQLOpenHelper mySQLOpenHelper;
    SQLiteDatabase sdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter);

        enter_bt = findViewById(R.id.enter_bt);
        login_ent = findViewById(R.id.login_ent);
        psw_ent = findViewById(R.id.psw_ent);
        on_registration = findViewById(R.id.on_registration);

        mySQLOpenHelper = new MySQLOpenHelper(getBaseContext());
        sdb = mySQLOpenHelper.getWritableDatabase();

        on_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Enter.this, Registration.class);
                startActivity(intent);
            }
        });

        enter_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String quere = "SELECT * FROM " + MySQLOpenHelper.TABLE_NAME;
                String findLogin = login_ent.getText().toString();
                String findPsw = psw_ent.getText().toString();
                if (!(findLogin.equals("") && findPsw.equals(""))) {
                    quere += " WHERE login = \"" + findLogin + "\";";
                }
                Cursor cursor = sdb.rawQuery(quere, null);
                if (findPsw.equals(cursor.getString(cursor.getColumnIndex("password")))) {
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    String surname = cursor.getString(cursor.getColumnIndex("surname"));
                    String number_bus = cursor.getString(cursor.getColumnIndex("number"));
                    String driver_license = cursor.getString(cursor.getColumnIndex("driverLicense"));
                    String bus_licence = cursor.getString(cursor.getColumnIndex("license"));
                    Intent intent = new Intent(Enter.this, ProfileActivity.class);
                    intent.putExtra("name",name);
                    intent.putExtra("surname",surname);
                    intent.putExtra("number",number_bus);
                    intent.putExtra("licenseDriver",driver_license);
                    intent.putExtra("license",bus_licence);
                    startActivity(intent);
                }
            }
        });


    }
}