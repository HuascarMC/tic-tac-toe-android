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
    private ComputerPlayer playerTwo;
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
        computerPlayer = new ComputerPlayer();
        humanPlayer = new HumanPlayer();
        handleTurns = new HandleTurns();

        Intent intent = getIntent();

        Bundle extra = intent.getExtras();
        String firstPlayer = extra.getString("firstPlayer");
        String firstToken = extra.getString("firstToken");

        setUp(firstPlayer, firstToken);
    }

    public Board getBoard() {
        return board;
    }

    public void setUp( String firstPlayer, String firstToken) {
        handleTurns.setCurrentPlayerToken(firstToken);
        if( firstPlayer.equals("Human") ) {
            humanPlayer.setToken(firstToken);
            computerPlayer.autoToken(firstToken);
            handleTurns.setCurrentPlayerToken(firstToken);
        } else {
            computerPlayer.setToken(firstToken);
            humanPlayer.autoToken(firstToken);
            handleTurns.setCurrentPlayerToken(firstToken);
        }
    }

    public void onClick(View textView) {
        TextView grid = (TextView) textView;
        if(!gameState.finished(board)) {
            int spot = Integer.parseInt((String) grid.getContentDescription());
            humanPlayer.play(board, spot);
            updateGrid();
            computerPlayer.play(board);
            updateGrid();
            if(gameState.finished(board)) {
                result.setText(String.format("%s wins!", gameState.getWinnerToken()));
            }
        }
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
