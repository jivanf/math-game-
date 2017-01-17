package com.example.jivan.mathgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textFinalScore;
    TextView homeButton;
    TextView playAgainButton;


    Bundle extras;

    public void onClick(View view){


        Intent i;


        String temp = extras.getString("gameType");
        Log.i("info", temp);

        if(view.getId() == R.id.homeButton){
            i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        else {
            if(temp.equals(new String("sum"))) {
                i = new Intent(this, game.class);
            }

            else{
                if(temp.equals(new String("multiplication"))) {
                    i = new Intent(this, multiplicacion.class);
                }

                else {
                    i = new Intent(this, rests.class);
                }
            }

        }

        startActivity(i);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        extras = getIntent().getExtras();

        textFinalScore = (TextView)findViewById(R.id.textFinalScore);
        homeButton = (TextView)findViewById(R.id.homeButton);
        playAgainButton = (TextView)findViewById(R.id.playAgainButton);

        textFinalScore.setText("" + extras.getInt("score"));
        homeButton.setOnClickListener(this);
        playAgainButton.setOnClickListener(this);
        

    }
}
