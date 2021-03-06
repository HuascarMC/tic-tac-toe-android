package com.example.huascar.tic_tac_toe.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.huascar.tic_tac_toe.R;
import com.example.huascar.tic_tac_toe.gameTypes.HumanVsComputer;
import com.example.huascar.tic_tac_toe.gameTypes.HumanVsHuman;

public class SecondPlayerSetup extends AppCompatActivity {

    private String secondToken;
    private String secondPlayer;
    private String firstPlayer;
    private String firstToken;
    public Button humanButton;
    private Button botButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_player_setup);

        Intent intent = getIntent();

        Bundle extra = intent.getExtras();
        firstPlayer = extra.getString("firstPlayer");
        firstToken = extra.getString("firstToken");

        secondToken = null;
        secondPlayer = null;

        humanButton = findViewById(R.id.human_button);
        botButton = findViewById(R.id.bot_button);
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


    public void onPlayClick(View buttonView) {
        Button button = (Button) buttonView;
        button.setTextColor(Color.parseColor("#FDA570"));

        if( firstPlayer.equals("Human") && secondPlayer.equals("Bot") || firstPlayer.equals("Bot") && secondPlayer.equals("Human") ) {
            Intent intent = new Intent(SecondPlayerSetup.this, HumanVsComputer.class);
            intent.putExtra("firstPlayer", firstPlayer);
            intent.putExtra("firstToken", firstToken);
            startActivity(intent);
        } else if ( firstPlayer.equals("Human") && secondPlayer.equals("Human")) {
            Intent intent = new Intent( SecondPlayerSetup.this, HumanVsHuman.class);
            intent.putExtra("firstPlayer", firstPlayer);
            intent.putExtra("firstToken", firstToken);
            startActivity(intent);
        }
        button.setTextColor(Color.parseColor("#F3EEEB"));

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

}
