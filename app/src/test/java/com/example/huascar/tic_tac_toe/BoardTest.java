package com.example.huascar.tic_tac_toe;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created by huascar on 08/04/2018.
 */

public class BoardTest {

    private Board board;

    @Before
    public void before() {
        board = new Board();
    }

    @Test
    public void testHasGrid() {
        ArrayList grid = board.getGrid();
        assertEquals( 9, grid.size() );
    }


}
