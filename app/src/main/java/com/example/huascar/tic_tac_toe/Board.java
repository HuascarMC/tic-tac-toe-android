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

    public String[] getGrid() {
        return grid;
    }

    public int[][] getWinCombinations() {
        return winCombinations;
    }

    public String[] getAvailableSpots() {
        ArrayList<String> resultList = new ArrayList<String>();
        for(int i = 0; i < grid.length; i++) {
            if(grid[i] != "X" && grid[i] != "O") {
                resultList.add(grid[i]);
            }
        }
        String[] result = resultList.toArray(new String[resultList.size()]);
        return result;
    }

    public void reset() {
        grid = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8"};
    }

    public void setSpot(int i, String x) {
        grid[i] = x;
    }

    public void setGrid(String[] grid) {
        this.grid = grid;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Board clone = (Board) super.clone();
        return clone;
    }
}
