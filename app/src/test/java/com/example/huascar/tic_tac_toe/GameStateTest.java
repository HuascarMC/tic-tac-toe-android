package com.example.huascar.tic_tac_toe;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by huascar on 08/04/2018.
 */

public class GameStateTest {

    private GameState gameState;
    private Board board;
    private String[] newGrid;

    @Before
    public void before() {
        board = new Board();
        gameState = new GameState();
    }

    @Test
    public void TestNotFinished() {
        assertEquals( gameState.finished(board), false );
    }

    @Test
    public void testFinishedWithWin() {
        newGrid = new String[]{"O", "1", "X", "O", "X", "5", "O", "7", "8"};
        board.setGrid(newGrid);
        assertEquals( gameState.finished(board), true );
    }

    @Test
    public void testFinishedWithTie() {
        newGrid = new String[]{"X", "O", "X", "O", "X", "O", "O", "X", "O"};
        board.setGrid(newGrid);
        assertEquals( gameState.finished(board), true );

    }

    @Test
    public void testCheckWinFalse() {
        assertEquals( gameState.checkWin(board)[0], false );
    }

    @Test
    public void testCheckWinTrue() {
        newGrid = new String[]{"O", "1", "X", "O", "X", "5", "O", "7", "8"};
        board.setGrid(newGrid);
        assertEquals( gameState.checkWin(board), true );
    }


}
