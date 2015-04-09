package com.labas.bozidar.foi.codebox.mvp.views;

import android.app.Fragment;
import android.view.View;

import com.labas.bozidar.foi.codebox.mvp.models.Question;

import java.util.List;

/**
 * Created by bozidar on 25.03.15..
 */
public interface MainView {
    public void onChangeSelectedButton(View view);
    public void onChangePreviousButton(View view);
    public void setFragmentTransition(Fragment fragment);
    public void setActivityTransition(List<Question> questions);
    public void onChangeCounterText(String text);
}
