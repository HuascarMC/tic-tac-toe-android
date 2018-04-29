package com.example.huascar.tic_tac_toe;

import com.example.huascar.tic_tac_toe.gameTypes.HumanVsComputer;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by huascar on 11/04/2018.
 */

public class HumanVsComputerTest {

    private HumanVsComputer humanVsComputer;

    @Before
    public void before() {
        humanVsComputer = new HumanVsComputer("Human","X", "O" );
    }

    @Test
    public void testHasBoard() {
        Board board = humanVsComputer.getBoard();
        assertNotNull( board );
    }

    @Test
    public void testHasComputerPlayer() {
        ComputerPlayer computerPlayer = humanVsComputer.getComputerPlayer();
        assertNotNull( computerPlayer );
    }

    @Test
    public void testHasHumanPlayer() {
        HumanPlayer humanPlayer = humanVsComputer.getHumanPlayer();
        assertNotNull( humanPlayer );
    }

    @Test
    public void testHasGameState() {
        GameState gameState = humanVsComputer.getGameState();
        assertNotNull( gameState );
    }

    @Test
    public void testHasHandleTurns() {
        HandleTurns handleTurns = humanVsComputer.getHandleTurns();
        assertNotNull( handleTurns );
    }

    @Test
    public void testSetUpHuman() {
        HumanPlayer humanPlayer = humanVsComputer.getHumanPlayer();
        String result = humanPlayer.getToken();
        assertEquals( "X", result);
    }

    @Test
    public void testSetUpBot() {
        ComputerPlayer computerPlayer = humanVsComputer.getComputerPlayer();
        String result = computerPlayer.getToken();
        assertEquals( "O", result);
    }
}
