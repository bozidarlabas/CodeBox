package com.labas.bozidar.foi.codebox.mvp.interactors;

import com.labas.bozidar.foi.codebox.mvp.listeners.OnLoginFInishedListener;

/**
 * Created by bozidar on 25.03.15..
 */
public interface LoginInteractor {
    public void login(String username, String password, OnLoginFInishedListener listener);
    public void register(String username, String password);
}
