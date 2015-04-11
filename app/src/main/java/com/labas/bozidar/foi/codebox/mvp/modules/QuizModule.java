package com.labas.bozidar.foi.codebox.mvp.modules;

import com.labas.bozidar.foi.codebox.AppModule;
import com.labas.bozidar.foi.codebox.activities.QuizActivity;
import com.labas.bozidar.foi.codebox.mvp.interactors.QuizInteractor;
import com.labas.bozidar.foi.codebox.mvp.interactors.impl.QuizInteractorImpl;
import com.labas.bozidar.foi.codebox.mvp.models.User;
import com.labas.bozidar.foi.codebox.mvp.presenters.QuizPresenter;
import com.labas.bozidar.foi.codebox.mvp.presenters.impl.QuizPresenterImpl;
import com.labas.bozidar.foi.codebox.mvp.views.QuizView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        addsTo = AppModule.class,
        injects = {
                QuizActivity.class
        },
        complete = false,
        library = true
)
public class QuizModule {
    private QuizView quizView;

    public QuizModule(QuizView quizView) {
        this.quizView = quizView;
    }

    @Provides
    QuizView provideQuizView() {
        return this.quizView;
    }

    @Provides
    @Singleton
    QuizPresenter provideQuizPresenter(QuizView quizView, QuizInteractor quizInteractor, User user) {
        return new QuizPresenterImpl(quizView, quizInteractor, user);
    }

    @Provides
    @Singleton
    QuizInteractor provideQuizInteractor() {
        return new QuizInteractorImpl();
    }


}
