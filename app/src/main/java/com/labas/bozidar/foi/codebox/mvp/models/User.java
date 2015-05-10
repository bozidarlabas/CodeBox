package com.labas.bozidar.foi.codebox.mvp.models;

/**
 * Created by bozidar on 24.03.15..
 */
public class User {

    private int id;
    private String username;
    private int score;
    private int currentResult;

    public int getCurrentResult() {
        return currentResult;
    }

    public void setCurrentResult(int currentResult) {
        this.currentResult = currentResult;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
