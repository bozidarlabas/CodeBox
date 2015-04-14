package com.labas.bozidar.foi.codebox.mvp.interactors.impl;

import android.content.Context;
import android.content.SharedPreferences;
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

    private Context context;

    @Override
    public void login(final String username, final String password, final Context context, final OnLoginFInishedListener listener) {
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
                       storeScoreSharedPrefs(context, user.getScore(), user.getUsername());
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

    public void restoreData(Context context, OnLoginFInishedListener listener) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.LOGIN_KEY,Context.MODE_PRIVATE);
        String key = sharedPreferences.getString(Constants.LOGIN_KEY, "");
        if(key != ""){
            listener.onHideREgisterBtn();
        }
    }

    public void storeScoreSharedPrefs(Context context, int score, String username) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREFS_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constants.KEY_USERNAME, username);
        editor.putInt(Constants.KEY_SCORE, score);
        editor.apply();
    }
}
