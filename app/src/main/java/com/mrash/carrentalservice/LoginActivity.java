package com.mrash.carrentalservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etUserName,etPassword;
    Button btn_login;

    final String USERNAME = "admin";
    final String PASSWORD = "admin";

    TextView tvSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        tvSignUp = findViewById(R.id.tvSignUp);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName,pass;
                userName = etUserName.getText().toString().trim();
                pass = etPassword.getText().toString().trim();

                if(userName.equals(" ") || userName.isEmpty())
                {
                    Toast.makeText(LoginActivity.this, "Enter UserName", Toast.LENGTH_SHORT).show();
                }

                if(pass.equals(" ") || pass.isEmpty())
                {
                    Toast.makeText(LoginActivity.this, "Enter PassWord", Toast.LENGTH_SHORT).show();
                }
                if(userName.equals(USERNAME) && pass.equals(PASSWORD))
                {
                    btn_login.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                          //  Intent intent = new Intent(LoginActivity.this,)

                        }
                    });

                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Email/Password Doesn't match", Toast.LENGTH_SHORT).show();
                }

            }
        });

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                finish();
            }
        });

    }
}