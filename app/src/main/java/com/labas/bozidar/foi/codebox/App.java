package com.labas.bozidar.foi.codebox;

import android.app.Application;

import dagger.ObjectGraph;

/**
 * Created by bozidar on 24.03.15..
 */
public class App extends Application {
    private ObjectGraph objectGraph;

    //Build object graph on creation so that objects are available
    @Override
    public void onCreate() {
        super.onCreate();
        buildObjectGraphAndInject();
    }

    //Used by activities to create a scoped graph
    public ObjectGraph createScopedGraph(Object... modules) {
        return objectGraph.plus(modules);
    }

    public void buildObjectGraphAndInject() {
        objectGraph = ObjectGraph.create(Modules.list(this));
        inject(this);
    }

    public void inject(Object object) {
        objectGraph.inject(object);
    }

    public ObjectGraph getApplicationGraph() {
        return objectGraph;
    }
}
