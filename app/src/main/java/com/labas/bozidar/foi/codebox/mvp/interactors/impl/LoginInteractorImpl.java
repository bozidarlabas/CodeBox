package com.labas.bozidar.foi.codebox.mvp.interactors.impl;

import android.os.Handler;
import android.text.TextUtils;

import com.labas.bozidar.foi.codebox.mvp.interactors.LoginInteractor;
import com.labas.bozidar.foi.codebox.mvp.listeners.OnLoginFInishedListener;

/**
 * Created by bozidar on 25.03.15..
 */
public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void login(final String username, final String password, final OnLoginFInishedListener listener) {
        // Mock login. I'm creating a handler to delay the answer a couple of seconds
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(username)){
                    listener.onUsernameError();
                    error = true;
                }
                if (TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    error = true;
                }
                if (!error){
                    listener.onSuccess();
                }
            }
        }, 100);
    }
}
