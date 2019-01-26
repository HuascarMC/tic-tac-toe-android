package com.example.huascar.tic_tac_toe;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.*;

/**
 * Created by huascar on 08/04/2018.
 */

public class AITest {

    private AI miniMax;
    private Board board;
    private String[] newGrid;

    @Before
    public void before() {
        board = new Board();
        miniMax = new AI("X");
    }

    @Test
    public void testHasToken() {
        assertEquals( miniMax.getToken(), "X" );
    }

    @Test
    public void testHasOpponentToken() {
        assertEquals( miniMax.getOpponentToken(), "O" );
    }

    @Test
    public void testSetOpponentToken() {
        miniMax.setOpponentToken();
        assertEquals( miniMax.getOpponentToken(), "O");
    }

    @Test
    public void testBestSpotIsMiddleIfEmpty() {
        assertEquals( miniMax.getBestSpot(board), 4 );
    }

    @Test
    public void testMaximizedSpotCaseWinning() {
        newGrid = new String[]{"X", "O", "X",
                               "O", "X", "5",
                               "O", "7", "8"};
        board.setGrid(newGrid);
        assertEquals( "8", miniMax.maximizedSpot(board, 0)[0] );
    }

    @Test
    public void testGetBestSpotCaseLosingCase2() {
        newGrid = new String[]{"0", "O", "X",
                               "O", "X", "5",
                               "O", "7", "8"};
        board.setGrid(newGrid);
        assertEquals( 0, miniMax.getBestSpot(board) );
    }

    @Test
    public void testMaximizedSpotCaseLosing2() {
        newGrid = new String[]{"0", "1", "2",
                               "3", "X", "O",
                               "6", "7", "O"};
        board.setGrid(newGrid);
        assertEquals( "2", miniMax.maximizedSpot(board, 0)[0] );
    }

    @Test
    public void testGetBestSpotCaseLosing() {
        newGrid = new String[]{"0", "1", "X",
                               "3", "X", "O",
                               "6", "O", "O"};
        board.setGrid(newGrid);
        assertEquals( miniMax.getBestSpot(board), 6 );
    }

    @Test
    public void testGetScore() {
        assertEquals( miniMax.getScore(board, 0), 0 );
    }

    @Test
    public void testGetScoreCase2() {
        newGrid = new String[]{"X", "O", "X",
                               "O", "X", "5",
                               "O", "7", "X"};
        board.setGrid(newGrid);
        assertEquals( miniMax.getScore(board, 0), -1);
    }

    @Test
    public void testGetScoreCase3() {
        newGrid = new String[]{"O", "1", "X",
                               "O", "X", "5",
                               "O", "7", "X"};
        board.setGrid(newGrid);
        assertEquals( 1, miniMax.getScore(board, 0));
    }

    @Test
    public void testGetScoreCase4() {
        newGrid = new String[]{"X", "O", "X",
                               "O", "X", "5",
                               "O", "O", "8"};
        board.setGrid(newGrid);
        assertEquals( 0, miniMax.getScore(board, 0));
    }
}
