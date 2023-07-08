package com.example.lampungmarket.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lampungmarket.R;
import com.example.lampungmarket.models.ShopItem;

import java.util.List;

public class ShopGridRVAdapter extends BaseAdapter {
    ShopItem[] items;
    Context context;

    public ShopGridRVAdapter(ShopItem[] items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int index, View view, ViewGroup viewGroup) {
        if(view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.gridview_shop_item, null);
        }

        ImageView ivImg = view.findViewById(R.id.iv_img);
        TextView tvTitle = view.findViewById(R.id.tv_title);

        Glide.with(context)
                .load(items[index].image_url)
                .centerCrop()
                .into(ivImg);

        tvTitle.setText(items[index].name);

        return view;
    }
}

