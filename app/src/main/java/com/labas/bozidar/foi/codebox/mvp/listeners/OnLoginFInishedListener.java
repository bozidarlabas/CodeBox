package com.labas.bozidar.foi.codebox.mvp.listeners;

import com.labas.bozidar.foi.codebox.mvp.models.User;

/**
 * Created by bozidar on 25.03.15..
 */
public interface OnLoginFInishedListener {
    public void onUsernameError();

    public void onPasswordError();

    public void onSuccess(User user);

    public void onHideProgress();

    public void onFailure();
}
