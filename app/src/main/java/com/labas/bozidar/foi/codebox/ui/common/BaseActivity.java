package com.labas.bozidar.foi.codebox.ui.common;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import com.labas.bozidar.foi.codebox.App;

import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by bozidar on 24.03.15..
 */
public abstract class BaseActivity extends ActionBarActivity{

    private ObjectGraph activityGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("asd", "asd");
        activityGraph = ((App)getApplication()).createScopedGraph(getModules().toArray());
        activityGraph.inject(this);
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        activityGraph = null;
    }

    protected abstract List<Object> getModules();
}
