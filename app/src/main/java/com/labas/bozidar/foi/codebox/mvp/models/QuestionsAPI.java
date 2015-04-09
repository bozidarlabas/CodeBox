package com.labas.bozidar.foi.codebox.mvp.models;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by bozidar on 08.04.15..
 */
public interface QuestionsAPI {

    @GET("/CodeBox/codebox.php")
    public void getQuestion(Callback<List<Question>> response);

}
