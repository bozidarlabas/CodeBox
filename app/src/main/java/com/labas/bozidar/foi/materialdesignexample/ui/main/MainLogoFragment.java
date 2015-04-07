package com.labas.bozidar.foi.materialdesignexample.ui.main;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.labas.bozidar.foi.materialdesignexample.R;


public class MainLogoFragment extends Fragment {


    public static MainLogoFragment newInstance() {
        MainLogoFragment fragment = new MainLogoFragment();
        return fragment;
    }

    public MainLogoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_logo, container, false);
    }
}
