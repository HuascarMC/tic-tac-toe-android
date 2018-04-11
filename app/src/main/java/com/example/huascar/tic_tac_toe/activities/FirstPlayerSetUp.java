package com.example.huascar.tic_tac_toe.activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.huascar.tic_tac_toe.R;

public class FirstPlayerSetUp extends AppCompatActivity {

    private String token;
    private String player;
    private Button humanButton;
    private Button botButton;
    private Button tokenXButton;
    private Button tokenOButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_player_setup);

        token = null;
        player = null;

        humanButton = findViewById(R.id.human_button);
        botButton = findViewById(R.id.bot_button);
        tokenXButton = findViewById(R.id.x_button);
        tokenOButton = findViewById(R.id.o_button);
    }

    public String getToken() {
        return token;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void onClick(View buttonView) {
        Button button = (Button) buttonView;
        String buttonScan = button.getText().toString();
        Log.d("buttonScan", buttonScan);
        handlePlayerButton(button);
        handleTokenButton(button);
    }

    public void handlePlayerButton(Button button) {
        if( button.getText() == humanButton.getText() ) {
            botButton.setTextColor(Color.parseColor("#F3EEEB"));
            humanButton.setTextColor(Color.parseColor("#FDA570"));
        } else if ( button.getText() == botButton.getText() ) {
            humanButton.setTextColor(Color.parseColor("#F3EEEB"));
            botButton.setTextColor(Color.parseColor("#FDA570"));
        }
        setPlayer(button.getText().toString());
    }

    public void handleTokenButton(Button button) {
        if( button.getText() == tokenOButton.getText() ) {
            tokenXButton.setTextColor(Color.parseColor("#F3EEEB"));
            tokenOButton.setTextColor(Color.parseColor("#FDA570"));
        } else if ( button.getText() == tokenXButton.getText() ) {
            tokenOButton.setTextColor(Color.parseColor("#F3EEEB"));
            tokenXButton.setTextColor(Color.parseColor("#FDA570"));
        }
        setToken(button.getText().toString());
    }

}
