package com.labas.bozidar.foi.codebox.mvp.presenters.impl;

import com.labas.bozidar.foi.codebox.activities.TopPLayersView;
import com.labas.bozidar.foi.codebox.mvp.models.RequestAPI;
import com.labas.bozidar.foi.codebox.mvp.models.User;
import com.labas.bozidar.foi.codebox.mvp.presenters.TopPlayersPresenter;
import com.labas.bozidar.foi.codebox.util.Constants;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by bozidar on 12.04.15..
 */
public class TopPlayersPresenterImpl implements TopPlayersPresenter {


    public TopPlayersPresenterImpl(){

    }

    @Override
    public void fetchPlayersData(final TopPLayersView listener) {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(Constants.SERVER_ENDPOINT)
                .build();
        RequestAPI api = adapter.create(RequestAPI.class);
        api.sendPlayersRequest("allusers", new Callback<List<User>>() {
            @Override
            public void success(List<User> users, Response response) {
                listener.setRecyclerView(users);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}


