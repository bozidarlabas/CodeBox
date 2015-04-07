package com.labas.bozidar.foi.materialdesignexample.ui.main;


import com.labas.bozidar.foi.materialdesignexample.R;

/**
 * Created by bozidar on 25.03.15..
 */
public class SplashActivity extends MainSplashActivity {

    private static final int TIME = 1500;

    @Override
    public Class getNextClassActivity() {
        return LoginActivity.class;
    }

    @Override
    public int getSplashTIme() {
        return TIME;
    }

    @Override
    public int provideLayoutRes() {
        return R.layout.test;
    }
}
