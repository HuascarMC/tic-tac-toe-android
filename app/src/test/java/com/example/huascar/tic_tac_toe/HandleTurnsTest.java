package com.example.huascar.tic_tac_toe;

import org.junit.Before;
import org.junit.Test;

import static android.telecom.Call.Details.hasProperty;
import static org.junit.Assert.assertThat;

/**
 * Created by huascar on 10/04/2018.
 */

public class HandleTurnsTest {

    @Before
    public void before() {
        handleTurns = new HandleTurns();
    }

    @Test
    public void testHasCurrentPlayerTokenProperty() {
        assertThat( handleTurns, hasProperty(currentPlayerToken) );
    }
}