package com.example.huascar.tic_tac_toe;

/**
 * Created by huascar on 08/04/2018.
 */

public class GameState {

    public boolean checkTie(Board board) {
        String[] availableSpots = board.getAvailableSpots();

        if( availableSpots.length == 0 && checkWin(board) == false ) {
            return true;
        }
        return false;
    }

    public boolean checkWin(Board board) {
        int[][] winCombinations = board.getWinCombinations();

        for( int i = 0; i < winCombinations.length - 1; i++ ) {
            boolean combinationState = checkWinCombination(winCombinations[i], board);

            if( combinationState == true ) {
                return true;
            }
        }
        return false;
    }

    public boolean checkWinCombination(int[] combination, Board board) {
        String[] grid = board.getGrid();
        for( int i = 0; i < combination.length - 1; i++ ) {
            if( (grid[combination[i]] != "X") || grid[combination[i]] != "O" ) {
                return false;
            }
        }
        return true;
    }

    public boolean finished(Board board) {
        if( checkWin(board) || checkTie(board) ) {
            return true;
        }
        return false;
    }
}
