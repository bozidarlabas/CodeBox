package com.labas.bozidar.foi.codebox.mvp.views;

import com.labas.bozidar.foi.codebox.mvp.models.User;

/**
 * Created by bozidar on 24.03.15..
 */
public interface LoginView {
    public void showProgress();

    public void hideProgress();

    public void setUsernameError();

    public void setPasswordError();

    public void navigateToHome(User user);

    public void showErrorDialog();
}
