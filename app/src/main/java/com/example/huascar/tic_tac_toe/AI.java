package com.example.huascar.tic_tac_toe;

/**
 * Created by huascar on 08/04/2018.
 */

public class AI {

    private String token;
    private GameState gameState;
    private String opponentToken;

    AI(String token) {
        this.token = token;
        gameState = new GameState();
        opponentToken = null;

        setOpponentToken();
    }


    public String getToken() {
        return token;
    }

    public String getOpponentToken() {
        return opponentToken;
    }

    public void setOpponentToken() {
        if(token.equals("X")) {
            opponentToken = "O";
        } else {
            opponentToken = "X";
        }
    }

    public int getBestSpot(Board board) {
        String[] grid = board.getGrid();
        if( !grid[4].equals("X") && !grid[4].equals("O")) {
            return 4;
        } else {
            return Integer.parseInt((String) maximizedSpot(board)[0]);
        }
    }

    public Object[] maximizedSpot(Board board) {
        Board boardClone = new Board(board);

        int bestScore = 0;
        String bestSpot = null;
        int score;

        String[] availableSpots = boardClone.getAvailableSpots();

        for(String availableSpot: availableSpots) {
            int spot = Integer.parseInt(availableSpot);
            boardClone.setSpot(spot, token);

            if( gameState.finished(boardClone) ) {
                score = getScore(boardClone);
            } else {
                Object[] minimizedSpot = minimizedSpot(boardClone);
                score = (int) minimizedSpot[1];
            }
            boardClone.setGrid(board.getGrid());

            if( bestScore == 0 || score > bestScore ) {
                bestScore = score;
                bestSpot = availableSpot;
            }
        }
        return new Object[]{bestSpot, bestScore};
    }

    public Object[] minimizedSpot(Board board) {
        Board boardClone = new Board(board);

        int bestScore = 0;
        String bestSpot = null;
        int score;

        String[] availableSpots = boardClone.getAvailableSpots();

        for(String availableSpot: availableSpots) {
            int spot = Integer.parseInt(availableSpot);
            boardClone.setSpot(spot, opponentToken);

            if ( gameState.finished(boardClone) ) {
                score = getScore(boardClone);
            } else {
                Object[] maximizedSpot = maximizedSpot(boardClone);
                score = (int) maximizedSpot[1];
            }
            boardClone.setGrid(board.getGrid());

            if (bestScore == 0 || score < bestScore) {
                bestScore = score;
                bestSpot = availableSpot;
            }

        }
        return new Object[]{bestSpot, bestScore};
    }

    public int getScore(Board board) {
        if( gameState.finished(board) && gameState.getWinnerToken() != null) {
            String winnerToken = (gameState.getWinnerToken());
            if(winnerToken.equals(token)) {
                return 1;
            } else if (winnerToken.equals(opponentToken)) {
                return -1;
            }
        }
        return 0;
    }
}
