package com.labas.bozidar.foi.materialdesignexample;

/**
 * Created by bozidar on 24.03.15..
 */
public class Modules {

    private Modules() {
    }

    static Object[] list(App app) {
        return new Object[]{
                new AppModule(app),
        };
    }
}
