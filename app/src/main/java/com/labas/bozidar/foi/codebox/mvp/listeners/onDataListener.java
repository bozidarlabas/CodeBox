package com.labas.bozidar.foi.codebox.mvp.listeners;

import com.labas.bozidar.foi.codebox.mvp.models.Question;

import java.util.List;

/**
 * Created by bozidar on 09.04.15..
 */
public interface onDataListener {
    public void setData(List<Question> question);
    public void notifyUserAnswer(String correctAnswer, boolean CheckAnswer, int currentScore);
    public void changeTimer(long time);
    public void goToNextFragment();
}
