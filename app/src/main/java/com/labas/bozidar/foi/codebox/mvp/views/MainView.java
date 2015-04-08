package com.labas.bozidar.foi.codebox.mvp.views;

import android.view.View;

/**
 * Created by bozidar on 25.03.15..
 */
public interface MainView {
    public void onChangeSelectedButton(View view);
    public void onChangePreviousButton(View view);
    public void setTransition();
    public void setAnimation();
}
