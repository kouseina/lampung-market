package com.example.lampungmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lampungmarket.api.RetrofitClient;
import com.example.lampungmarket.models.DefaultResponse;
import com.example.lampungmarket.models.LoginRequest;
import com.example.lampungmarket.models.LoginResponse;
import com.example.lampungmarket.models.RegisterRequest;
import com.example.lampungmarket.storage.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Boolean isLoading = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView tvRegister = findViewById(R.id.tv_register);
        Button btnLogin = findViewById(R.id.btn_login);
        EditText etEmail = findViewById(R.id.et_email);
        EditText etPassword = findViewById(R.id.et_password);

        tvRegister.setOnClickListener(view -> {
            Intent intent = new Intent(this,RegisterActivity.class);
            startActivity(intent);
        });

        btnLogin.setOnClickListener(view -> {
            if (isLoading) return;

            isLoading = true;
            LoginRequest request = new LoginRequest(etEmail.getText().toString(), etPassword.getText().toString());

            RetrofitClient.instance().loginUser(request)
                    .enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                            if (response.code() == 200) {
                                SharedPrefManager.setUser(getApplicationContext(), response.body().data);
                                Toast.makeText(getApplicationContext(), "Login succeed", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "Login fail", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
        });

        isLoading = false;
    }
}