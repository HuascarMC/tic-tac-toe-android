package com.example.huascar.tic_tac_toe;

/**
 * Created by huascar on 08/04/2018.
 */

public class HumanPlayer extends Player {

    private String token;

   public HumanPlayer() {
       super();
   }

   public String getToken() {
       return token;
   }

   public void setToken(String token) {
       this.token = token;
   }

   public void autoToken(String token) {
       if(token.equals("X")) {
           this.setToken("O");
       } else {
          this.setToken("X");
       }
   }

   public void play(Board board, int spot) {
       board.setSpot(spot, token);
   }

}
