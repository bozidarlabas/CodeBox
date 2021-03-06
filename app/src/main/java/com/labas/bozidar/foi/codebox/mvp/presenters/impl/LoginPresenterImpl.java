package com.labas.bozidar.foi.codebox.mvp.presenters.impl;

import com.labas.bozidar.foi.codebox.mvp.interactors.LoginInteractor;
import com.labas.bozidar.foi.codebox.mvp.listeners.OnLoginFInishedListener;
import com.labas.bozidar.foi.codebox.mvp.models.User;
import com.labas.bozidar.foi.codebox.mvp.presenters.LoginPresenter;
import com.labas.bozidar.foi.codebox.mvp.views.LoginView;

import javax.inject.Inject;

/**
 * Created by bozidar on 24.03.15..
 */
public class LoginPresenterImpl implements LoginPresenter, OnLoginFInishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    @Inject
    public LoginPresenterImpl(LoginView loginView, LoginInteractor loginInteractor){

        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }

    //LOGIN (activity)
    @Override
    public void validate(String username, String password) {
        loginView.showProgress();
        loginInteractor.login(username, password, this);
    }


    @Override
    public void onUsernameError() {
        loginView.setUsernameError();
        loginView.hideProgress();
    }

    @Override
    public void onPasswordError() {
        loginView.setPasswordError();
        loginView.hideProgress();
    }

    @Override
    public void onSuccess(User user) {
        loginView.navigateToHome(user);

    }

    @Override
    public void onHideProgress() {
        loginView.hideProgress();
    }

    @Override
    public void onFailure() {
        loginView.showErrorDialog();
    }

    //REGISTER (dialog inside activity)

    @Override
    public void sendRegistrationData(String username, String password) {
        loginInteractor.register(username, password);
    }




}
