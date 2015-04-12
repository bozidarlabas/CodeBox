package com.labas.bozidar.foi.codebox.mvp.models;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by bozidar on 08.04.15..
 */
public interface RequestAPI {

    @FormUrlEncoded
    @POST("/CodeBox/codebox.php")
    public void getQuestion(@Field("questions") String questions, Callback<List<Question>> response);

    @FormUrlEncoded
    @POST("/CodeBox/registration.php")
    public void sendRegistrationRequest(
            @Field("username") String username,
            @Field("password") String password,
            Callback<String> response);

    @FormUrlEncoded
    @POST("/CodeBox/login.php")
    public void sendLoginRequest(
            @Field("username") String username,
            @Field("password") String password,
            Callback<User> response);

    @FormUrlEncoded
    @POST("/CodeBox/codebox.php")
    public void sendDatabaseStoreRequest(
            @Field("user") String user,
            @Field("score") int score,
            @Field("username") String username,
            Callback<String> response);
}
