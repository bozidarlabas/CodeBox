package com.labas.bozidar.foi.codebox.mvp.interactors.impl;

import android.text.TextUtils;
import android.util.Log;

import com.labas.bozidar.foi.codebox.mvp.interactors.LoginInteractor;
import com.labas.bozidar.foi.codebox.mvp.listeners.OnLoginFInishedListener;
import com.labas.bozidar.foi.codebox.mvp.models.RequestAPI;
import com.labas.bozidar.foi.codebox.mvp.models.User;
import com.labas.bozidar.foi.codebox.util.Constants;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by bozidar on 25.03.15..
 */
public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void login(final String username, final String password, final OnLoginFInishedListener listener) {
        boolean error = false;
        if (TextUtils.isEmpty(username)){
            listener.onUsernameError();
            error = true;
        }


        if(TextUtils.isEmpty(password)){
            listener.onPasswordError();
            error = true;
        }

        if(!error){
            RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(Constants.SERVER_ENDPOINT).build();
            RequestAPI api = restAdapter.create(RequestAPI.class);
            api.sendLoginRequest(username, password, new Callback<User>(){

                @Override
                public void success(User user, Response response) {

                   if(user  != null){
                       listener.onSuccess(user);
                   }else{
                       listener.onFailure();
                   }
                   listener.onHideProgress();
                }

                @Override
                public void failure(RetrofitError error) {
                    listener.onHideProgress();
                    listener.onFailure();
                }
            });
        }

    }

    //TODO send data to backend where data will be stored in database
    @Override
    public void register(String username, String password) {
        Log.d("tetere", password);
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(Constants.SERVER_ENDPOINT).build();
        RequestAPI post = restAdapter.create(RequestAPI.class);
        post.sendRegistrationRequest("registration", username, password, new Callback<String>() {
            @Override
            public void success(String s, Response response) {
                Log.d("success", "success");
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("error", error.toString());
            }
        });
    }
}
