package com.labas.bozidar.foi.codebox.mvp.presenters;

import android.app.Fragment;
import android.content.Context;

import com.labas.bozidar.foi.codebox.mvp.models.User;

import java.util.ArrayList;

/**
 * Created by bozidar on 09.04.15..
 */
public interface QuizPresenter {
    public void onQuizActivityStarted(int idSelectedLanguage);
    public void onAnsweredQuestion(String answer, String correct);
    public void getCachedData(int fragmentIndex);
    public void setFragments();
    public ArrayList<Fragment> getFragments();
    public void onTimerStarted();
    public void onTImerStoped();
    public Fragment getFragment(int fragmentCounter);
    public User getUserData();
    public User setUserData(String username, int score);
    public void saveDataToBackend();
    public void saveToSharedPrefs(Context context);
}
