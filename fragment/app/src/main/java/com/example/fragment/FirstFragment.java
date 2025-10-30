package com.example.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate layout
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        Button btn = view.findViewById(R.id.btnGoToSecond);
        btn.setOnClickListener(v -> {
            // Replace current fragment with SecondFragment
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new SecondFragment())
                    .addToBackStack(null) // allows going back
                    .commit();
        });

        return view;
    }
}