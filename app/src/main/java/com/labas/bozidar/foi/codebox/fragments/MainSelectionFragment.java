package com.labas.bozidar.foi.codebox.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.labas.bozidar.foi.codebox.R;
import com.labas.bozidar.foi.codebox.activities.MainActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainSelectionFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_selection, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @OnClick(R.id.btnPlay)
    protected void playQuiz(View v) {
        MainActivity activity = (MainActivity) getActivity();
        activity.mainPresenter.onPlayButtonClicked();
    }
}
