package com.labas.bozidar.foi.codebox.mvp.modules;

import com.labas.bozidar.foi.codebox.AppModule;

import com.labas.bozidar.foi.codebox.activities.TopPlayersActivity;
import com.labas.bozidar.foi.codebox.mvp.presenters.TopPlayersPresenter;
import com.labas.bozidar.foi.codebox.mvp.presenters.impl.TopPlayersPresenterImpl;
import com.labas.bozidar.foi.codebox.mvp.views.TopPLayersView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        addsTo = AppModule.class,
        injects = {
                TopPlayersActivity.class
        },
        complete = false,
        library = true
)
public class TopPlayersModule {
    private TopPLayersView playersView;

    public TopPlayersModule(TopPLayersView view) {
        playersView = view;
    }

    @Provides
    @Singleton
    TopPlayersPresenter provideTopPlayersPresenter() {
        return new TopPlayersPresenterImpl();
    }

}