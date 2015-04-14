package com.labas.bozidar.foi.codebox.mvp.interactors;

import android.content.Context;
import android.view.View;

import com.labas.bozidar.foi.codebox.mvp.listeners.OnButtonChangedListener;

/**
 * Created by bozidar on 26.03.15..
 */
public interface MainInteractor {
    public void changeBackgroundStyle(View view, OnButtonChangedListener listener);
    public void restoreData(Context context, OnButtonChangedListener listener);
    public void storeScoreSharedPrefs(Context context, OnButtonChangedListener listener);
}
