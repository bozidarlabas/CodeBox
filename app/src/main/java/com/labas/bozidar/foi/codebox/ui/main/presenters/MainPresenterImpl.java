package com.labas.bozidar.foi.codebox.ui.main.presenters;

import android.view.View;

import com.labas.bozidar.foi.codebox.interactors.MainInteractor;
import com.labas.bozidar.foi.codebox.ui.main.views.MainView;

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
    public void onButtonClicked(View view) {
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
    public void changeAnimation() {
        mainView.setAnimation();
    }
}
