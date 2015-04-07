package com.labas.bozidar.foi.codebox.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by bozidar on 25.03.15..
 */
public abstract class MainSplashActivity extends ActionBarActivity{

    public abstract Class getNextClassActivity();

    public abstract int getSplashIntroTime();

    public abstract int setLayoutResource();

    public void main() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                MainSplashActivity.this.startActivity(new Intent(MainSplashActivity.this.getBaseContext(), MainSplashActivity.this.getNextClassActivity()));
                MainSplashActivity.this.finish();
            }
        }, getSplashIntroTime());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutResource());
        main();
    }
}
