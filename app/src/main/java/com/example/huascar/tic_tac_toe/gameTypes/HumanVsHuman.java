package com.example.huascar.tic_tac_toe.gameTypes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.huascar.tic_tac_toe.Board;
import com.example.huascar.tic_tac_toe.ComputerPlayer;
import com.example.huascar.tic_tac_toe.GameState;
import com.example.huascar.tic_tac_toe.HandleTurns;
import com.example.huascar.tic_tac_toe.HumanPlayer;
import com.example.huascar.tic_tac_toe.R;

public class HumanVsHuman extends AppCompatActivity {

    private Board board;
    private GameState gameState;
    private HumanPlayer playerOne;
    private HumanPlayer playerTwo;
    private HandleTurns handleTurns;

    private TextView gridOne;
    private TextView gridTwo;
    private TextView gridThree;
    private TextView gridFour;
    private TextView gridFive;
    private TextView gridSix;
    private TextView gridSeven;
    private TextView gridEigth;
    private TextView gridNine;
    private TextView result;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        gridOne = findViewById(R.id.grid_3);
        gridTwo = findViewById(R.id.grid_2);
        gridThree = findViewById(R.id.grid_5);
        gridFour = findViewById(R.id.grid_6);
        gridFive = findViewById(R.id.grid_1);
        gridSix = findViewById(R.id.grid_8);
        gridSeven = findViewById(R.id.grid_4);
        gridEigth = findViewById(R.id.grid_7);
        gridNine = findViewById(R.id.grid_);
        result = findViewById(R.id.result);

        board = new Board();
        gameState = new GameState();
        playerOne = new HumanPlayer();
        playerTwo = new HumanPlayer();
        handleTurns = new HandleTurns();

        Intent intent = getIntent();

        Bundle extra = intent.getExtras();
        String firstToken = extra.getString("firstToken");

        setUp(firstToken);
    }

    public Board getBoard() {
        return board;
    }

    public void setUp(String firstToken) {
        handleTurns.setCurrentPlayerToken(firstToken);
            playerOne.setToken(firstToken);
            playerTwo.autoToken(firstToken);
            handleTurns.setCurrentPlayerToken(firstToken);
    }

    public void onClick(View textView) {
        TextView grid = (TextView) textView;
        int spot = Integer.parseInt((String) grid.getContentDescription());
        if (!gameState.finished(board)) {
            if (handleTurns.getCurrentPlayerToken().equals(playerOne.getToken())) {
                playerOne.play(board, spot);
                handleTurns.change();
            } else {
                playerTwo.play(board, spot);
                handleTurns.change();
            }
            if(gameState.finished(board)) {
                result.setText(String.format("%s wins!", gameState.getWinnerToken()));
            }
        }
        updateGrid();
    }

    public void updateGrid() {
        String[] grid = board.getGrid();
        gridOne.setText(grid[0]);
        gridTwo.setText(grid[1]);
        gridThree.setText(grid[2]);
        gridFour.setText(grid[3]);
        gridFive.setText(grid[4]);
        gridSix.setText(grid[5]);
        gridSeven.setText(grid[6]);
        gridEigth.setText(grid[7]);
        gridNine.setText(grid[8]);
    }
}
