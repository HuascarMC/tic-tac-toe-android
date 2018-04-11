package com.example.huascar.tic_tac_toe.gameTypes;

import com.example.huascar.tic_tac_toe.Board;
import com.example.huascar.tic_tac_toe.ComputerPlayer;
import com.example.huascar.tic_tac_toe.GameState;
import com.example.huascar.tic_tac_toe.HumanPlayer;

/**
 * Created by huascar on 11/04/2018.
 */

public class HumanVsComputer {

    private Board board;
    private GameState gameState;
    private HumanPlayer humanPlayer;
    private ComputerPlayer computerPlayer;

    public HumanVsComputer() {
        board = new Board();
        gameState = new GameState();
        computerPlayer = new ComputerPlayer();
        humanPlayer = new HumanPlayer();
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


}
