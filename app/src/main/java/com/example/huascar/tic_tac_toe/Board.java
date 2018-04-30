package com.example.huascar.tic_tac_toe;

import java.util.ArrayList;

/**
 * Created by huascar on 08/04/2018.
 */

public class Board implements Cloneable {

    private String[] grid;
    private int[][] winCombinations;

    public Board() {
        this.grid = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8"};
        this.winCombinations = new int[][]{{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7,}, {2,5,8}, {0,4,8}, {2,4,6}};
    }

    public Board(Board sourceBoard) {
        this();
        System.arraycopy(sourceBoard.grid, 0, this.grid, 0, sourceBoard.grid.length);

        for (int i = 0; i < winCombinations.length; i++) {
            int[] line = winCombinations[i];
            System.arraycopy(sourceBoard.winCombinations[i], 0, line, 0, line.length);
        }
    }

    public String[] getGrid() {
        return grid;
    }

    public int[][] getWinCombinations() {
        return winCombinations;
    }

    public String[] getAvailableSpots() {
        ArrayList<String> resultList = new ArrayList<String>();
        for(int i = 0; i < grid.length; i++) {
            if(!grid[i].equals("X") && !grid[i].equals("O")) {
                resultList.add(grid[i]);
            }
        }
        return resultList.toArray(new String[resultList.size()]);
    }

    public void reset() {
        grid = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8"};
    }

    public void setSpot(int i, String token) {
        grid[i] = token;
    }

    public void setGrid(String[] grid) {
        this.grid = grid;
    }

    @Override
    public Object clone() {
        Board boardClone = null;
        try {
            boardClone = (Board) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return boardClone;
    }
}
