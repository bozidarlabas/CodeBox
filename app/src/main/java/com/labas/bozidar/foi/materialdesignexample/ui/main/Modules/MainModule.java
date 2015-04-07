package com.labas.bozidar.foi.materialdesignexample.ui.main.Modules;

import com.labas.bozidar.foi.materialdesignexample.AppModule;
import com.labas.bozidar.foi.materialdesignexample.interactors.MainInteractor;
import com.labas.bozidar.foi.materialdesignexample.interactors.MainInteractorImpl;
import com.labas.bozidar.foi.materialdesignexample.ui.main.MainActivity;
import com.labas.bozidar.foi.materialdesignexample.ui.main.presenters.MainPresenterImpl;
import com.labas.bozidar.foi.materialdesignexample.ui.main.presenters.MainPresenter;
import com.labas.bozidar.foi.materialdesignexample.ui.main.views.MainView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bozidar on 26.03.15..
 */
@Module(
        addsTo = AppModule.class,
        injects = {
                MainActivity.class
        },
        complete = false,
        library = true
)
public class MainModule {
    private MainView mainView;

    public MainModule(MainView view) {
        this.mainView = view;
    }

    @Provides
    MainView provideMainView(){
        return this.mainView;
    }

    @Provides
    @Singleton
    MainPresenter provideMainPresenter(MainView mainView, MainInteractor mainInteractor){
        return new MainPresenterImpl(mainView, mainInteractor);
    }

    @Provides
    @Singleton
    MainInteractor provideMainInteractor(){
        return new MainInteractorImpl();
    }

}
