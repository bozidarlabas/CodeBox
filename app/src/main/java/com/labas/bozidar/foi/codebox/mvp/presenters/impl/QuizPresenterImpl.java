package com.labas.bozidar.foi.codebox.mvp.presenters.impl;

import android.app.Fragment;

import com.labas.bozidar.foi.codebox.fragments.questions.QuestionFive;
import com.labas.bozidar.foi.codebox.fragments.questions.QuestionFour;
import com.labas.bozidar.foi.codebox.fragments.questions.QuestionOne;
import com.labas.bozidar.foi.codebox.fragments.questions.QuestionThree;
import com.labas.bozidar.foi.codebox.fragments.questions.QuestionTwo;
import com.labas.bozidar.foi.codebox.mvp.interactors.QuizInteractor;
import com.labas.bozidar.foi.codebox.mvp.listeners.onDataListener;
import com.labas.bozidar.foi.codebox.mvp.models.Question;
import com.labas.bozidar.foi.codebox.mvp.models.User;
import com.labas.bozidar.foi.codebox.mvp.presenters.QuizPresenter;
import com.labas.bozidar.foi.codebox.mvp.views.QuestionView;
import com.labas.bozidar.foi.codebox.mvp.views.QuizView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bozidar on 09.04.15..
 */
public class QuizPresenterImpl implements QuizPresenter, onDataListener {

    private QuizView quizView;
    private QuizInteractor quizInteractor;
    private User user;
    private List<Question> question;


    public QuizPresenterImpl(QuizView quizView, QuizInteractor quizInteractor, User user) {
        this.quizView = quizView;
        this.quizInteractor = quizInteractor;
        this.user = user;
    }

    @Override
    public void onQuizActivityStarted() {
        quizInteractor.fetchData(this);
    }


    @Override
    public void onAnsweredQuestion(String answer, String correct) {
        quizInteractor.checkAnswer(answer, correct, this);
    }

    @Override
    public void getCachedData(int fragmentIndex) {
        quizView.setQuestion(question, (QuestionView) quizInteractor.getFragments().get(fragmentIndex));
    }

    @Override
    public void setFragments() {
        quizInteractor.addFragment(new QuestionOne());
        quizInteractor.addFragment(new QuestionTwo());
        quizInteractor.addFragment(new QuestionThree());
        quizInteractor.addFragment(new QuestionFour());
        quizInteractor.addFragment(new QuestionFive());
    }

    @Override
    public ArrayList<Fragment> getFragments() {
        return quizInteractor.getFragments();
    }

    @Override
    public void onTimerStarted() {
        quizInteractor.startTimer(this);
    }

    @Override
    public void setData(List<Question> question) {
        this.question = question;
        quizView.setQuestion(question, (QuestionView) quizInteractor.getFragments().get(0));
    }

    //TODO combo :)
    @Override
    public void notifyUserAnswer(String correctAnswer, boolean checkAnswer) {
        if (checkAnswer) {
            user.setScore(1);
            quizView.changeScore(Integer.toString(user.getScore()));
        }
        quizView.changeClickedButtonText(correctAnswer);
    }

    @Override
    public void changeTimer(long time) {
        quizView.changeTimer(time);
    }

    @Override
    public void goToNextFragment() {
        quizView.setFragmentTransition();
        onTimerStarted();
    }
}
