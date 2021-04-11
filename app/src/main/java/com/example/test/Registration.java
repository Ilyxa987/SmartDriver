package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Registration extends AppCompatActivity {
    Button registration_bt;
    EditText login_reg, psw_reg,number_reg,name_reg, surname_reg;
    TextView on_enter;

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
        on_enter = findViewById(R.id.on_enter);

        registration_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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