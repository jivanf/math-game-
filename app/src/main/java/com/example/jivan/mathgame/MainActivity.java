package com.example.jivan.mathgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onClick(View view){

        Intent i;

        if(view.getId()==R.id.sumButton){
            i = new Intent(this, game.class);
            startActivity(i);
        }

        else {
            if(view.getId() == R.id.multiplicationButton) {
                i = new Intent(this, multiplicacion.class);
                startActivity(i);
            }

            else {
                i = new Intent(this, rests.class);
                startActivity(i);
            }
        }

        startActivity(i);
    }
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playButton = (Button)findViewById(R.id.sumButton);
        playButton.setOnClickListener(this);

        Button playButton2 = (Button)findViewById(R.id.multiplicationButton);
        playButton2.setOnClickListener(this);

        Button playButton3 = (Button)findViewById(R.id.restsButton);
        playButton3.setOnClickListener(this);

    }


}


