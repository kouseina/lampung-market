package com.example.lampungmarket;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lampungmarket.api.RetrofitClient;
import com.example.lampungmarket.models.DefaultResponse;
import com.example.lampungmarket.models.RegisterRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView tvLogin = findViewById(R.id.tv_login);
        Button btnRegister = findViewById(R.id.btn_register);
        EditText etFullName = findViewById(R.id.et_fullName);
        EditText etEmail = findViewById(R.id.et_email);
        EditText etPhone = findViewById(R.id.et_phone);
        EditText etPassword = findViewById(R.id.et_password);

        tvLogin.setOnClickListener(view -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });

        btnRegister.setOnClickListener(view -> {
            RegisterRequest request = new RegisterRequest(etFullName.getText().toString(), etPhone.getText().toString(), etEmail.getText().toString(), etPassword.getText().toString());

            RetrofitClient.instance().registerUser(request)
                    .enqueue(new Callback<DefaultResponse>() {
                        @Override
                        public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                            if (response.code() == 200) {
                                Toast.makeText(getApplicationContext(), "Register succeed", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "Register fail", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<DefaultResponse> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
        });
    }
}