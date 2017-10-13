package com.church.jeff.guessinggame;
/**
 * @Author: Jeff Church
 * @Date: 10/12/2017
 * @Assignment: Assignment 02 - Guessing Game
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LandingActivity extends AppCompatActivity {

    private Button startGame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        findButton();
        bindFunctionality();
    }

    private void findButton(){
        startGame = (Button) findViewById(R.id.startGame);

    }

    void bindFunctionality(){
        startGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), GuessingActivity.class);
                startActivity(intent);
            }
        });
    }
}
