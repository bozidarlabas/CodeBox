package com.labas.bozidar.foi.codebox;

import android.app.Application;

import com.labas.bozidar.foi.codebox.mvp.models.User;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        injects = {
                App.class
        },
        library = true
)
public class AppModule {
    private final App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return app;
    }

    @Provides
    @Singleton
    User provideUser() {
        return new User();
    }
}
