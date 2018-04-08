package com.example.huascar.tic_tac_toe;

import java.util.ArrayList;

/**
 * Created by huascar on 08/04/2018.
 */

public class Board {

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
        String[] result = new String[winCombinations.length + 1];
        for(int i = 0; i < grid.length; i++) {
            if(grid[i] != "X" && grid[i] != "O") {
                result[i] = grid[i];
            }
        }
        return result;
    }

    public boolean reset() {
        grid = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8"};
        return true;
    }
}
