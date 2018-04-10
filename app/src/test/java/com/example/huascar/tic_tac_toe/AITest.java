package com.example.huascar.tic_tac_toe;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import dalvik.annotation.TestTarget;

import static junit.framework.Assert.*;
import static org.junit.Assert.assertThat;

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
    public void testBestSpotIsMiddleIfEmpty() throws CloneNotSupportedException {
        assertEquals( miniMax.getBestSpot(board), 4 );
    }

    @Test
    public void testMaximizedSpotCaseWinning() throws CloneNotSupportedException {
        newGrid = new String[]{"X", "O", "X", "O", "X", "5","O", "7", "8"};
        board.setGrid(newGrid);
        Object[] result = new Object[]{"8", 1};
        assertEquals( miniMax.maximizedSpot(board), result);
    }

    @Test
    public void testMinimizedSpotCaseLosing() throws CloneNotSupportedException {
        newGrid = new String[]{"0", "O", "X", "O", "X", "5", "O", "7", "8"};
        board.setGrid(newGrid);
        Object[] result = new Object[]{"0", -1};
        assertEquals( miniMax.minimizedSpot(board), result);
    }

    @Test
    public void testGetScore() {
        assertEquals( miniMax.getScore(board), 0 );
    }

}
