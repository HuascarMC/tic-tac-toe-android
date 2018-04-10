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
            int spot = this.maximizedSpot(board);
            return spot;
        }
    }

    public Object[] maximizedSpot(Board board) throws CloneNotSupportedException {
        Board boardClone = (Board) board.clone();

        int bestScore = 0;
        int bestSpot = 0;
        int score = 0;

        String[] availableSpots = boardClone.getAvailableSpots();

        for(String availableSpot: availableSpots) {
            int spot = Integer.parseInt(availableSpot);
            boardClone.setSpot(spot, this.token);

            if( gameState.finished(boardClone) ) {
                score = this.getScore(boardClone);
            } else {
                int minimizedSpot = this.minimizedSpot(boardClone);

                boardClone = (Board) board.clone();

                if( bestScore == 0 || score > bestScore ) {
                    bestScore = score;
                    bestSpot = minimizedSpot;
                }
            }
        }
        Object[] result = new Object[]{bestSpot, score};
        return result;
    }

    public int minimizedSpot(Board board) throws CloneNotSupportedException {
        Board boardClone = (Board) board.clone();

        int bestScore = 0;
        int bestSpot = 0;
        int score = 0;

        String[] availableSpots = boardClone.getAvailableSpots();

        for(String availableSpot: availableSpots) {
            int spot = Integer.parseInt(availableSpot);
            boardClone.setSpot(spot, this.opponentToken);

            if( gameState.finished(boardClone) ) {
                score = this.getScore(boardClone);
            } else {
                int maximizedSpot = maximizedSpot(boardClone);

                boardClone = (Board) board.clone();

                if( bestScore == 0 || score > bestScore ) {
                    bestScore = score;
                    bestSpot = maximizedSpot;
                }
            }
        }
        return bestSpot;
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
