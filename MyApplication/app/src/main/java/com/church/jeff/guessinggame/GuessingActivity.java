package com.church.jeff.guessinggame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Jeff on 10/12/2017.
 */

public class GuessingActivity extends AppCompatActivity {

    Button checkButton;
    int guessNumber, numberToGuess, numberOfGuesses;
    public static String numberOfGuessString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guessing_activity);

        locateViews();
        randomizeNumberToGuess();
        bindFunctionality();
    }

    void locateViews(){
        checkButton = (Button) findViewById(R.id.checkButton);
    }

    void randomizeNumberToGuess(){
        numberToGuess = (int)(Math.random() * 21);
        numberOfGuesses = 0;
    }


    void bindFunctionality(){
        checkButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                numberOfGuesses++;

                String guessNumberString = ((EditText) findViewById(R.id.guessNumber)).getText().toString();

                if(guessNumberString==""){
                    //If it does not, display a toast that tells the user to enter a number
                    Toast.makeText(GuessingActivity.this,
                            R.string.invalidGuess,
                            Toast.LENGTH_LONG).show();
                }
                else {
                    guessNumber = Integer.parseInt(guessNumberString);
                    if(guessNumber>numberToGuess){
                        //Display toast that guess is too high
                        Toast.makeText(GuessingActivity.this,
                                R.string.tooHigh,
                                Toast.LENGTH_LONG).show();
                    }
                    else if(guessNumber<numberToGuess) {
                        //Display toast that guess is low
                        Toast.makeText(GuessingActivity.this,
                                R.string.tooLow,
                                Toast.LENGTH_LONG).show();
                    }

                    else if(guessNumber==numberToGuess){
                        //Display toast that says correct
                        Toast.makeText(GuessingActivity.this,
                                R.string.correct,
                                Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(getApplicationContext(), ResultsActivity.class);

                        //Put a String extra into your intent, using the guess variable you have (cast it to String)
                         numberOfGuessString = String.valueOf(numberOfGuesses);
                        intent.putExtra(numberOfGuessString, numberOfGuessString);
                        //Navigate to ResultsActivity

                        startActivity(intent);
                    }
                }


            }
        });
    }
}
