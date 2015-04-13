package com.labas.bozidar.foi.codebox.fragments;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.labas.bozidar.foi.codebox.R;
import com.labas.bozidar.foi.codebox.dialogs.NotificationDialog;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainSelectionFragment extends Fragment {

    OnActivityTransition listener;
    private NotificationDialog notificationDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_selection, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        notificationDialog = new NotificationDialog(getActivity());
    }

    @OnClick(R.id.btnPlay)
    protected void playQuiz(View v) {
        listener.navigateToQuizActivity();
    }

    @OnClick(R.id.btnExit)
    public void exitApplication(View v) {
        notificationDialog.setDialogArgs(getActivity(), "Exit", "Are you sure you want to exit?");
        notificationDialog.showDialog();
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
