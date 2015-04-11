package com.labas.bozidar.foi.codebox.mvp.interactors.impl;

import android.app.Fragment;
import android.os.CountDownTimer;
import android.util.Log;

import com.labas.bozidar.foi.codebox.mvp.interactors.QuizInteractor;
import com.labas.bozidar.foi.codebox.mvp.listeners.onDataListener;
import com.labas.bozidar.foi.codebox.mvp.models.Question;
import com.labas.bozidar.foi.codebox.mvp.models.RequestAPI;
import com.labas.bozidar.foi.codebox.util.Constants;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by bozidar on 09.04.15..
 */
public class QuizInteractorImpl implements QuizInteractor {

    private ArrayList<Fragment> fragments;
    private  CodeBoxTimer codeBoxTimer;
    protected onDataListener listener;

    public QuizInteractorImpl(){
        fragments = new ArrayList<>();
        codeBoxTimer = new CodeBoxTimer(11000, 1000);
    }


    //TODO here i will send request and fetch data from database and add load animatin and then go to quiz activity
    @Override
    public void fetchData(final onDataListener listener) {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(Constants.SERVER_ENDPOINT)
                .build();

        RequestAPI api = adapter.create(RequestAPI.class);
        api.getQuestion(new Callback<List<Question>>() {
            @Override
            public void success(List<Question> questions, Response response) {
                listener.setData(questions);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("error", error.toString());
            }
        });
    }

    //TODO make correct and wrong
    @Override
    public void checkAnswer(String answer, String correct, onDataListener listener) {
        if(answer.equals(correct)){
            listener.notifyUserAnswer("Correct", true);
        }else{
            listener.notifyUserAnswer("Wrong", false);
        }
        startTimer(listener);
    }


    @Override
    public void addFragment(Fragment fragment){
        fragments.add(fragment);
    }

    @Override
    public ArrayList<Fragment> getFragments(){
        return fragments;
    }

    @Override
    public void startTimer(onDataListener listener) {
        this.listener = listener;
        codeBoxTimer.start();
    }

    public class CodeBoxTimer extends CountDownTimer {
        public CodeBoxTimer(long startTime, long interval) {
            super(startTime, interval);
        }

        public void onFinish() {
            listener.goToNextFragment();
        }

        @Override
        public void onTick(long millisUntilFinished) {
            listener.changeTimer(millisUntilFinished / 1000);
        }
    }

}
