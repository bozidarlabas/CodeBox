package com.labas.bozidar.foi.materialdesignexample.ui.main;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.labas.bozidar.foi.materialdesignexample.R;


public class MainSelectionFragment extends Fragment {


    public static MainSelectionFragment newInstance(String param1, String param2) {
        MainSelectionFragment fragment = new MainSelectionFragment();
        return fragment;
    }

    public MainSelectionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_selection, container, false);
    }


}
