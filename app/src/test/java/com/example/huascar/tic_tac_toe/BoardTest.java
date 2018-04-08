package com.example.huascar.tic_tac_toe;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created by huascar on 08/04/2018.
 */

public class BoardTest {

    private Board board;

    @Before
    public void before() {
        board = new Board();
    }

    @Test
    public void testHasGrid() {
        ArrayList grid = board.getGrid();
        assertEquals( 9, grid.size() );
    }

    @Test
    public void testHasFirstWinCombination() {
        ArrayList winCombination = board.getWinCombinations()[0];
        assertEquals( [0, 1, 2], winCombination );
    }

    @Test
    public void testHasSecondWinCombination() {
        ArrayList winCombination = board.getWinCombinations()[1];
        assertEquals( [3, 4, 5], winCombination );
    }

}
