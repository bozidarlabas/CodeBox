package com.labas.bozidar.foi.codebox.ui.main;

import android.animation.AnimatorSet;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.labas.bozidar.foi.codebox.R;
import com.labas.bozidar.foi.codebox.ui.common.BaseActivity;
import com.labas.bozidar.foi.codebox.ui.main.Modules.MainModule;
import com.labas.bozidar.foi.codebox.ui.main.presenters.MainPresenter;
import com.labas.bozidar.foi.codebox.ui.main.views.MainView;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import javax.inject.Inject;

import butterknife.InjectView;


public class MainActivity extends BaseActivity implements View.OnClickListener, MainView {

    @Inject
    MainPresenter mainPresenter;

    @InjectView(R.id.imgLogo)
    ImageView imageView;

    private AnimatorSet animatorSet;
    private Toolbar toolbar;
    public Stack<String> mFragmentStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLayoutsById();

        setSupportActionBar(toolbar = (Toolbar) findViewById(R.id.app_bar));
        //Set display enabled so user can slide drawer from left
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //Initialize the DrawerLayout
        NavigationDrawerFragment drawerFreagment =
                (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFreagment.setup(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        //fragment

        mFragmentStack = new Stack<String>();

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
    public void setAnimation() {

        Fragment newFragment = new MainSelectionFragment();
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

    public void getLayoutsById() {
        findViewById(R.id.btnC).setOnClickListener(this);
        findViewById(R.id.btnCpp).setOnClickListener(this);
        findViewById(R.id.btnCsharp).setOnClickListener(this);
        findViewById(R.id.btnPython).setOnClickListener(this);
        findViewById(R.id.btnJS).setOnClickListener(this);
        findViewById(R.id.btnRuby).setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        mainPresenter.onButtonClicked(view);
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
    public void setTransition() {

    }
}
