package com.example.lampungmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lampungmarket.models.ShopItem;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ShopItem shopItem = (ShopItem) getIntent().getSerializableExtra("data");

        TextView tvBack = findViewById(R.id.tv_back);

        tvBack.setOnClickListener(view -> {
            onBackPressed();
        });

        TextView tvTitle = findViewById(R.id.tv_title);
        ImageView ivThumbnail = findViewById(R.id.iv_thumbnail);
        TextView tvDesc = findViewById(R.id.tv_desc);
        TextView tvAddress = findViewById(R.id.tv_address);
        TextView tvPrice = findViewById(R.id.tv_price);
        Button btnMap = findViewById(R.id.btn_map);

        tvTitle.setText(shopItem.name);
        Glide.with(getApplicationContext())
                .load(shopItem.image_url)
                .fitCenter()
                .into(ivThumbnail);
        tvDesc.setText(shopItem.description);
        tvAddress.setText(shopItem.address);
        tvPrice.setText(shopItem.price);

        btnMap.setOnClickListener(view -> {
            Uri gmmIntentUri = Uri.parse(shopItem.maps_url);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        });
    }
}