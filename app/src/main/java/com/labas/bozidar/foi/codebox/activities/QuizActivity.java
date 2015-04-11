package com.labas.bozidar.foi.codebox.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.TextView;

import com.labas.bozidar.foi.codebox.R;
import com.labas.bozidar.foi.codebox.mvp.models.Question;
import com.labas.bozidar.foi.codebox.mvp.modules.QuizModule;
import com.labas.bozidar.foi.codebox.mvp.presenters.QuizPresenter;
import com.labas.bozidar.foi.codebox.mvp.views.QuestionView;
import com.labas.bozidar.foi.codebox.mvp.views.QuizView;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class QuizActivity extends BaseActivity implements QuizView {


    @Inject
    public QuizPresenter quizPresenter;

    @InjectView(R.id.tvScore)
    TextView score;

    @InjectView(R.id.tvTimer)
    TextView timer;

    private int fragmentCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        ButterKnife.inject(this);
        setFragment();
        onActivityStarted();
    }

    private void setFragment() {
        quizPresenter.setFragments();
        fragmentCounter = 0;
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        String tag = Integer.toString(fragmentCounter);
        transaction.add(R.id.fragmentQuiz, quizPresenter.getFragments().get(0), tag);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new QuizModule(this));
    }

    public void onActivityStarted() {
        score.setText("0");
        quizPresenter.onQuizActivityStarted();
        quizPresenter.onTimerStarted();
    }

    @Override
    public void setQuestion(List<Question> question, QuestionView questionView) {
        questionView.onSetQuestion(question);
        questionView.onSetAnswers(question);
    }

    @Override
    public void changeClickedButtonText(String correctAnswer) {
        QuestionView fragment = (QuestionView) getFragmentManager().findFragmentByTag(Integer.toString(fragmentCounter));
        fragment.changeButtonText(correctAnswer);
        setFragmentTransition();
    }

    @Override
    public void changeScore(String score) {
        this.score.setText(score);
    }

    @Override
    public void changeTimer(long time) {
        timer.setText(Long.toString(time));
    }

    @Override
    public void setFragmentTransition() {
        fragmentCounter++;
        Fragment newFragment = quizPresenter.getFragments().get(fragmentCounter);

        String tag = Integer.toString(fragmentCounter);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fragment_animation_fade_in, R.anim.fragment_animation_fade_out);

        Fragment currentFragment = quizPresenter.getFragments().get(fragmentCounter - 1);

        transaction.remove(currentFragment);

        transaction.add(R.id.fragmentQuiz, newFragment, tag);

        transaction.addToBackStack(null);
        transaction.commit();

        quizPresenter.getCachedData(fragmentCounter);
    }



}
