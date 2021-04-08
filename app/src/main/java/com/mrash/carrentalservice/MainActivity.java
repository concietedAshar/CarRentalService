package com.mrash.carrentalservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etDriverName,etCarName,etDriverNumber,etAdress;
    Button btnAddInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDriverName = findViewById(R.id.etDriverName);
        etCarName = findViewById(R.id.etCarName);
        etDriverNumber = findViewById(R.id.etDriverNumber);
        etAdress = findViewById(R.id.etAdress);

        String d_name = etDriverName.getText().toString().trim();
        String c_name = etCarName.getText().toString().trim();
        String d_No = etDriverNumber.getText().toString().trim();
        String d_adress = etAdress.getText().toString().trim();
        if(d_adress.isEmpty())
        {
            etAdress.setError("Adress is empty");
        }
        if(d_name.isEmpty())
        {
            etDriverName.setError("Name is Empty");
        }
        if(c_name.isEmpty())
        {
            etCarName.setError("Car Name is Empty");
        }
        if(d_No.isEmpty())
        {
            etDriverNumber.setError("Number is Empty");
        }
    }
}