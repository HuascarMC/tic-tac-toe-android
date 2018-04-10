package com.example.huascar.tic_tac_toe;

/**
 * Created by huascar on 08/04/2018.
 */

public class GameState {

    private String winner;

    public GameState() {
        this.winner = null;
    }

    public boolean checkTie(Board board) {
        String[] availableSpots = board.getAvailableSpots();

        if( availableSpots.length == 0 && checkWin(board) == false ) {
            return true;
        }
        return false;
    }

    public boolean checkWin(Board board) {
        int[][] winCombinations = board.getWinCombinations();
        String[] grid = board.getGrid();

        for( int i = 0; i < winCombinations.length; i++ ) {
            boolean combinationState = checkWinCombination(winCombinations[i], board);

            if( combinationState ) {
                // Get token inside winCombination and set to winner variable.
                setWinnerToken( grid[winCombinations[i][0]] );
                return true;
            }
        }
        return false;
    }

    public boolean checkWinCombination(int[] combination, Board board) {
        String[] grid = board.getGrid();
        if( grid[combination[0]] == "X" && grid[combination[1]] == "X" && grid[combination[2]] == "X") {
            return true;
        } else if ( grid[combination[0]] == "O" && grid[combination[1]] == "O" && grid[combination[2]] == "O"){
            return true;
        }
        return false;
    }

    public boolean finished(Board board) {
        if( checkWin(board) || checkTie(board) ) {
            return true;
        }
        return false;
    }

    public String getWinnerToken() {
        return winner;
    }

    public void setWinnerToken(String token) {
        winner = token;
    }
}
