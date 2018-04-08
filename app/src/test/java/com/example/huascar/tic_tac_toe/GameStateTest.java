package com.example.huascar.tic_tac_toe;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by huascar on 08/04/2018.
 */

public class GameStateTest {

    private GameState gameState;
    private Board board;

    @Before
    public void before() {
        board = new Board();
        gameState = new GameState();
    }

    @Test
    public void TestNotFinished() {
        assertEquals( gameState.finished(board), false );
    }
}
