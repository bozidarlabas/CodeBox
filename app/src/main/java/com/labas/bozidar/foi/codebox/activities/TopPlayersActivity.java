package com.labas.bozidar.foi.codebox.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.labas.bozidar.foi.codebox.R;
import com.labas.bozidar.foi.codebox.adapters.TopPlayersAdapter;
import com.labas.bozidar.foi.codebox.mvp.models.User;
import com.labas.bozidar.foi.codebox.mvp.modules.TopPlayersModule;
import com.labas.bozidar.foi.codebox.mvp.presenters.TopPlayersPresenter;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class TopPlayersActivity extends BaseActivity implements TopPLayersView {

    @Inject
    TopPlayersPresenter presenter;

    private RecyclerView recyclerView;
    private TopPlayersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.fetchPlayersData(this);
        setContentView(R.layout.activity_top_players);

    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new TopPlayersModule(this));
    }


    @Override
    public void setRecyclerView(List<User> users) {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new TopPlayersAdapter(this, users);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
