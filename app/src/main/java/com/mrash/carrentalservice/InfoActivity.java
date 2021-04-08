package com.mrash.carrentalservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class InfoActivity extends AppCompatActivity {

    TextView tvInfoDName,tvInfoCarName,tvFare,tvInfoDNO,tvDriverAdress;
    Button btnCall,btnLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        init();
        Intent intent = getIntent();
        String d_name = intent.getStringExtra("keyDriverName");
        String c_Name = intent.getStringExtra("keyCarName");
        String d_No = intent.getStringExtra("keyDriverNo");
        String d_Adress = intent.getStringExtra("keyDriverAdress");
        String c_fare = intent.getStringExtra("keyFare");
        if(!(d_name.isEmpty() || d_name == null))
        {
            tvInfoDName.setText(d_name);
        }
        else
        {
            Toast.makeText(this, "Driver Name Not Received", Toast.LENGTH_SHORT).show();
        }
        if(!(c_Name.isEmpty() || c_Name == null))
        {
            tvInfoCarName.setText(c_Name);
        }
        else
        {
            Toast.makeText(this, "Car Name Not Received", Toast.LENGTH_SHORT).show();
        }
        if(!(d_No.isEmpty() || d_No == null))
        {
            tvInfoDNO.setText(d_No);
            btnCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent1 = new Intent(Intent.ACTION_DIAL);
                    intent1.setData(Uri.parse("tel:" + d_No));
                    startActivity(intent1);
                }
            });

        }else
        {
            Toast.makeText(this, "Driver Mobile Number Not Received", Toast.LENGTH_SHORT).show();
        }
        if(!(d_Adress.isEmpty() || d_Adress == null))
        {
            tvDriverAdress.setText(d_Adress);
            btnLocation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent chooser = null;
                    Intent intent2 = new Intent(Intent.ACTION_VIEW);
                    chooser = intent2.createChooser(intent2,"Launch Maps");
                    intent2.setData(Uri.parse("geo:0,0?q=" + d_Adress));
                    startActivity(chooser);
                }
            });
        }else
        {
            Toast.makeText(this, "Address is Not Received", Toast.LENGTH_SHORT).show();
        }
        if(!(c_fare.isEmpty() || c_fare == null))
        {
            tvFare.setText(c_fare);
        }else
        {
            Toast.makeText(this, "Fare Not Received", Toast.LENGTH_SHORT).show();
        }




    }

    private void init() {
        tvInfoDName = findViewById(R.id.tvInfoDName);
        tvInfoCarName = findViewById(R.id.tvInfoCarName);
        tvFare = findViewById(R.id.tvFare);
        tvInfoDNO = findViewById(R.id.tvInfoDNO);
        tvDriverAdress = findViewById(R.id.tvDriverAdress);
        btnCall = findViewById(R.id.btnCall);
        btnLocation = findViewById(R.id.btnLocation);

    }
}