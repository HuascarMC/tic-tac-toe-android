package com.example.huascar.tic_tac_toe;

/**
 * Created by huascar on 08/04/2018.
 */

public class AI {

    private String token;
    GameState gameState;
    private String opponentToken;

    public AI(String token) {
        this.token = token;
        this.gameState = new GameState();
        this.opponentToken = null;

        setOpponentToken();
    }


    public String getToken() {
        return token;
    }

    public String getOpponentToken() {
        return opponentToken;
    }

    public void setOpponentToken() {
        if(this.token == "X") {
            opponentToken = "O";
        } else {
            opponentToken = "X";
        }
    }

    public int getBestSpot(Board board) throws CloneNotSupportedException {
        String[] grid = board.getGrid();
        if( grid[4] != "X" && grid[4] != "O") {
            return 4;
        } else {
            int bestSpot = (int) this.maximizedSpot(board)[0];
            return bestSpot;
        }
    }

    public Object[] maximizedSpot(Board board) throws CloneNotSupportedException {
        Board boardClone = (Board) board.clone();

        int bestScore = 0;
        String bestSpot = null;
        int score;

        String[] availableSpots = boardClone.getAvailableSpots();

        for(String availableSpot: availableSpots) {
            int spot = Integer.parseInt(availableSpot);
            boardClone.setSpot(spot, this.token);

            if( gameState.finished(boardClone) ) {
                score = this.getScore(boardClone);
            } else {
                Object[] minimizedSpot = this.minimizedSpot(boardClone);
                score = (int) minimizedSpot[1];
            }
            boardClone = (Board) board.clone();

            if( bestScore == 0 || score > bestScore ) {
                bestScore = score;
                bestSpot = availableSpot;
            }
        }

        return new Object[]{bestSpot, bestScore};
    }

    public Object[] minimizedSpot(Board board) throws CloneNotSupportedException {
        Board boardClone = (Board) board.clone();

        int bestScore = 0;
        String bestSpot = null;
        int score;

        String[] availableSpots = boardClone.getAvailableSpots();

        for(String availableSpot: availableSpots) {
            int spot = Integer.parseInt(availableSpot);
            boardClone.setSpot(spot, this.opponentToken);

            if ( gameState.finished(boardClone) ) {
                score = this.getScore(boardClone);
            } else {
                Object[] maximizedSpot = this.maximizedSpot(boardClone);
                score = (int) maximizedSpot[1];
            }
            boardClone = (Board) board.clone();

            if (bestScore == 0 || score < bestScore) {
                bestScore = score;
                bestSpot = availableSpot;
            }

        }
        return new Object[]{bestSpot, bestScore};
    }

    public int getScore(Board board) {
        if( gameState.finished(board) ) {
            String winnerToken = (gameState.getWinnerToken());
            if( winnerToken == token ) {
                return 1;
            } else if ( winnerToken == opponentToken ) {
                return -1;
            }
        }
        return 0;
    }
}
