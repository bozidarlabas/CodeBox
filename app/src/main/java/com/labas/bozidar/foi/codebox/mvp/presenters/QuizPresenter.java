package com.labas.bozidar.foi.codebox.mvp.presenters;

import android.app.Fragment;

import java.util.ArrayList;

/**
 * Created by bozidar on 09.04.15..
 */
public interface QuizPresenter {
    public void onQuizActivityStarted();
    public void onAnsweredQuestion(String answer, String correct);
    public void getCachedData(int fragmentIndex);
    public void setFragments();
    public ArrayList<Fragment> getFragments();
    public void onTimerStarted();
}
