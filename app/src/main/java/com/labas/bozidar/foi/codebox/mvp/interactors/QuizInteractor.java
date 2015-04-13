package com.labas.bozidar.foi.codebox.mvp.interactors;

import android.app.Fragment;
import android.content.Context;

import com.labas.bozidar.foi.codebox.mvp.listeners.onDataListener;

import java.util.ArrayList;

/**
 * Created by bozidar on 09.04.15..
 */
public interface QuizInteractor {
    public void fetchData(onDataListener listener, int selectedLanguage);
    public void checkAnswer(String answer, String correct, onDataListener listener);
    public void addFragment(Fragment fragment);
    public ArrayList<Fragment> getFragments();
    public void startTimer(onDataListener listener);
    public void stopTimer(onDataListener listener);
    public void storeScore(int score, String username);
    public void storeScoreSharedPrefs(Context context, int score, String username);
}
