package com.labas.bozidar.foi.codebox.mvp.views;

import com.labas.bozidar.foi.codebox.mvp.models.Question;

import java.util.List;

/**
 * Created by bozidar on 09.04.15..
 */
public interface QuestionView {
    public void onSetQuestion(List<Question> question);
    public void onSetAnswers(List<Question> question);
    public void changeButtonText(String correctAnswer);
}
