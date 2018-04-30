package com.example.huascar.tic_tac_toe;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.*;
import static org.junit.Assert.assertArrayEquals;

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
        String[] result = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8"};
        assertArrayEquals( result, board.getGrid() );
    }

    @Test
    public void testHasGridSizeOfNine() {
        String[] grid = board.getGrid();
        assertEquals( 9, grid.length );
    }

    @Test
    public void testHasWinCombinations() {
        int[][] result = new int[][]{{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7,},{2,5,8},{0,4,8},{2,4,6}};
        assertArrayEquals( result, board.getWinCombinations() );
    }

    @Test
    public void testHasFirstWinCombination() {
        int[] winCombination = board.getWinCombinations()[0];
        int[] expectedResult = new int[]{0, 1, 2};
        assertArrayEquals( expectedResult, winCombination );
    }

    @Test
    public void testHasSecondWinCombination() {
        int[] winCombination = board.getWinCombinations()[1];
        int[] expectedResult = new int[]{3, 4, 5};
        assertArrayEquals( expectedResult, winCombination );
    }

    @Test
    public void testHasThirdWinCombination() {
        int[] winCombination = board.getWinCombinations()[2];
        int[] expectedResult = new int[]{6, 7, 8};
        assertArrayEquals( expectedResult, winCombination );
    }

    @Test
    public void testHasFourthWinCombination() {
        int[] winCombination = board.getWinCombinations()[3];
        int[] expectedResult = new int[]{0, 3, 6};
        assertArrayEquals( expectedResult, winCombination );
    }

    @Test
    public void testHasFifthWinCombination() {
        int[] winCombination = board.getWinCombinations()[4];
        int[] expectedResult = new int[]{1, 4, 7};
        assertArrayEquals( expectedResult, winCombination );
    }

    @Test
    public void testHasSixthWinCombination() {
        int[] winCombination = board.getWinCombinations()[5];
        int[] expectedResult = new int[]{2, 5, 8};
        assertArrayEquals( expectedResult, winCombination );
    }

    @Test
    public void testHasSeventhWinCombination() {
        int[] winCombination = board.getWinCombinations()[6];
        int[] expectedResult = new int[]{0, 4, 8};
        assertArrayEquals( expectedResult, winCombination );
    }


    @Test
    public void testHasEightWinCombination() {
        int[] winCombination = board.getWinCombinations()[7];
        int[] expectedResult = new int[]{2, 4, 6};
        assertArrayEquals( expectedResult, winCombination );
    }

    @Test
    public void testHasATotalOfEightCombinations() {
        int[][] winCombinations = board.getWinCombinations();
        assertEquals( 8, winCombinations.length );
    }

    @Test
    public void testGetAvailableSpots() {
        String[] availableSpots = board.getAvailableSpots();
        String[] expectedResult = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8"};
        assertArrayEquals( expectedResult, availableSpots );
    }

    @Test
    public void testSetSpotWithX() {
        board.setSpot(4, "X");
        String[] grid = board.getGrid();
        assertEquals( grid[4], "X");
    }

    @Test
    public void testSetSpotWithO() {
        board.setSpot(3, "O");
        String[] grid = board.getGrid();
        assertEquals( grid[3], "O");
    }

    @Test
    public void testSetGrid() {
        String[] newGrid = new String[]{"O", "1", "X", "O", "X", "5", "O", "7", "8"};
        board.setGrid(newGrid);
        assertEquals( board.getGrid(), newGrid);
    }

    @Test
    public void testRest() {
        board.setSpot(3, "O");
        String[] grid = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8"};
        board.reset();
        assertArrayEquals( board.getGrid(), grid );
    }

    @Test
    public void testCopyConstructor() {
        String[] newGrid = new String[]{"O", "1", "X", "O", "X", "5", "O", "7", "8"};
        board.setGrid(newGrid);
        Board clone = new Board(board);
        assertFalse( board.getGrid() == clone.getGrid() );
    }

}
