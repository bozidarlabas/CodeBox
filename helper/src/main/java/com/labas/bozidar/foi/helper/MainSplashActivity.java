package com.labas.bozidar.foi.helper;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by bozidar on 25.03.15..
 */
public abstract class MainSplashActivity extends ActionBarActivity{

    public abstract Class getNextClassActivity();

    public abstract int getSplashTIme();

    public abstract int provideLayoutRes();

    public void main() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                MainSplashActivity.this.startActivity(new Intent(MainSplashActivity.this.getBaseContext(), MainSplashActivity.this.getNextClassActivity()));
                MainSplashActivity.this.finish();
            }
        }, getSplashTIme());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideLayoutRes());
        main();
    }

}
