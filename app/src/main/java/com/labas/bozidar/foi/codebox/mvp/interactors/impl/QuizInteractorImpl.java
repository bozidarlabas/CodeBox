package com.labas.bozidar.foi.codebox.mvp.interactors.impl;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.CountDownTimer;

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

public class QuizInteractorImpl implements QuizInteractor {
    private ArrayList<Fragment> fragments;
    private CodeBoxTimer codeBoxTimer;
    protected onDataListener listener;
    protected boolean lastQuestion;

    private int currentScore;

    public QuizInteractorImpl() {
        currentScore = 0;
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
        api.getQuestion("questions", new Callback<List<Question>>() {
            @Override
            public void success(List<Question> questions, Response response) {
                listener.setData(questions);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    @Override
    public void storeScore(int score, String username){
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(Constants.SERVER_ENDPOINT)
                .build();
        RequestAPI api = adapter.create(RequestAPI.class);
        api.sendDatabaseStoreRequest("user", score, username, new Callback<String>() {
            @Override
            public void success(String s, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    @Override
    public void storeScoreSharedPrefs(Context context, int score, String username) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREFS_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constants.KEY_USERNAME, username);
        editor.putInt(Constants.KEY_SCORE, score);
        editor.apply();
    }

    //TODO make correct and wrong
    @Override
    public void checkAnswer(String answer, String correct, onDataListener listener) {
        if (answer.equals(correct)) {
            currentScore++;
            listener.notifyUserAnswer("Correct", true, currentScore);
        } else {
            listener.notifyUserAnswer("Wrong", false, currentScore);
        }
    }

    @Override
    public void addFragment(Fragment fragment) {
        fragments.add(fragment);
    }

    @Override
    public ArrayList<Fragment> getFragments() {
        return fragments;
    }


    @Override
    public void startTimer(onDataListener listener) {
        this.listener = listener;
        codeBoxTimer.start();
    }

    @Override
    public void stopTimer(onDataListener listener) {
        lastQuestion = true;
        codeBoxTimer.cancel();
    }

    public class CodeBoxTimer extends CountDownTimer {
        public CodeBoxTimer(long startTime, long interval) {
            super(startTime, interval);
        }

        public void onFinish() {
            if(!lastQuestion)
                listener.goToNextFragment();
        }

        @Override
        public void onTick(long millisUntilFinished) {
            if(lastQuestion)
                this.cancel();
            listener.changeTimer(millisUntilFinished / 1000);
        }
    }
}