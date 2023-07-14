package com.example.lampungmarket.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.lampungmarket.DetailActivity;
import com.example.lampungmarket.R;
import com.example.lampungmarket.adapters.BannerSVAdapter;
import com.example.lampungmarket.adapters.ShopGridRVAdapter;
import com.example.lampungmarket.api.RetrofitClient;
import com.example.lampungmarket.databinding.FragmentHomeBinding;
import com.example.lampungmarket.models.BannerItem;
import com.example.lampungmarket.models.DefaultResponse;
import com.example.lampungmarket.models.GetAllShopRequest;
import com.example.lampungmarket.models.GetAllShopResponse;
import com.example.lampungmarket.models.ShopItem;
import com.smarteist.autoimageslider.SliderView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

//    ShopItem[] shopItems = new ShopItem[]{
//            new ShopItem(0, "Lampung Banana Foster", "Salah satu pusat oleh-oleh Lampung yang sudah tersohor namanya adalah Toko Manisan Yen-Yen. Toko oleh-oleh ini menyediakan berbagai buah tangan khas Lampung yang patut kamu bawa pulang untuk sanak saudara di rumah. Seperti namanya, toko buah tangan Lampung ini menjual beragam manisan seperti manisan mangga, salak, pepaya, pala dan manisan lainnya. Tak hanya itu, Tempat oleh-oleh Lampung Yen-Yen juga menyediakan lempok durian, kopi khas Lampung serta dodol durian. Uniknya, kamu juga bisa mencoba tester dari produknya terlebih dahulu sebelum membeli. Jadi, semakin tidak sabar mengunjunginya bukan?", 50000, "https://source.unsplash.com/random/?shop", "https://goo.gl/maps/GUVAbrQALh2C8jqRA", "Jalan Ikan Kakap Nomor 86, Pesawahan, Kota Bandar Lampung", "07.30 – 21.00 WIB"),
//            new ShopItem(1, "Lampung Banana Foster", "Salah satu pusat oleh-oleh Lampung yang sudah tersohor namanya adalah Toko Manisan Yen-Yen. Toko oleh-oleh ini menyediakan berbagai buah tangan khas Lampung yang patut kamu bawa pulang untuk sanak saudara di rumah. Seperti namanya, toko buah tangan Lampung ini menjual beragam manisan seperti manisan mangga, salak, pepaya, pala dan manisan lainnya. Tak hanya itu, Tempat oleh-oleh Lampung Yen-Yen juga menyediakan lempok durian, kopi khas Lampung serta dodol durian. Uniknya, kamu juga bisa mencoba tester dari produknya terlebih dahulu sebelum membeli. Jadi, semakin tidak sabar mengunjunginya bukan?", 50000, "https://source.unsplash.com/random/?shop", "https://goo.gl/maps/GUVAbrQALh2C8jqRA", "Jalan Ikan Kakap Nomor 86, Pesawahan, Kota Bandar Lampung", "07.30 – 21.00 WIB"),
//            new ShopItem(2, "Lampung Banana Foster", "Salah satu pusat oleh-oleh Lampung yang sudah tersohor namanya adalah Toko Manisan Yen-Yen. Toko oleh-oleh ini menyediakan berbagai buah tangan khas Lampung yang patut kamu bawa pulang untuk sanak saudara di rumah. Seperti namanya, toko buah tangan Lampung ini menjual beragam manisan seperti manisan mangga, salak, pepaya, pala dan manisan lainnya. Tak hanya itu, Tempat oleh-oleh Lampung Yen-Yen juga menyediakan lempok durian, kopi khas Lampung serta dodol durian. Uniknya, kamu juga bisa mencoba tester dari produknya terlebih dahulu sebelum membeli. Jadi, semakin tidak sabar mengunjunginya bukan?", 50000, "https://source.unsplash.com/random/?shop", "https://goo.gl/maps/GUVAbrQALh2C8jqRA", "Jalan Ikan Kakap Nomor 86, Pesawahan, Kota Bandar Lampung", "07.30 – 21.00 WIB"),
//            new ShopItem(3, "Lampung Banana Foster", "Salah satu pusat oleh-oleh Lampung yang sudah tersohor namanya adalah Toko Manisan Yen-Yen. Toko oleh-oleh ini menyediakan berbagai buah tangan khas Lampung yang patut kamu bawa pulang untuk sanak saudara di rumah. Seperti namanya, toko buah tangan Lampung ini menjual beragam manisan seperti manisan mangga, salak, pepaya, pala dan manisan lainnya. Tak hanya itu, Tempat oleh-oleh Lampung Yen-Yen juga menyediakan lempok durian, kopi khas Lampung serta dodol durian. Uniknya, kamu juga bisa mencoba tester dari produknya terlebih dahulu sebelum membeli. Jadi, semakin tidak sabar mengunjunginya bukan?", 50000, "https://source.unsplash.com/random/?shop", "https://goo.gl/maps/GUVAbrQALh2C8jqRA", "Jalan Ikan Kakap Nomor 86, Pesawahan, Kota Bandar Lampung", "07.30 – 21.00 WIB"),
//            new ShopItem(4, "Lampung Banana Foster", "Salah satu pusat oleh-oleh Lampung yang sudah tersohor namanya adalah Toko Manisan Yen-Yen. Toko oleh-oleh ini menyediakan berbagai buah tangan khas Lampung yang patut kamu bawa pulang untuk sanak saudara di rumah. Seperti namanya, toko buah tangan Lampung ini menjual beragam manisan seperti manisan mangga, salak, pepaya, pala dan manisan lainnya. Tak hanya itu, Tempat oleh-oleh Lampung Yen-Yen juga menyediakan lempok durian, kopi khas Lampung serta dodol durian. Uniknya, kamu juga bisa mencoba tester dari produknya terlebih dahulu sebelum membeli. Jadi, semakin tidak sabar mengunjunginya bukan?", 50000, "https://source.unsplash.com/random/?shop", "https://goo.gl/maps/GUVAbrQALh2C8jqRA", "Jalan Ikan Kakap Nomor 86, Pesawahan, Kota Bandar Lampung", "07.30 – 21.00 WIB"),
//            new ShopItem(5, "Lampung Banana Foster", "Salah satu pusat oleh-oleh Lampung yang sudah tersohor namanya adalah Toko Manisan Yen-Yen. Toko oleh-oleh ini menyediakan berbagai buah tangan khas Lampung yang patut kamu bawa pulang untuk sanak saudara di rumah. Seperti namanya, toko buah tangan Lampung ini menjual beragam manisan seperti manisan mangga, salak, pepaya, pala dan manisan lainnya. Tak hanya itu, Tempat oleh-oleh Lampung Yen-Yen juga menyediakan lempok durian, kopi khas Lampung serta dodol durian. Uniknya, kamu juga bisa mencoba tester dari produknya terlebih dahulu sebelum membeli. Jadi, semakin tidak sabar mengunjunginya bukan?", 50000, "https://source.unsplash.com/random/?shop", "https://goo.gl/maps/GUVAbrQALh2C8jqRA", "Jalan Ikan Kakap Nomor 86, Pesawahan, Kota Bandar Lampung", "07.30 – 21.00 WIB"),
//    };

    BannerItem[] bannerItems = new BannerItem[]{
            new BannerItem(R.drawable.img_banner1, "Lampung Banana Foster", "Sempurnakan Silaturahmi Dengan Lampung Banana Foster Enak Mantap"),
            new BannerItem(R.drawable.img_banner2, "Lampung Banana Foster", "Sempurnakan Silaturahmi Dengan Lampung Banana Foster Enak Mantap"),
            new BannerItem(R.drawable.img_banner3, "Toko Manisan Yen-Yen", "Cari yang manis-manis ya Yen-Yen aja. Semua manisan ada disini"),
    };

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        SliderView sliderView = binding.svBanner;
        BannerSVAdapter bannerSVAdapter = new BannerSVAdapter(getContext());
        bannerSVAdapter.addItem(bannerItems[0]);
        bannerSVAdapter.addItem(bannerItems[1]);
        bannerSVAdapter.addItem(bannerItems[2]);

        sliderView.setSliderAdapter(bannerSVAdapter);

        Log.d("Home Fragment", "on create view");

        getAllShop();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void getAllShop() {
        RetrofitClient.instance().getAllShop(new GetAllShopRequest("")).enqueue(new Callback<GetAllShopResponse>() {
            @Override
            public void onResponse(Call<GetAllShopResponse> call, Response<GetAllShopResponse> response) {
                binding.pbShop.setVisibility(View.GONE);

                Log.d("Home Fragment : ", "on response");
                if (response.code() == 200) {
                    final ShopItem[] data = response.body().getData();
                    Log.d("Home Fragment : ", data.toString());

                    ShopGridRVAdapter shopGridRVAdapter = new ShopGridRVAdapter(data, getContext());
                    binding.gvShop.setAdapter(shopGridRVAdapter);
                    binding.gvShop.isExpanded = true;

                    binding.gvShop.setOnTouchListener(new View.OnTouchListener() {

                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            return motionEvent.getAction() == MotionEvent.ACTION_MOVE;
                        }

                    });

                    binding.gvShop.setOnItemClickListener((adapterView, view, position, l) -> {
                        Intent intent = new Intent(getContext(), DetailActivity.class)
                                .putExtra("data", data[position]);
                        startActivity(intent);
                    });
                }
            }

            @Override
            public void onFailure(Call<GetAllShopResponse> call, Throwable t) {
                Log.d("Home Fragment", "on failure get all shop : " + t.getMessage());
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}