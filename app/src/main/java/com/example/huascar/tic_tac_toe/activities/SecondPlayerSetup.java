package com.example.huascar.tic_tac_toe.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.huascar.tic_tac_toe.R;

public class SecondPlayerSetup extends AppCompatActivity {

    private String secondToken;
    private String secondPlayer;
    public Button humanButton;
    private Button botButton;
    private Button tokenXButton;
    private Button tokenOButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_player_setup);

        Intent intent = getIntent();

        Bundle extra = intent.getExtras();
        String firstPlayer = extra.getString("firstPlayer");
        String firstToken = extra.getString("firstToken");

        secondToken = null;
        secondPlayer = null;

        humanButton = findViewById(R.id.human_button);
        botButton = findViewById(R.id.bot_button);
        tokenXButton = findViewById(R.id.x_button);
        tokenOButton = findViewById(R.id.o_button);
    }

    public String getPlayer() {
        return secondPlayer;
    }

    public String getToken() {
        return secondToken;
    }

    public void setPlayer(String player) {
        this.secondPlayer = player;
    }

    public void setToken(String token) {
        this.secondToken = token;
    }

    public void onContinueClick(View buttonView) {
        Button button = (Button) buttonView;
        button.setTextColor(Color.parseColor("#FDA570"));

    }

    public void onPreviousClick(View buttonView) {
        Button button = (Button) buttonView;
        button.setTextColor(Color.parseColor("#FDA570"));

        Intent intent = new Intent( SecondPlayerSetup.this, FirstPlayerSetUp.class );
        startActivity(intent);
    }

    public void onOptionClick(View buttonView) {
        Button button = (Button) buttonView;
        handlePlayerButton(button);
        handleTokenButton(button);
    }

    public void handlePlayerButton(Button button) {
        if( button.getText() == humanButton.getText() ) {
            botButton.setTextColor(Color.parseColor("#F3EEEB"));
            humanButton.setTextColor(Color.parseColor("#FDA570"));
            setPlayer(button.getText().toString());
        } else if ( button.getText() == botButton.getText() ) {
            humanButton.setTextColor(Color.parseColor("#F3EEEB"));
            botButton.setTextColor(Color.parseColor("#FDA570"));
            setPlayer(button.getText().toString());
        }
    }

    public void handleTokenButton(Button button) {
        if( button.getText() == tokenXButton.getText() ) {
            tokenOButton.setTextColor(Color.parseColor("#F3EEEB"));
            tokenXButton.setTextColor(Color.parseColor("#FDA570"));
            setToken(button.getText().toString());
        } else if ( button.getText() == tokenOButton.getText() ) {
            tokenXButton.setTextColor(Color.parseColor("#F3EEEB"));
            tokenOButton.setTextColor(Color.parseColor("#FDA570"));
            setToken(button.getText().toString());
        }
    }
}