package com.example.huascar.tic_tac_toe.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
}
