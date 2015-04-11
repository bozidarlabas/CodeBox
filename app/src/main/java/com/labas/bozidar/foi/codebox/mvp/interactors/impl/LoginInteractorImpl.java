package com.labas.bozidar.foi.codebox.mvp.interactors.impl;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import com.labas.bozidar.foi.codebox.mvp.interactors.LoginInteractor;
import com.labas.bozidar.foi.codebox.mvp.listeners.OnLoginFInishedListener;
import com.labas.bozidar.foi.codebox.mvp.models.RequestAPI;
import com.labas.bozidar.foi.codebox.util.Constants;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by bozidar on 25.03.15..
 */
public class LoginInteractorImpl implements LoginInteractor {

    //TODO this is just testing login with hardcoded data
    @Override
    public void login(final String username, final String password, final OnLoginFInishedListener listener) {
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

    //TODO send data to backend where data will be stored in database
    @Override
    public void register(String username, String password) {
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(Constants.SERVER_ENDPOINT).build();
        RequestAPI post = restAdapter.create(RequestAPI.class);
        post.sendRegistrationRequest(username, password, new Callback<String>() {
            @Override
            public void success(String s, Response response) {
                Log.d("success", "success");
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("error", "success");
            }
        });



    }
}
