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
        this.initializeAI();
    }

    public void autoToken(String token) {
        if(token.equals("X")) {
            this.setToken("O");
        } else {
            this.setToken("X");
        }
    }

    public void play(Board board) {
        Board clone = new Board(board);
        int spot = AI.getBestSpot(clone);
        play(board, spot);
    }

    public void play(Board board, int spot) {
        board.setSpot(spot, token);
    }

    public void initializeAI() {
        if( token != null ) {
            this.AI = new AI(token);
        }
    }

}