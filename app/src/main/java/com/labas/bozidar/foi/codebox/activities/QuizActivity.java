package com.labas.bozidar.foi.codebox.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;

import com.labas.bozidar.foi.codebox.R;
import com.labas.bozidar.foi.codebox.fragments.questions.QuestionOne;

import java.util.List;

public class QuizActivity extends BaseActivity implements QuestionOne.OnFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        setFragment();
    }

    private void setFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        QuestionOne fragment = QuestionOne.newInstance("1", "1", "1", "1", "1", "1");
        String tag = fragment.toString();
        transaction.add(R.id.fragmentQuiz, fragment, tag);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    protected List<Object> getModules() {
        return null;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
