package com.example.jivan.mathgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class game_book extends AppCompatActivity implements View.OnClickListener {

    int correctAnswer;
    int incorrectAnswer1;
    int incorrectAnswer2;
    Button buttonChoice1;
    Button buttonChoice2;
    Button buttonChoice3;

    TextView textObjectNum2;
    TextView textObjectNum1;
    TextView textObjectScore;
    TextView textObjectLevel;

    Button buttonObjectChoice1;
    Button buttonObjectChoice2;
    Button buttonObjectChoice3;

    int answerGiven = 0;
    int currentScore = 0;
    int currentLevel = 1;


    @Override

    public void onClick(View view){


        switch (view.getId()) {


            case R.id.button1:
                answerGiven = Integer.parseInt("" + buttonObjectChoice1.getText());
                break;

            case R.id.button2:
                answerGiven = Integer.parseInt("" + buttonObjectChoice2.getText());
                break;

            case R.id.button3:
                answerGiven = Integer.parseInt("" + buttonObjectChoice3.getText());
                break;

        }
    }

    void setQuestion() {



        int numberRange = currentLevel * 3;

        Random randInt = new Random();

        int num1 = randInt.nextInt(numberRange);

        num1++;
        int num2 = randInt.nextInt(numberRange);

        num1++;

        correctAnswer = num1 * num2;

        textObjectNum1.setText("" + num1);
        textObjectNum2.setText("" + num2);

    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //---------- Operation ----------


        textObjectNum2 =
                (TextView)findViewById(R.id.textNum2);
        textObjectNum1 =
                (TextView)findViewById(R.id.textNum1);
        textObjectScore =
                (TextView)findViewById(R.id.scoreText);





        buttonObjectChoice1 =
                (Button)findViewById(R.id.button1);
        buttonObjectChoice2 =
                (Button)findViewById(R.id.button2);
        buttonObjectChoice3 =
                (Button)findViewById(R.id.button3);



        // ---------- Answers -----------


        buttonChoice1 = (Button)findViewById(R.id.button1);
        buttonChoice2 = (Button)findViewById(R.id.button2);
        buttonChoice3 = (Button)findViewById(R.id.button3);

        buttonObjectChoice1.setOnClickListener(this);
        buttonObjectChoice2.setOnClickListener(this);
        buttonObjectChoice3.setOnClickListener(this);
    }
}
