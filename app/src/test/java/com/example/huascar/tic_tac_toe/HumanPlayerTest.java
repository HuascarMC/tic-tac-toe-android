package com.example.huascar.tic_tac_toe;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by huascar on 08/04/2018.
 */

public class HumanPlayerTest {

    private HumanPlayer humanPlayer;
    private Board board;
    @Before
    public void before() {
        humanPlayer = new HumanPlayer();
        humanPlayer.setToken("O");
        board = new Board();
    }

    @Test
    public void testHasToken() {

        assertNotNull( humanPlayer.getToken() );
    }

    @Test
    public void testPlayGridOne() {
        humanPlayer.play(board, 0);
        String[] grid = board.getGrid();
        assertEquals( humanPlayer.getToken(), grid[0] );
    }

    @Test
    public void testSetTokenO() {
        humanPlayer.setToken("O");
        assertEquals( humanPlayer.getToken(), "O" );
    }

    @Test
    public void testSetTokenX() {
        humanPlayer.setToken("X");
        assertEquals( humanPlayer.getToken(), "X" );
    }

    @Test
    public void testAutoTokenX() {
        humanPlayer.autoToken("X");
        assertEquals( humanPlayer.getToken(), "O");
    }

    @Test
    public void testAutoTokenO() {
        humanPlayer.autoToken("O");
        assertEquals( humanPlayer.getToken(), "X");
    }


}
