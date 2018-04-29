package com.example.huascar.tic_tac_toe.gameTypes;

import android.content.Intent;
import android.os.Bundle;

import com.example.huascar.tic_tac_toe.Board;
import com.example.huascar.tic_tac_toe.ComputerPlayer;
import com.example.huascar.tic_tac_toe.GameState;
import com.example.huascar.tic_tac_toe.HandleTurns;
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
    private HandleTurns handleTurns;

    public HumanVsComputer(String firstPlayer, String firstToken, String secondToken ) {

        board = new Board();
        gameState = new GameState();
        computerPlayer = new ComputerPlayer();
        humanPlayer = new HumanPlayer();
        handleTurns = new HandleTurns();

        setUp(firstPlayer, firstToken, secondToken);

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

    public HandleTurns getHandleTurns() { return handleTurns; }

    public void setUp( String firstPlayer, String firstToken, String secondToken ) {
        handleTurns.setCurrentPlayerToken(firstToken);
        if( firstPlayer == "Human" ) {
            humanPlayer.setToken(firstToken);
            computerPlayer.setToken(secondToken);
        } else {
            computerPlayer.setToken(firstToken);
            humanPlayer.setToken(secondToken);
        }
    }

    public void start() {
        while (gameState.finished(board)) {
            if(handleTurns.getCurrentPlayerToken() == humanPlayer.getToken() ) {

            }
        }
    }
}
