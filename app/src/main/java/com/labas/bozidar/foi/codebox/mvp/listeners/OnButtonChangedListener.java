package com.labas.bozidar.foi.codebox.mvp.listeners;

import android.app.Fragment;
import android.view.View;

/**
 * Created by bozidar on 26.03.15..
 */
public interface OnButtonChangedListener {
    public void changeSelectedButtonStyle(View view);
    public void changePreviousButtonStyle(View view);
    public void changeAnimation(Fragment fragment);
    public void changeTimmerText(String text);
    public void setRestoredData(String username, int score);
}
