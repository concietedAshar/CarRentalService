package com.mrash.carrentalservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    EditText UserName,etInputEmail,etPassword,etConfirmPassword;
    Button btnRegister;

    TextView tvAlreadyAUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        UserName =findViewById(R.id.UserName);
        etInputEmail = findViewById(R.id.etInputEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
       // tvAlreadyAUser = findViewById(R.id.tvAlreadyAUser);

        String user,email,password,confirmPass;
        user = UserName.getText().toString().trim();
        email = etInputEmail.getText().toString().trim();
        password = etPassword.getText().toString().trim();
        confirmPass = etConfirmPassword.getText().toString().trim();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValidate())
                {
                    Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                }


            }
        });


      /*  tvAlreadyAUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
*/
    }

    private boolean isValidate() {
        boolean flag = true;
        String user,email,password,confirmPass;
        user = UserName.getText().toString().trim();
        email = etInputEmail.getText().toString().trim();
        password = etPassword.getText().toString().trim();
        confirmPass = etConfirmPassword.getText().toString().trim();
        if(user.equals(" ") || user.isEmpty())
        {
            UserName.setError("Enter UserName");
            flag = false;
            //Toast.makeText(RegisterActivity.this, "Enter Valid UserName", Toast.LENGTH_SHORT).show();
        }
        if(email.equals(" ")  || email.isEmpty())
        {
            etInputEmail.setError("Enter Email");
            flag = false;
            //Toast.makeText(RegisterActivity.this, "Enter Valid Email", Toast.LENGTH_SHORT).show();
        }
        if(password.equals(" ") || password.isEmpty())
        {
            etPassword.setError("Enter PassWord");
            flag = false;
            //Toast.makeText(RegisterActivity.this, "Enter Valid PassWord", Toast.LENGTH_SHORT).show();
        }
        if(confirmPass.isEmpty() || confirmPass.equals(" "))
        {
            etConfirmPassword.setError("Enter PassWord");
            flag = false;
           // Toast.makeText(RegisterActivity.this, "PassWord is Empty", Toast.LENGTH_SHORT).show();
        }

        if(!(password.equals(confirmPass))) {
            etConfirmPassword.setError("PassWord Doesn't Match");
            flag = false;
        }
        return flag;
    }
}