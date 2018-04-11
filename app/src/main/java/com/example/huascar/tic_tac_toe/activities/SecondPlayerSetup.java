package com.example.huascar.tic_tac_toe.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.huascar.tic_tac_toe.R;

public class SecondPlayerSetup extends AppCompatActivity {

    private String token;
    private String player;
    public Button humanButton;
    private Button botButton;
    private Button tokenXButton;
    private Button tokenOButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_player_setup);

        token = null;
        player = null;

        humanButton = findViewById(R.id.human_button);
        botButton = findViewById(R.id.bot_button);
        tokenXButton = findViewById(R.id.x_button);
        tokenOButton = findViewById(R.id.o_button);
    }

    public String getPlayer() {
        return player;
    }

    public String getToken() {
        return token;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
