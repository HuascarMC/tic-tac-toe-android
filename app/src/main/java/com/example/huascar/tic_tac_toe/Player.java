package com.example.huascar.tic_tac_toe;

/**
 * Created by huascar on 08/04/2018.
 */

public abstract class Player {

    private String token;

    public Player(String token) {
        token = token;
    }

    public abstract String getToken();

    public abstract void setToken();

    public abstract void autoToken();

    public abstract void play();

}
