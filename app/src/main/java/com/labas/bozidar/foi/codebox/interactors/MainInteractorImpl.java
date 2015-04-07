package com.labas.bozidar.foi.codebox.interactors;

import android.view.View;

import com.labas.bozidar.foi.codebox.ui.main.presenters.OnButtonChangedListener;

/**
 * Created by bozidar on 26.03.15..
 */
public class MainInteractorImpl implements MainInteractor{

    private View lastSelectedView;

    @Override
    public void changeBackgroundStyle(View view, OnButtonChangedListener listener) {
        if(!view.equals(lastSelectedView)){
            listener.changeSelectedButtonStyle(view);
            if(lastSelectedView != null){
                listener.changePreviousButtonStyle(lastSelectedView);
            }
            lastSelectedView = view;
        }
       listener.changeAnimation();
    }

    //TODO add animation listener
/*
    @Override
    public void onAnimationStart() {
        if(!firstTimeCLicked)
            animatorSet.start();
    }

    */
}
