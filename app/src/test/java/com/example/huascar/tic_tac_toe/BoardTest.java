package com.example.huascar.tic_tac_toe;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

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
        assertNotNull( board.getGrid() );
    }

    @Test
    public void testHasGridSizeOfNine() {
        String[] grid = board.getGrid();
        assertEquals( 9, grid.length );
    }

    @Test
    public void testHasWinCombinations() {
        assertNotNull( board.getWinCombinatinos() );
    }

    @Test
    public void testHasFirstWinCombination() {
        int[] winCombination = board.getWinCombinations()[0];
        int[] expectedResult = new int[]{0, 1, 2};
        assertEquals( expectedResult, winCombination );
    }

    @Test
    public void testHasSecondWinCombination() {
        int[] winCombination = board.getWinCombinations()[1];
        int[] expectedResult = new int[]{3, 4, 5};
        assertEquals( expectedResult, winCombination );
    }

    @Test
    public void testHasThirdWinCombination() {
        int[] winCombination = board.getWinCombinations()[2];
        int[] expectedResult = new int[]{6, 7, 8};
        assertEquals( expectedResult, winCombination );
    }

    @Test
    public void testHasFourthWinCombination() {
        int[] winCombination = board.getWinCombinations()[3];
        int[] expectedResult = new int[]{0, 3, 6};
        assertEquals( expectedResult, winCombination );
    }

    @Test
    public void testHasFifthWinCombination() {
        int[] winCombination = board.getWinCombinations()[4];
        int[] expectedResult = new int[]{1, 4, 7};
        assertEquals( expectedResult, winCombination );
    }

    @Test
    public void testHasSixthWinCombination() {
        int[] winCombination = board.getWinCombinations()[5];
        int[] expectedResult = new int[]{2, 5, 8};
        assertEquals( expectedResult, winCombination );
    }

    @Test
    public void testHasSeventhWinCombination() {
        int[] winCombination = board.getWinCombinations()[6];
        int[] expectedResult = new int[]{0, 4, 8};
        assertEquals( expectedResult, winCombination );
    }


    @Test
    public void testHasEigthWinCombination() {
        int[] winCombination = board.getWinCombinations()[6];
        int[] expectedResult = new int[]{2, 4, 6};
        assertEquals( expectedResult, winCombination );
    }

    @Test
    public void testHasATotalOfEightCombinations() {
        int[] winCombinations = board.getWinCombinations();
        assertEquals( 8, winCombinations.size() );
    }

    @Test
    public void testGetAvailableSpots() {
        int[] availableSpots = board.getAvailableSpots();
        assertEquals( 9 , availableSpots );
    }

    @Test
    public void testHasResetMethod() {
        assertNotNull( board.reset() );
    }
}
