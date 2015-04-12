package com.labas.bozidar.foi.codebox.fragments;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.labas.bozidar.foi.codebox.R;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainSelectionFragment extends Fragment {

    OnActivityTransition listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_selection, container, false);
        ButterKnife.inject(this, view);
        return view;
    }



    @OnClick(R.id.btnPlay)
    protected void playQuiz(View v) {
        listener.navigateToQuizActivity();
    }

    @OnClick(R.id.btnExit)
    public void exitApplication(View v) {
        getActivity().finish();
        System.exit(0);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (OnActivityTransition) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface OnActivityTransition{
        public void navigateToQuizActivity();
    }
}
