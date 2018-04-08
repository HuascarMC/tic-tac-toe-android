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

    @Test
    public void testHasThirdWinCombination() {
        ArrayList winCombination = board.getWinCombinations()[2];
        assertEquals( [6, 7, 8],  winCombination );
    }

    @Test
    public void testHasFourthWinCombination() {
        ArrayList winCombination = board.getWinCombinations()[3];
        assertEquals( [0, 3, 6],  winCombination );
    }

    @Test
    public void testHasFifthWinCombination() {
        ArrayList winCombination = board.getWinCombinations()[4];
        assertEquals( [1, 4, 7],  winCombination );
    }

    @Test
    public void testHasSixthWinCombination() {
        ArrayList winCombination = board.getWinCombinations()[5];
        assertEquals( [2, 5, 8],  winCombination );
    }

    @Test
    public void testHasSeventhWinCombination() {
        ArrayList winCombination = board.getWinCombinations()[6];
        assertEquals( [0, 4, 8],  winCombination );
    }


    @Test
    public void testHasEigthWinCombination() {
        ArrayList winCombination = board.getWinCombinations()[6];
        assertEquals( [2, 4, 6],  winCombination );
    }

    @Test
    public void testHasATotalOfEightCombinations() {
        ArrayList winCombinations = board.getWinCombinations();
        assertEquals( 8, winCombinations.size() );
    }

    @Test
    public void testGetAvailableSpots() {
        ArrayList availableSpots = board.getAvailableSpots();
        assertEquals( 9 , availableSpots );
    }
}
