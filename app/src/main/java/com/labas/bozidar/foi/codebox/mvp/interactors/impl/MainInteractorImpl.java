package com.labas.bozidar.foi.codebox.mvp.interactors.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

import com.labas.bozidar.foi.codebox.fragments.CounterFragment;
import com.labas.bozidar.foi.codebox.fragments.MainSelectionFragment;
import com.labas.bozidar.foi.codebox.mvp.interactors.MainInteractor;
import com.labas.bozidar.foi.codebox.mvp.listeners.OnButtonChangedListener;
import com.labas.bozidar.foi.codebox.util.Constants;

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

    @Override
    public void restoreData(Context context, OnButtonChangedListener listener) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREFS_KEY,Context.MODE_PRIVATE);
        String username = sharedPreferences.getString(Constants.KEY_USERNAME, "");
        int score = sharedPreferences.getInt(Constants.KEY_SCORE, 0);
        listener.setRestoredData(username, score);
    }

    @Override
    public void storeScoreSharedPrefs(Context context, OnButtonChangedListener listener) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.LOGIN_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constants.LOGIN_KEY, "storedUser");
        editor.apply();
    }
}
