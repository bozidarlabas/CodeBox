package com.labas.bozidar.foi.codebox.mvp.modules;

import com.labas.bozidar.foi.codebox.AppModule;
import com.labas.bozidar.foi.codebox.activities.LoginActivity;
import com.labas.bozidar.foi.codebox.mvp.interactors.LoginInteractor;
import com.labas.bozidar.foi.codebox.mvp.interactors.impl.LoginInteractorImpl;
import com.labas.bozidar.foi.codebox.mvp.presenters.LoginPresenter;
import com.labas.bozidar.foi.codebox.mvp.presenters.impl.LoginPresenterImpl;
import com.labas.bozidar.foi.codebox.mvp.views.LoginView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bozidar on 24.03.15..
 */
@Module(
        addsTo = AppModule.class,
        injects = {
                LoginActivity.class
        },
        complete = false,
        library = true

)
public class LoginModule {
    private LoginView view;

    public LoginModule(LoginView view){
        this.view = view;
    }

    @Provides
    public LoginView provideView(){
        return this.view;
    }

    @Provides
    @Singleton
    public LoginPresenter provideLoginPresenter(LoginView loginView, LoginInteractor loginInteractor){
        return new LoginPresenterImpl(loginView, loginInteractor);
    }

    @Provides
    @Singleton
    public LoginInteractor provideLoginInteractor(){
        return new LoginInteractorImpl();
    }

}
