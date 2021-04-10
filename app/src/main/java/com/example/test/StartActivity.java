package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {
    Button enter_fr, registration_fr;
    Enter enterFragment;
    Registration registrationFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        enter_fr= findViewById(R.id.enter_fr);
        registration_fr= findViewById(R.id.registration_fr);

        enterFragment = new Enter();
        registrationFragment = new Registration();

        FragmentManager fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.add(R.id.fragment_container,registrationFragment);
            ft.commit();
        }

        enter_fr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.add(R.id.fragment_container,enterFragment);
                ft.commit();
            }
        });

        registration_fr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.add(R.id.fragment_container,registrationFragment);
                ft.commit();
            }
        });

    }
}