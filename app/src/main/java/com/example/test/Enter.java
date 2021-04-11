package com.example.test;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter);

        enter_bt = findViewById(R.id.enter_bt);
        login_ent = findViewById(R.id.login_ent);
        psw_ent = findViewById(R.id.psw_ent);
        on_registration = findViewById(R.id.on_registration);

        enter_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Enter.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        on_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Enter.this, Registration.class);
                startActivity(intent);
            }
        });


    }
}