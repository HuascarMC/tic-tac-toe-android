package com.example.huascar.tic_tac_toe;

import org.junit.Before;
import org.junit.Test;

import dalvik.annotation.TestTarget;

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
        miniMax = new Minimax("X");
    }

    @Test
    public void testHasToken() {
        assertEquals( mimiMax.getToken(), "X" );
    }

    @Test
    public void testHasWinnerProperty() {
        assertEquals( miniMax.getWinner(), null );
    }

    @Test
    public void testSetsWinnerX() {
        miniMax.setWinner("X");
        assertEquals( miniMax.getWinner(), "X" );
    }

    @Test
    public void testSetsWinnerO() {
        miniMax.setsWinner("O");
        assertEquals( miniMax.getWinner(), "O");
    }

    @Test
    public void testHasOpponentToken() {
        assertEquals( miniMax.getOpponentToken, null );
    }

    @Test
    public void testSetOpponentToken() {
        miniMax.setOpponentToken();
        assertEquals( miniMax.getOpponentToken, "O");
    }

    @Test
    public void testGameStateProperty() {
        assertNotNull( miniMax.gameState() );
    }

    @Test
    public void testBestSpotIsMiddleIfEmpty() {
        assertEquals( miniMax.getBestSpot(board), 4 );
    }

    @Test
    public void testMaximizedSpotCaseWinning() {
        newGrid = new String[]{"X", "O", "X", "O", "X", "5","O", "7", "8"};
        board.setGrid(newGrid);
        assertEquals( miniMax.maximizedSpot(board), '8');
    }

    @Test
    public void testMinimizedSpotCaseLosing() {
        newGrid = new String[]{"0", "O", "X", "O", "X", "5", "O", "7", "8"};
        board.setGrid(newGrid);
        assertEquals( miniMax.minimizedSpot(board), '0');
    }

    @Test
    public void testGetScore() {
        assertEquals( miniMax.getScore(board), 0 );
    }

}
