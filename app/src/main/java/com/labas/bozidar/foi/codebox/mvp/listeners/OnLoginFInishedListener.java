package com.labas.bozidar.foi.codebox.mvp.listeners;

/**
 * Created by bozidar on 25.03.15..
 */
public interface OnLoginFInishedListener {
    public void onUsernameError();

    public void onPasswordError();

    public void onSuccess();
}
