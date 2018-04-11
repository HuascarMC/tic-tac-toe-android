package com.example.huascar.tic_tac_toe.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.huascar.tic_tac_toe.R;

public class FirstPlayerSetUp extends AppCompatActivity {

    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_player_setup);
    }

    public String getToken() {
        return token;
    }
}
