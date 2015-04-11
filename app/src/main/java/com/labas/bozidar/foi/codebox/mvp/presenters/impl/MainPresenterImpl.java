package com.labas.bozidar.foi.codebox.mvp.presenters.impl;

import android.app.Fragment;
import android.view.View;

import com.labas.bozidar.foi.codebox.mvp.interactors.MainInteractor;
import com.labas.bozidar.foi.codebox.mvp.listeners.OnButtonChangedListener;
import com.labas.bozidar.foi.codebox.mvp.presenters.MainPresenter;
import com.labas.bozidar.foi.codebox.mvp.views.MainView;

/**
 * Created by bozidar on 25.03.15..
 */
public class MainPresenterImpl implements MainPresenter, OnButtonChangedListener {

    private MainView mainView;
    private MainInteractor mainInteractor;


    public MainPresenterImpl(MainView mainView, MainInteractor mainInteractor){
        this.mainView = mainView;
        this.mainInteractor = mainInteractor;
    }

    @Override
    public void onLangButtonClicked(View view) {
        mainInteractor.changeBackgroundStyle(view, this);
    }

    @Override
    public void changeSelectedButtonStyle(View view) {
        mainView.onChangeSelectedButton(view);
    }

    @Override
    public void changePreviousButtonStyle(View view) {
        mainView.onChangePreviousButton(view);
    }

    @Override
    public void changeAnimation(Fragment fragment) {
        mainView.setFragmentTransition(fragment);
    }


    @Override
    public void changeTimmerText(String text) {
        mainView.onChangeCounterText(text);
    }

}
