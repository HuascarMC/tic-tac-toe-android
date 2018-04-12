package com.example.huascar.tic_tac_toe.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.huascar.tic_tac_toe.R;

public class Play extends AppCompatActivity {

    private TextView gridOne;
    private TextView gridTwo;
    private TextView gridThree;
    private TextView gridFour;
    private TextView gridFive;
    private TextView gridSix;
    private TextView gridSeven;
    private TextView gridEigth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        gridOne = findViewById(R.id.grid_1);
        gridTwo = findViewById(R.id.grid_2);
        gridThree = findViewById(R.id.grid_3);
        gridFour = findViewById(R.id.grid_4);
        gridFive = findViewById(R.id.grid_5);
        gridSix = findViewById(R.id.grid_6);
        gridSeven = findViewById(R.id.grid_7);
        gridEigth = findViewById(R.id.grid_8);
    }

}
