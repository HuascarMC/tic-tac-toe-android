package com.example.huascar.tic_tac_toe;

/**
 * Created by huascar on 08/04/2018.
 */

public abstract class Player {

    private String token;

    public Player() {
        this.token = token;
    }

    public abstract String getToken();

    public abstract void setToken(String token);

    public abstract void autoToken(String token);

    public abstract void play(Board board, int spot);

}
