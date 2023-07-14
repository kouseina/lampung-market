package com.example.lampungmarket.ui.search;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.lampungmarket.DetailActivity;
import com.example.lampungmarket.adapters.ShopGridRVAdapter;
import com.example.lampungmarket.api.RetrofitClient;
import com.example.lampungmarket.databinding.FragmentSearchBinding;
import com.example.lampungmarket.models.GetAllShopRequest;
import com.example.lampungmarket.models.GetAllShopResponse;
import com.example.lampungmarket.models.ShopItem;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment {

    private FragmentSearchBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SearchViewModel dashboardViewModel =
                new ViewModelProvider(this).get(SearchViewModel.class);

        binding = FragmentSearchBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.etSearch.setOnEditorActionListener((textView, actionId, keyEvent) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                getAllShop();

                return true;
            }

            return false;
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void getAllShop() {
        binding.pbShop.setVisibility(View.VISIBLE);
        binding.gvShop.setVisibility(View.GONE);

        RetrofitClient.instance().getAllShop(new GetAllShopRequest(binding.etSearch.getText().toString())).enqueue(new Callback<GetAllShopResponse>() {
            @Override
            public void onResponse(Call<GetAllShopResponse> call, Response<GetAllShopResponse> response) {
                binding.pbShop.setVisibility(View.GONE);
                binding.gvShop.setVisibility(View.VISIBLE);

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