package com.labas.bozidar.foi.codebox.fragments.questions;

import android.app.Activity;
import android.app.Fragment;

import com.labas.bozidar.foi.codebox.mvp.listeners.OnQuestionAnswered;

/**
 * Created by bozidar on 11.04.15..
 */
public class BaseQuestionFragment  extends Fragment{

    OnQuestionAnswered listener;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (OnQuestionAnswered) activity;
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

}
