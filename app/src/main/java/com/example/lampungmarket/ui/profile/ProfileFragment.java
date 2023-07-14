package com.example.lampungmarket.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.lampungmarket.WelcomeActivity;
import com.example.lampungmarket.databinding.FragmentProfileBinding;
import com.example.lampungmarket.models.UserItem;
import com.example.lampungmarket.storage.SharedPrefManager;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel notificationsViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = com.example.lampungmarket.databinding.FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        UserItem userItem = SharedPrefManager.getUser(getContext());

        binding.tvFullName.setText(userItem.fullname);
        binding.tvEmail.setText(userItem.email);
        binding.tvPhone.setText(userItem.phone);

        binding.btnLogout.setOnClickListener(view -> {
            SharedPrefManager.clearAll(getContext());

            Toast.makeText(getContext(), "Logout succeed", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(getContext(), WelcomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            startActivity(intent);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}