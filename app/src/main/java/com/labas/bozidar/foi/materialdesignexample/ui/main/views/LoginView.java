package com.labas.bozidar.foi.materialdesignexample.ui.main.views;

/**
 * Created by bozidar on 24.03.15..
 */
public interface LoginView {
    public void showProgress();

    public void hideProgress();

    public void setUsernameError();

    public void setPasswordError();

    public void navigateToHome();
}
