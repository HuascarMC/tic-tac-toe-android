package com.example.huascar.tic_tac_toe;

import com.example.huascar.tic_tac_toe.activities.FirstPlayerSetUp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FirstPlayerSetupTest {

    private FirstPlayerSetUp firstPlayerSetUp;

    @Before
    public void before() {
        firstPlayerSetUp = new FirstPlayerSetUp();
    }

    @Test
    public void testPlayerIsNull() {
        assertEquals( firstPlayerSetUp.getPlayer(), null );
    }

    @Test
    public void testTokenIsNull() {
        assertEquals( firstPlayerSetUp.getToken(), null );
    }

    @Test
    public void testSetPlayer() {
        firstPlayerSetUp.setPlayer("Human");
        assertEquals( firstPlayerSetUp.getPlayer(), "Human");
    }
}
