package com.example.huascar.tic_tac_toe;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

/**
 * Created by huascar on 08/04/2018.
 */

public class ComputerPlayerTest {

    private ComputerPlayer computerPlayer;
    private Board board;

    @Before
    public void before() {
        computerPlayer = new ComputerPlayer();
        computerPlayer.setToken("O");
        board = new Board();
    }

    @Test
    public void testHasToken() {

        assertNotNull( computerPlayer.getToken() );
    }

    @Test
    public void testPlayGridFour() {
        computerPlayer.play(board, 4);
        String[] grid = board.getGrid();
        assertEquals( computerPlayer.getToken(), grid[4] );
    }

    @Test
    public void testPlaySmart() {
        computerPlayer.play(board);
        String[] grid = board.getGrid();
        assertEquals( computerPlayer.getToken(), grid[4]);
    }

    @Test
    public void testSetTokenO() {
        computerPlayer.setToken("O");
        assertEquals( computerPlayer.getToken(), "O" );
    }

    @Test
    public void testSetTokenX() {
        computerPlayer.setToken("X");
        assertEquals( computerPlayer.getToken(), "X" );
    }

    @Test
    public void testAutoTokenX() {
        computerPlayer.autoToken("X");
        assertEquals( computerPlayer.getToken(), "O");
    }

    @Test
    public void testAutoTokenO() {
        computerPlayer.autoToken("O");
        assertEquals( computerPlayer.getToken(), "X");
    }

    @Test
    public void testInitializeAI() {
        computerPlayer.initializeAI();
        assertThat( computerPlayer.AI, instanceOf(AI.class) );
    }
}