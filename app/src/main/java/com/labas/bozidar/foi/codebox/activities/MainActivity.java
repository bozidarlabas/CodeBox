package com.labas.bozidar.foi.codebox.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.labas.bozidar.foi.codebox.R;
import com.labas.bozidar.foi.codebox.fragments.CounterFragment;
import com.labas.bozidar.foi.codebox.fragments.MainLogoFragment;
import com.labas.bozidar.foi.codebox.mvp.models.Question;
import com.labas.bozidar.foi.codebox.mvp.modules.MainModule;
import com.labas.bozidar.foi.codebox.mvp.presenters.MainPresenter;
import com.labas.bozidar.foi.codebox.mvp.views.MainView;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity implements MainView {

    @Inject
    public MainPresenter mainPresenter;
    private Stack<String> mFragmentStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar(toolbar = (Toolbar) findViewById(R.id.app_bar));
        //Set display enabled so user can slide drawer from left
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setNavigationDrawer();
        setFragment();
        ButterKnife.inject(this);
    }

    private void setFragment() {
        mFragmentStack = new Stack<>();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        MainLogoFragment fragment = new MainLogoFragment();
        String tag = fragment.toString();
        mFragmentStack.add(tag);
        transaction.add(R.id.fragment, fragment, tag);
        transaction.addToBackStack(tag);
        transaction.commit();
    }


    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new MainModule(this));
    }

    @Override
    public void setFragmentTransition(Fragment newFragment) {

        String tag = newFragment.toString();

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fragment_animation_fade_in, R.anim.fragment_animation_fade_out);

        Fragment currentFragment = getFragmentManager().findFragmentByTag(mFragmentStack.peek());
        transaction.hide(currentFragment);

        transaction.add(R.id.fragment, newFragment, tag);
        transaction.addToBackStack(tag);
        mFragmentStack.add(tag);
        transaction.commit();
    }

    //TODO set counter while fetching data from server
    @Override
    public void setActivityTransition(List<Question> questions) {

        Intent activity = new Intent(this, QuizActivity.class);
        activity.putExtra("questionObject", new Gson().toJson(questions));
        startActivity(activity);

        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    @Override
    public void onChangeCounterText(String text) {
        CounterFragment fragment = (CounterFragment)getFragmentManager().findFragmentById(R.id.fragment);
        ((TextView) fragment.getView().findViewById(R.id.tvCounter)).setText(text);
    }


    @OnClick({R.id.btnC, R.id.btnCpp, R.id.btnCsharp, R.id.btnPython, R.id.btnJS, R.id.btnRuby})
    public void onClick(View view) {
        mainPresenter.onLangButtonClicked(view);
    }

    public void changButtonStyle(View view, int colorBackground, int colorText) {
        view.setBackgroundColor(colorBackground);
        TextView tv = (TextView) view.findViewWithTag("lala");
        tv.setTextColor(colorText);
    }

    @Override
    public void onChangeSelectedButton(View view) {
        int accentColor = getResources().getColor(R.color.accentcolor);
        changButtonStyle(view, Color.WHITE, accentColor);
    }

    @Override
    public void onChangePreviousButton(View view) {
        int accentColor = getResources().getColor(R.color.accentcolor);
        changButtonStyle(view, accentColor, Color.WHITE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
