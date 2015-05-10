package com.labas.bozidar.foi.codebox.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.labas.bozidar.foi.codebox.R;
import com.labas.bozidar.foi.codebox.fragments.ScoreFragment;
import com.labas.bozidar.foi.codebox.mvp.listeners.OnQuestionAnswered;
import com.labas.bozidar.foi.codebox.mvp.models.Question;
import com.labas.bozidar.foi.codebox.mvp.modules.QuizModule;
import com.labas.bozidar.foi.codebox.mvp.presenters.QuizPresenter;

import com.labas.bozidar.foi.codebox.mvp.views.QuestionView;
import com.labas.bozidar.foi.codebox.mvp.views.QuizView;
import com.labas.bozidar.foi.codebox.util.Constants;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class QuizActivity extends BaseActivity implements QuizView, OnQuestionAnswered, ScoreFragment.OnScoreInteractionListener {


    @Inject
    public QuizPresenter quizPresenter;

    @InjectView(R.id.tvResult)
    TextView result;

    @InjectView(R.id.tvScore)
    TextView score;

    @InjectView(R.id.tvTimer)
    TextView timer;

    private int fragmentCounter;
    private String username;
    private int totalScore;
    private boolean isActivityDestroyed;
    private int selectedBtnID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        ButterKnife.inject(this);
        setFragment();
        main();
        onActivityStarted();

    }

    private void main() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            username = extras.getString(Constants.KEY_USERNAME);
            totalScore = extras.getInt(Constants.KEY_SCORE);
            selectedBtnID = extras.getInt(Constants.SELECTED_LANGUAGE);
            quizPresenter.setUserData(username, totalScore);
        }
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
        quizPresenter.onQuizActivityStarted(selectedBtnID);
        quizPresenter.onTimerStarted();
    }

    @Override
    public void setQuestion(List<Question> question, QuestionView questionView) {
        if(question.get(0).getOdgovor_a() != null){
            questionView.onSetQuestion(question);
            questionView.onSetAnswers(question);
        }else{
            onBackPressed();
        }
    }

    @Override
    public void changeClickedButtonText(String correctAnswer) {
        notifyAnsweredQuestion(correctAnswer);
        setFragmentTransition();
    }

    private void notifyAnsweredQuestion(String correctAnswer) {
        QuestionView fragment = (QuestionView) getFragmentManager().findFragmentByTag(Integer.toString(fragmentCounter));
        fragment.changeButtonText(correctAnswer);
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
        if (!isActivityDestroyed) {
            fragmentCounter++;
            Fragment newFragment = quizPresenter.getFragment(fragmentCounter);

            String tag = Integer.toString(fragmentCounter);
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.setCustomAnimations(R.anim.fragment_animation_fade_in, R.anim.fragment_animation_fade_out);
            Fragment currentFragment = quizPresenter.getFragments().get(fragmentCounter - 1);
            transaction.remove(currentFragment);
            transaction.add(R.id.fragmentQuiz, newFragment, tag);
            transaction.addToBackStack(null);
            transaction.commit();
            if (fragmentCounter < 5)
                quizPresenter.getCachedData(fragmentCounter);
        }
    }


    @Override
    public void clearTextViews() {
        result.setVisibility(View.INVISIBLE);
        score.setVisibility(View.INVISIBLE);
        timer.setVisibility(View.INVISIBLE);
    }


    @Override
    public void answeredQuestion(String answer, String correctAnswer) {
        quizPresenter.onAnsweredQuestion(answer, correctAnswer);
    }


    @Override
    public void onSaveDataToBackend() {
        quizPresenter.saveDataToBackend();
        navigateBack();
    }

    @Override
    public void onSaveDataToSharedPrefs() {
        quizPresenter.saveToSharedPrefs(this);
    }

    public void navigateBack() {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        isActivityDestroyed = true;
        finish();
    }
}
