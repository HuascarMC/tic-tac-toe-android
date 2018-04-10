package com.example.huascar.tic_tac_toe;

/**
 * Created by huascar on 10/04/2018.
 */

public class HandleTurns {

    private String currentPlayerToken;

    public HandleTurns() {
        currentPlayerToken = null;
    }


    public String getCurrentPlayerToken() {
        return currentPlayerToken;
    }

    public void setCurrentPlayerToken(String token) {
        this.currentPlayerToken = token;
    }

    public void change() {
        if ( this.currentPlayerToken == "X" ) {
            this.setCurrentPlayerToken("O");
        } else {
            this.setCurrentPlayerToken("X");
        }
    }
}