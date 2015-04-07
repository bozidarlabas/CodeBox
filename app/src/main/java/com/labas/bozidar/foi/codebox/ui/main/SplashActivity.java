package com.labas.bozidar.foi.codebox.ui.main;


import com.labas.bozidar.foi.codebox.R;

/**
 * Created by bozidar on 25.03.15..
 */
public class SplashActivity extends MainSplashActivity {

    private static final int TIME = 1850;

    @Override
    public Class getNextClassActivity() {
        return LoginActivity.class;
    }

    @Override
    public int getSplashIntroTime() {
        return TIME;
    }

    @Override
    public int setLayoutResource() {
        return R.layout.test;
    }
}
