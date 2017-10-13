package com.church.jeff.guessinggame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Jeff on 10/12/2017.
 */

public class ResultsActivity extends AppCompatActivity {
    Button restartButton;
    TextView numberOfGuessView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_activity);
        locateView();
        bindFunctionality();
        displayGuesses();
    }

    void locateView()
    {
        restartButton = (Button) findViewById(R.id.restartButton);
        numberOfGuessView = (TextView) findViewById(R.id.numberOfGuessView);
    }




    void bindFunctionality(){
        restartButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), LandingActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    void displayGuesses(){
        String guesses = getIntent().getStringExtra(GuessingActivity.numberOfGuessString);
        numberOfGuessView.setText(guesses);

    }

}
