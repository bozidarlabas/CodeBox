package com.labas.bozidar.foi.materialdesignexample.interactors;

import com.labas.bozidar.foi.materialdesignexample.ui.main.presenters.OnLoginFInishedListener;

/**
 * Created by bozidar on 25.03.15..
 */
public interface LoginInteractor {
    public void login(String username, String password, OnLoginFInishedListener listener);
}
