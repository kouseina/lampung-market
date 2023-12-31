package com.example.lampungmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toolbar;

import com.example.lampungmarket.storage.SharedPrefManager;

public class WelcomeActivity extends AppCompatActivity {
    @Override
    protected void onStart() {
        super.onStart();

        if(SharedPrefManager.getLoggedInStatus(getApplicationContext())){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button btnWelcome = findViewById(R.id.btn_welcome);
        btnWelcome.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), LoginActivity.class);
            startActivity(intent);
        });
    }
}