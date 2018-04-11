package com.example.huascar.tic_tac_toe;

import com.example.huascar.tic_tac_toe.activities.SecondPlayerSetup;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SecondPlayerSetupTest {

    private SecondPlayerSetup secondPlayerSetup;

    @Before
    public void before() {
        secondPlayerSetup = new SecondPlayerSetup();
    }

    @Test
    public void testPlayerIsNull() {
        assertEquals( secondPlayerSetup.getPlayer(), null );
    }

    @Test
    public void testTokenIsNull() {
        assertEquals( secondPlayerSetup.getToken(), null );
    }

    @Test
    public void testSetPlayer() {
        secondPlayerSetup.setPlayer("Human");
        assertEquals( secondPlayerSetup.getPlayer(), "Human" );
    }

    @Test
    public void testSetToken() {
        secondPlayerSetup.setToken("O");
        assertEquals( secondPlayerSetup.getToken(), "O" );
    }

}
