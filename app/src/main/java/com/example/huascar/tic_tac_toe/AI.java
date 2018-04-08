package com.example.huascar.tic_tac_toe;

/**
 * Created by huascar on 08/04/2018.
 */

public class AI {

    private String token;
    private String winner;
    private GameState gameState;
    private String opponentToken;

    public AI(String token) {
        this.token = token;
        this.winner = null;
        this.gameState = new GameState();
        this.opponentToken = null;
    }


    public String getToken() {
        return token;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getOpponentToken() {
        return opponentToken;
    }
}
