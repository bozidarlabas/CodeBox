package com.labas.bozidar.foi.codebox.fragments;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.labas.bozidar.foi.codebox.R;
import com.labas.bozidar.foi.codebox.activities.MainActivity;
import com.labas.bozidar.foi.codebox.activities.QuizActivity;

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

    private void setActivityTransition() {
        startActivity(new Intent(getActivity(), QuizActivity.class));
        getActivity().overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    @OnClick(R.id.btnPlay)
    protected void playQuiz(View v) {
        MainActivity activity = (MainActivity) getActivity();
        setActivityTransition();
    }

    @OnClick(R.id.btnExit)
    public void exitApplication(View v) {
        getActivity().finish();
        System.exit(0);
    }
}
