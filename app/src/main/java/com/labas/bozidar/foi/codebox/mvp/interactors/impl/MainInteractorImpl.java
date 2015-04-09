package com.labas.bozidar.foi.codebox.mvp.interactors.impl;

import android.util.Log;
import android.view.View;

import com.labas.bozidar.foi.codebox.fragments.CounterFragment;
import com.labas.bozidar.foi.codebox.fragments.MainSelectionFragment;
import com.labas.bozidar.foi.codebox.mvp.interactors.MainInteractor;
import com.labas.bozidar.foi.codebox.mvp.listeners.OnButtonChangedListener;
import com.labas.bozidar.foi.codebox.mvp.models.Question;
import com.labas.bozidar.foi.codebox.mvp.models.QuestionsAPI;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by bozidar on 26.03.15..
 */
public class MainInteractorImpl implements MainInteractor {

    private View lastSelectedView;
    private boolean selectedButton;
    private MainSelectionFragment fragment;
    private CounterFragment fragmentCounter;
    long time;
    public static final String ENDPOINT = "http://bozidarlabas.me";
    List<Question> questionsList;

    public MainInteractorImpl() {
        fragment = new MainSelectionFragment();
        fragmentCounter = new CounterFragment();
    }

    @Override
    public void changeBackgroundStyle(View view, OnButtonChangedListener listener) {
        if (!view.equals(lastSelectedView)) {
            listener.changeSelectedButtonStyle(view);
            if (lastSelectedView != null) {
                listener.changePreviousButtonStyle(lastSelectedView);
            }
            lastSelectedView = view;
        }
        if (!selectedButton)
            listener.changeAnimation(fragment);
        selectedButton = true;
    }

    //TODO here i will send request and fetch data from database and add load animatin and then go to quiz activity
    @Override
    public void fetchData(final OnButtonChangedListener listener) {

        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ENDPOINT)
                .build();

        QuestionsAPI api = adapter.create(QuestionsAPI.class);
        api.getQuestion(new Callback<List<Question>>() {
            @Override
            public void success(List<Question> questions, Response response) {
                listener.goToQuizActivity(questions);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("error", error.toString());
            }
        });
    }


}
