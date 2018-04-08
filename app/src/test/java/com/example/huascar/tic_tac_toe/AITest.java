package com.example.huascar.tic_tac_toe;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by huascar on 08/04/2018.
 */

public class AITest {

    private AI miniMax;
    private Board board;

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

}
