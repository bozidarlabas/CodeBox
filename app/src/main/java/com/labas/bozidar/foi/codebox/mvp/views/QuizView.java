package com.labas.bozidar.foi.codebox.mvp.views;

import com.labas.bozidar.foi.codebox.mvp.models.Question;

import java.util.List;

/**
 * Created by bozidar on 09.04.15..
 */
public interface QuizView {
    public void setQuestion(List<Question> question, QuestionView questionView);
    public void changeClickedButtonText(String correctAnswer);
    public void changeScore(String score);
    public void changeTimer(long time);
    public void setFragmentTransition();
}
