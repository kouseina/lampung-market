package com.example.lampungmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView tvRegister = findViewById(R.id.tv_register);
        Button btnLogin = findViewById(R.id.btn_login);
        EditText editTextEmail = findViewById(R.id.et_email);
        EditText editTextPassword = findViewById(R.id.et_password);

//        tvRegister.setOnClickListener{view ->
//                var intent = Intent(this,RegisterActivity::class.java)
//            startActivity(intent)
//        }

        btnLogin.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}