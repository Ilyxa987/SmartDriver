package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    TextView profile_name, profile_surname, profile_number, profile_dr_license, profile_license;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profile_name = findViewById(R.id.profile_name);
        profile_surname = findViewById(R.id.profile_surname);
        profile_number = findViewById(R.id.profile_number);
        profile_dr_license = findViewById(R.id.profile_driver_license);
        profile_license = findViewById(R.id.profile_bus_license);

        Intent intent = getIntent();

        profile_name.setText(intent.getStringExtra("name"));
        profile_surname.setText(intent.getStringExtra("surname"));
        profile_number.setText(intent.getStringExtra("number"));
        profile_dr_license.setText(intent.getStringExtra("licenseDriver"));
        profile_license.setText(intent.getStringExtra("license"));



    }
}