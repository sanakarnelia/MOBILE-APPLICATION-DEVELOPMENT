package com.example.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        Button btn = view.findViewById(R.id.btnBack);
        btn.setOnClickListener(v -> {
            // Go back to FirstFragment
            requireActivity().getSupportFragmentManager().popBackStack();
        });

        return view;
    }
}