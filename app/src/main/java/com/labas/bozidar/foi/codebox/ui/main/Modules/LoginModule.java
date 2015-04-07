package com.labas.bozidar.foi.codebox.ui.main.Modules;

import com.labas.bozidar.foi.codebox.AppModule;
import com.labas.bozidar.foi.codebox.interactors.LoginInteractor;
import com.labas.bozidar.foi.codebox.interactors.LoginInteractorImpl;
import com.labas.bozidar.foi.codebox.ui.main.LoginActivity;
import com.labas.bozidar.foi.codebox.ui.main.presenters.LoginPresenter;
import com.labas.bozidar.foi.codebox.ui.main.presenters.LoginPresenterImpl;
import com.labas.bozidar.foi.codebox.ui.main.views.LoginView;

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
