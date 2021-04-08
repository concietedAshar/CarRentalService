package com.mrash.carrentalservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText etDriverName,etCarName,etDriverNumber,etAdress,etFare;
    Button btnAddInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDriverName = findViewById(R.id.etDriverName);
        etCarName = findViewById(R.id.etCarName);
        etDriverNumber = findViewById(R.id.etDriverNumber);
        etFare = findViewById(R.id.etFare);
        etAdress = findViewById(R.id.etAdress);
        btnAddInfo = findViewById(R.id.btnAddInfo);

            btnAddInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(isValidate()) {
                        String d_name = etDriverName.getText().toString().trim();
                        String c_name = etCarName.getText().toString().trim();
                        String d_No = etDriverNumber.getText().toString();
                        String d_adress = etAdress.getText().toString();
                        String fare = etFare.getText().toString();

                        Intent intent = new Intent(MainActivity.this,com.mrash.carrentalservice.InfoActivity.class);
                        intent.putExtra("keyDriverName",d_name);
                        intent.putExtra("keyCarName", c_name);
                        intent.putExtra("keyDriverNo",d_No);
                        intent.putExtra("keyDriverAdress",d_adress);
                        intent.putExtra("keyFare",fare);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Unknown Error", Toast.LENGTH_SHORT).show();

                    }

                }
            });


    }

    private boolean isValidate() {
        boolean flag = true;
        String d_name = etDriverName.getText().toString().trim();
        String c_name = etCarName.getText().toString().trim();
        String d_No = etDriverNumber.getText().toString();
        String d_adress = etAdress.getText().toString();

        if(etFare.getText().toString().isEmpty() || etFare.getText().toString().equals("0") || etFare.getText().toString().equals(""))
        {
            etFare.setError("Enter Valid Fare");
            flag = false;
        }

        if(d_adress.isEmpty())
        {
            etAdress.setError("Adress is empty");
            flag = false;
        }
        if(d_name.isEmpty())
        {
            etDriverName.setError("Name is Empty");
            flag = false;
        }
        if(c_name.isEmpty())
        {
            etCarName.setError("Car Name is Empty");
            flag = false;
        }
        if(d_No.isEmpty())
        {
            etDriverNumber.setError("Number is Empty");
            flag = false;
        }
    return flag;
    }
}