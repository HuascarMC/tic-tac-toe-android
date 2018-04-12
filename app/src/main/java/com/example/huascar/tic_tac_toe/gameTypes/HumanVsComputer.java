package com.example.huascar.tic_tac_toe.gameTypes;

import android.content.Intent;
import android.os.Bundle;

import com.example.huascar.tic_tac_toe.Board;
import com.example.huascar.tic_tac_toe.ComputerPlayer;
import com.example.huascar.tic_tac_toe.GameState;
import com.example.huascar.tic_tac_toe.HumanPlayer;
import com.example.huascar.tic_tac_toe.R;

/**
 * Created by huascar on 11/04/2018.
 */

public class HumanVsComputer {

    private Board board;
    private GameState gameState;
    private HumanPlayer humanPlayer;
    private ComputerPlayer computerPlayer;

    public HumanVsComputer(String firstPlayer, String secondPlayer, String firstToken, String secondToken ) {

        board = new Board();
        gameState = new GameState();
        computerPlayer = new ComputerPlayer();
        humanPlayer = new HumanPlayer();
        setUp(firstPlayer, secondPlayer, firstToken, secondToken);

    }

    public Board getBoard() {
        return board;
    }

    public ComputerPlayer getComputerPlayer() {
        return computerPlayer;
    }

    public HumanPlayer getHumanPlayer() {
        return humanPlayer;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setUp( String firstPlayer, String secondPlayer, String firstToken, String secondToken ) {



    }

    public void setFirstPlayer( String firstPlayer, String firstToken ) {
        if( firstPlayer == "Human" ) {
            humanPlayer.setToken(firstToken);
        } else {
            computerPlayer.setToken(firstToken);
        }
    }

}
