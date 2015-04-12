package com.labas.bozidar.foi.codebox.activities;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.labas.bozidar.foi.codebox.App;
import com.labas.bozidar.foi.codebox.R;
import com.labas.bozidar.foi.codebox.fragments.NavigationDrawerFragment;

import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by bozidar on 24.03.15..
 */
public abstract class BaseActivity extends ActionBarActivity {

    private ObjectGraph activityGraph;
    protected Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO check is just for testing
        if(getModules() != null){
            activityGraph = ((App) getApplication()).createScopedGraph(getModules().toArray());
            activityGraph.inject(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activityGraph = null;
    }

    protected void setNavigationDrawer() {
        NavigationDrawerFragment drawerFreagment =
                (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFreagment.setup(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
    }

    public NavigationDrawerFragment getNavigationDrawerFragment(){
        return (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
    }

    protected abstract List<Object> getModules();
}
