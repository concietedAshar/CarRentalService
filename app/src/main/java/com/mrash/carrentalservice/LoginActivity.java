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

     String USERNAME = "admin";
     String PASSWORD = "admin";

    TextView tvSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        tvSignUp = findViewById(R.id.tvSignUp);
       // Intent  intent = getIntent();
       // USERNAME = intent.getStringExtra("keyUser");
      //  PASSWORD = intent.getStringExtra("password");

        String userName,pass;
        userName = etUserName.getText().toString().trim();
        pass = etPassword.getText().toString().trim();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

                            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                            finish();

                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Email/Password Doesn't match", Toast.LENGTH_SHORT).show();
                }

            }
        });

       /* tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                finish();
            }
        });
*/
    }
}