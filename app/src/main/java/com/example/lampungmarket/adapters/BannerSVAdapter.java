package com.example.lampungmarket.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.lampungmarket.R;
import com.example.lampungmarket.models.BannerItem;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class BannerSVAdapter extends SliderViewAdapter<BannerSVAdapter.SliderAdapterVH> {

    private Context context;
    private List<BannerItem> mSliderItems = new ArrayList<>();

    public BannerSVAdapter(Context context) {
        this.context = context;
    }

    public void renewItems(List<BannerItem> sliderItems) {
        this.mSliderItems = sliderItems;
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        this.mSliderItems.remove(position);
        notifyDataSetChanged();
    }

    public void addItem(BannerItem sliderItem) {
        this.mSliderItems.add(sliderItem);
        notifyDataSetChanged();
    }


    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.slideview_banner_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {
        BannerItem sliderItem = mSliderItems.get(position);

//        Glide.with(viewHolder.itemView)
//                .load(sliderItem.image_url)
//                .fitCenter()
//                .into(viewHolder.imageViewBackground);

        viewHolder.imageViewBackground.setImageResource(sliderItem.image);
        viewHolder.tvTitle.setText(sliderItem.title);
        viewHolder.tvDesc.setText(sliderItem.desc);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, "This is item in position " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getCount() {
        return mSliderItems.size();
    }

    public class SliderAdapterVH extends ViewHolder {
        View itemView;
        ImageView imageViewBackground;
        TextView tvTitle;
        TextView tvDesc;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            this.itemView = itemView;
        }
    }
}
