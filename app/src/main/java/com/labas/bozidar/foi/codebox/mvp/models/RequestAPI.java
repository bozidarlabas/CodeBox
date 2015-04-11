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

    @POST("/CodeBox/codebox.php")
    public void getQuestion(Callback<List<Question>> response);

    @FormUrlEncoded
    @POST("/CodeBox/registration.php")
    public void sendRegistrationRequest(
            @Field("username") String username,
            @Field("password") String password,
            Callback<String> response);


}
