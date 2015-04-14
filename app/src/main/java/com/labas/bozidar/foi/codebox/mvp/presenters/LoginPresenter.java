package com.labas.bozidar.foi.codebox.mvp.presenters;

import android.content.Context;

/**
 * Created by bozidar on 24.03.15..
 */
public interface LoginPresenter {
    void validate(String username, String password, Context context);
    void sendRegistrationData(String username, String passwrod);
    void checkRegisteredUser(Context context);

}
