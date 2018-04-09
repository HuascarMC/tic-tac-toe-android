package com.example.huascar.tic_tac_toe;

/**
 * Created by huascar on 08/04/2018.
 */

public class AI {

    private String token;
    private String winner;
    GameState gameState;
    private String opponentToken;

    public AI(String token) {
        this.token = token;
        this.winner = null;
        this.gameState = new GameState();
        this.opponentToken = null;
    }


    public String getToken() {
        return token;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
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

    public int getBestSpot(Board board) {
        String[] grid = board.getGrid();
        if( grid[4] != "X" && grid[4] != "O") {
            return 4;
        } else {
            int spot = this.maximizedSpot(board);
            return spot;
        }
    }

    public int maximiazedSpot(Board board) throws CloneNotSupportedException {
        Board boardClone = (Board) board.clone();

        int bestScore = 0;
        int bestSpot = 0;

        String[] availableSpots = boardClone.getAvailableSpots();

        for(String availableSpot: availableSpots) {
            int spot = Integer.parseInt(availableSpot);
            board.setSpot(spot, this.token);

            if( gameState.finished(boardClone) ) {
                int score = this.getScore(boardClone);
            } else {
                int minimizedSpot = this.minimizedSpot(boardClone);

                boardClone = (Board) board.clone();

                if( bestScore == 0 || score > bestScore) {
                    bestScore = score;
                    bestSpot = minimizedSpot;
                }
            }
        }
        return bestSpot;
    }

    public int getScore(Board board) {
        if( gameState.finished(board) ) {
            setWinner(gameState.getWinnerToken());
            if( winner == token) {
                return 1;
            } else if ( winner == opponentToken ) {
                return -1;
            }
        }
        return 0;
    }
}
