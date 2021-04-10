package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Registration extends Fragment {
    Button registration_bt;
    EditText login_reg, psw_reg,number_reg,name_reg, surname_reg;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.registration,null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        registration_bt = view.findViewById(R.id.registration);
        login_reg = view.findViewById(R.id.login_reg);
        psw_reg = view.findViewById(R.id.psw_reg);
        number_reg = view.findViewById(R.id.number_bus);
        name_reg = view.findViewById(R.id.name);
        surname_reg = view.findViewById(R.id.surname);

        registration_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MapsActivity.class);
                startActivity(intent);
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }
}
