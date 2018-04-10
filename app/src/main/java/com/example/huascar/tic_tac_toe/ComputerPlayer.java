package com.example.huascar.tic_tac_toe;

/**
 * Created by huascar on 08/04/2018.
 */

public class ComputerPlayer extends Player {

    private String token;
    AI AI;

    public ComputerPlayer() {
        super();
        AI AI = null;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void autoToken(String token) {
        if(token == "X") {
            this.setToken("O");
        } else {
            this.setToken("X");
        }
    }

    public void play(Board board) throws CloneNotSupportedException {
        int spot = this.AI.getBestSpot(board);
        this.play(board, spot);
    }

    public void play(Board board, int spot) {
        board.setSpot(spot, token);
    }

    public void initializeAI() {
        if( token != null ) {
            AI = new AI(token);
        }
    }

}