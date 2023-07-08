package com.example.lampungmarket.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.lampungmarket.adapters.ShopGridRVAdapter;
import com.example.lampungmarket.databinding.FragmentHomeBinding;
import com.example.lampungmarket.models.ShopItem;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ShopItem[] shopItems = new ShopItem[]{
                new ShopItem(0, "Lampung Banana Foster", "Salah satu pusat oleh-oleh Lampung yang sudah tersohor namanya adalah Toko Manisan Yen-Yen. Toko oleh-oleh ini menyediakan berbagai buah tangan khas Lampung yang patut kamu bawa pulang untuk sanak saudara di rumah. Seperti namanya, toko buah tangan Lampung ini menjual beragam manisan seperti manisan mangga, salak, pepaya, pala dan manisan lainnya. Tak hanya itu, Tempat oleh-oleh Lampung Yen-Yen juga menyediakan lempok durian, kopi khas Lampung serta dodol durian. Uniknya, kamu juga bisa mencoba tester dari produknya terlebih dahulu sebelum membeli. Jadi, semakin tidak sabar mengunjunginya bukan?", 50000, "https://source.unsplash.com/random/?shop", "https://goo.gl/maps/GUVAbrQALh2C8jqRA"),
                new ShopItem(1, "Lampung Banana Foster", "Salah satu pusat oleh-oleh Lampung yang sudah tersohor namanya adalah Toko Manisan Yen-Yen. Toko oleh-oleh ini menyediakan berbagai buah tangan khas Lampung yang patut kamu bawa pulang untuk sanak saudara di rumah. Seperti namanya, toko buah tangan Lampung ini menjual beragam manisan seperti manisan mangga, salak, pepaya, pala dan manisan lainnya. Tak hanya itu, Tempat oleh-oleh Lampung Yen-Yen juga menyediakan lempok durian, kopi khas Lampung serta dodol durian. Uniknya, kamu juga bisa mencoba tester dari produknya terlebih dahulu sebelum membeli. Jadi, semakin tidak sabar mengunjunginya bukan?", 50000, "https://source.unsplash.com/random/?shop", "https://goo.gl/maps/GUVAbrQALh2C8jqRA"),
                new ShopItem(2, "Lampung Banana Foster", "Salah satu pusat oleh-oleh Lampung yang sudah tersohor namanya adalah Toko Manisan Yen-Yen. Toko oleh-oleh ini menyediakan berbagai buah tangan khas Lampung yang patut kamu bawa pulang untuk sanak saudara di rumah. Seperti namanya, toko buah tangan Lampung ini menjual beragam manisan seperti manisan mangga, salak, pepaya, pala dan manisan lainnya. Tak hanya itu, Tempat oleh-oleh Lampung Yen-Yen juga menyediakan lempok durian, kopi khas Lampung serta dodol durian. Uniknya, kamu juga bisa mencoba tester dari produknya terlebih dahulu sebelum membeli. Jadi, semakin tidak sabar mengunjunginya bukan?", 50000, "https://source.unsplash.com/random/?shop", "https://goo.gl/maps/GUVAbrQALh2C8jqRA"),
                new ShopItem(3, "Lampung Banana Foster", "Salah satu pusat oleh-oleh Lampung yang sudah tersohor namanya adalah Toko Manisan Yen-Yen. Toko oleh-oleh ini menyediakan berbagai buah tangan khas Lampung yang patut kamu bawa pulang untuk sanak saudara di rumah. Seperti namanya, toko buah tangan Lampung ini menjual beragam manisan seperti manisan mangga, salak, pepaya, pala dan manisan lainnya. Tak hanya itu, Tempat oleh-oleh Lampung Yen-Yen juga menyediakan lempok durian, kopi khas Lampung serta dodol durian. Uniknya, kamu juga bisa mencoba tester dari produknya terlebih dahulu sebelum membeli. Jadi, semakin tidak sabar mengunjunginya bukan?", 50000, "https://source.unsplash.com/random/?shop", "https://goo.gl/maps/GUVAbrQALh2C8jqRA"),
                new ShopItem(4, "Lampung Banana Foster", "Salah satu pusat oleh-oleh Lampung yang sudah tersohor namanya adalah Toko Manisan Yen-Yen. Toko oleh-oleh ini menyediakan berbagai buah tangan khas Lampung yang patut kamu bawa pulang untuk sanak saudara di rumah. Seperti namanya, toko buah tangan Lampung ini menjual beragam manisan seperti manisan mangga, salak, pepaya, pala dan manisan lainnya. Tak hanya itu, Tempat oleh-oleh Lampung Yen-Yen juga menyediakan lempok durian, kopi khas Lampung serta dodol durian. Uniknya, kamu juga bisa mencoba tester dari produknya terlebih dahulu sebelum membeli. Jadi, semakin tidak sabar mengunjunginya bukan?", 50000, "https://source.unsplash.com/random/?shop", "https://goo.gl/maps/GUVAbrQALh2C8jqRA"),
                new ShopItem(5, "Lampung Banana Foster", "Salah satu pusat oleh-oleh Lampung yang sudah tersohor namanya adalah Toko Manisan Yen-Yen. Toko oleh-oleh ini menyediakan berbagai buah tangan khas Lampung yang patut kamu bawa pulang untuk sanak saudara di rumah. Seperti namanya, toko buah tangan Lampung ini menjual beragam manisan seperti manisan mangga, salak, pepaya, pala dan manisan lainnya. Tak hanya itu, Tempat oleh-oleh Lampung Yen-Yen juga menyediakan lempok durian, kopi khas Lampung serta dodol durian. Uniknya, kamu juga bisa mencoba tester dari produknya terlebih dahulu sebelum membeli. Jadi, semakin tidak sabar mengunjunginya bukan?", 50000, "https://source.unsplash.com/random/?shop", "https://goo.gl/maps/GUVAbrQALh2C8jqRA"),
        };

        ShopGridRVAdapter shopGridRVAdapter = new ShopGridRVAdapter(shopItems, getContext());
        binding.gvShop.setAdapter(shopGridRVAdapter);
        binding.gvShop.isExpanded = true;

        binding.gvShop.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return motionEvent.getAction() == MotionEvent.ACTION_MOVE;
            }

        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}