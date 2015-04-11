package com.labas.bozidar.foi.codebox.mvp.interactors.impl;

import android.view.View;

import com.labas.bozidar.foi.codebox.fragments.CounterFragment;
import com.labas.bozidar.foi.codebox.fragments.MainSelectionFragment;
import com.labas.bozidar.foi.codebox.mvp.interactors.MainInteractor;
import com.labas.bozidar.foi.codebox.mvp.listeners.OnButtonChangedListener;

/**
 * Created by bozidar on 26.03.15..
 */
public class MainInteractorImpl implements MainInteractor {

    private View lastSelectedView;
    private boolean selectedButton;
    private MainSelectionFragment fragment;
    private CounterFragment fragmentCounter;
    long time;
    public static final String ENDPOINT = "http://bozidarlabas.me";

    public MainInteractorImpl() {
        fragment = new MainSelectionFragment();
        fragmentCounter = new CounterFragment();
    }

    @Override
    public void changeBackgroundStyle(View view, OnButtonChangedListener listener) {
        if (!view.equals(lastSelectedView)) {
            listener.changeSelectedButtonStyle(view);
            if (lastSelectedView != null) {
                listener.changePreviousButtonStyle(lastSelectedView);
            }
            lastSelectedView = view;
        }
        if (!selectedButton)
            listener.changeAnimation(fragment);
        selectedButton = true;
    }
}
