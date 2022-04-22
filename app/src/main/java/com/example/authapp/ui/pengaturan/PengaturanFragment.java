package com.example.authapp.ui.pengaturan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.authapp.databinding.FragmentPengaturanBinding;
import com.example.authapp.databinding.FragmentPenjualanBinding;
import com.example.authapp.ui.penjualan.PengaturanViewModel;

public class PengaturanFragment extends Fragment {

    private FragmentPengaturanBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PengaturanViewModel pengaturanViewModel =
                new ViewModelProvider(this).get(PengaturanViewModel.class);

        binding = FragmentPengaturanBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textPengaturan;
        pengaturanViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}