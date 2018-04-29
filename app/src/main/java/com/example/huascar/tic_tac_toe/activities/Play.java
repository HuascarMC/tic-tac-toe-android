package com.example.huascar.tic_tac_toe.activities;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.huascar.tic_tac_toe.ComputerPlayer;
import com.example.huascar.tic_tac_toe.GameType;
import com.example.huascar.tic_tac_toe.HumanPlayer;
import com.example.huascar.tic_tac_toe.Player;
import com.example.huascar.tic_tac_toe.R;
import com.example.huascar.tic_tac_toe.gameTypes.HumanVsComputer;

public class Play extends AppCompatActivity {

    private TextView gridOne;
    private TextView gridTwo;
    private TextView gridThree;
    private TextView gridFour;
    private TextView gridFive;
    private TextView gridSix;
    private TextView gridSeven;
    private TextView gridEigth;
    private Player player1;
    private Player player2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        gridOne = findViewById(R.id.grid_1);
        gridTwo = findViewById(R.id.grid_2);
        gridThree = findViewById(R.id.grid_1);
        gridFour = findViewById(R.id.grid_4);
        gridFive = findViewById(R.id.grid_5);
        gridSix = findViewById(R.id.grid_6);
        gridSeven = findViewById(R.id.grid_7);
        gridEigth = findViewById(R.id.grid_8);

        Intent intent = getIntent();

        Bundle extra = intent.getExtras();
        String firstPlayer = extra.getString("firstPlayer");
        String firstToken = extra.getString("firstToken");
        String secondPlayer = extra.getString("secondPlayer");
        String secondToken = extra.getString("secondToken");

        this.loadSetUp(firstPlayer, firstToken, secondPlayer, secondToken);
    }

    public void loadSetUp(String firstPlayer, String firstToken, String secondPlayer, String secondToken) {
        if(firstPlayer.equals(secondPlayer) && firstPlayer.equals("Computer")) {
            player1 = new ComputerPlayer();
            player2 = new ComputerPlayer();
        } else if(firstPlayer.equals(secondPlayer) && firstPlayer.equals("Human")) {
            player1 = new HumanPlayer();
            player2 = new HumanPlayer();
        } else {

        }
    }

    public void onClick(View textView) {
        TextView grid = (TextView) textView;
        grid.setText("X");
    }



}
