package com.labas.bozidar.foi.materialdesignexample.ui.main.presenters;

import com.labas.bozidar.foi.materialdesignexample.interactors.LoginInteractor;
import com.labas.bozidar.foi.materialdesignexample.ui.main.views.LoginView;

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

    @Override
    public void validate(String username, String password) {
        loginView.showProgress();
        loginInteractor.login(username, password, this);
    }


    @Override
    public void onUsernameError() {
        loginView.setUsernameError();
    }

    @Override
    public void onPasswordError() {
        loginView.setPasswordError();
    }

    @Override
    public void onSuccess() {
        loginView.navigateToHome();
    }
}
