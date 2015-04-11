package com.labas.bozidar.foi.codebox.mvp.presenters;

/**
 * Created by bozidar on 24.03.15..
 */
public interface LoginPresenter {
    void validate(String username, String password);
    void sendRegistrationData(String username, String passwrod);

}
