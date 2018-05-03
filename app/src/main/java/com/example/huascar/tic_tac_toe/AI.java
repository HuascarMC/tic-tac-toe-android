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
            return Integer.parseInt((String) maximizedSpot(board, 200)[0]);
        }
    }

    public Object[] maximizedSpot(Board board, int depth) {
        Board boardClone = new Board(board);

        int bestScore = 0;
        String bestSpot = null;
        int score;

        String[] availableSpots = boardClone.getAvailableSpots();

        for(String availableSpot: availableSpots) {
            int spot = Integer.parseInt(availableSpot);
            boardClone.setSpot(spot, token);

            if( gameState.finished(boardClone) ) {
                score = getScore(boardClone, depth);
            } else {
                Object[] minimizedSpot = minimizedSpot(boardClone, depth);
                score = (int) minimizedSpot[1];
            }
            boardClone.setGrid(board.getGrid());

            if( bestScore == 0 || score > bestScore ) {
                bestScore = score;
                bestSpot = availableSpot;
            }
            System.out.print("depth: " + depth + "; ");
            System.out.print("bestspot: " + bestSpot + "; ");
            System.out.print("bestscore: " + bestScore + "; ");
            System.out.print("token: " + token);
            System.out.println("----------------------");
            depth += 1;
        }
        return new Object[]{bestSpot, bestScore};
    }

    public Object[] minimizedSpot(Board board, int depth) {
        Board boardClone = new Board(board);

        int bestScore = 0;
        String bestSpot = null;
        int score;


        String[] availableSpots = boardClone.getAvailableSpots();

        for(String availableSpot: availableSpots) {
            int spot = Integer.parseInt(availableSpot);
            boardClone.setSpot(spot, opponentToken);

            if ( gameState.finished(boardClone) ) {
                score = getScore(boardClone, depth);
            } else {
                Object[] maximizedSpot = maximizedSpot(boardClone, depth);
                score = (int) maximizedSpot[1];
            }
            boardClone.setGrid(board.getGrid());

            if (bestScore == 0 || score < bestScore) {
                bestScore = score;
                bestSpot = availableSpot;
            }
            System.out.println("depth: " + depth + ";");
            System.out.print("bestspot: " + bestSpot + ";");
            System.out.print("bestscore: " + bestScore + ";");
            System.out.print("token: " + opponentToken);
            System.out.println("----------------------");
            depth += 1;
        }
        return new Object[]{bestSpot, bestScore};
    }

    public int getScore(Board board, int depth) {
        if( gameState.finished(board) && gameState.getWinnerToken() != null ) {
            String winnerToken = (gameState.getWinnerToken());
            if(winnerToken.equals(token)) {
                return 1 - depth;
            } else if (winnerToken.equals(opponentToken)) {
                return -1 - depth;
            }
        }
        return 0 - depth;
    }
}
