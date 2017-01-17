package com.example.jivan.mathgame;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class multiplicacion extends AppCompatActivity implements View.OnClickListener {

    int[] answers;
    int correctAnswer;
    int score;
    int counterTime = 6000;

    CountDownTimer counter;

    Button buttonChoice1;
    Button buttonChoice2;
    Button buttonChoice3;

    TextView textObjectNum2;
    TextView textObjectNum1;
    TextView textObjectNum3;
    TextView textObjectScore;
    TextView textObjectCounter;

    int answerGiven = 0;
    int currentScore = 0;
    int currentLevel = 1;

    @Override

    public void onClick(View view) {


        switch (view.getId()) {


            case R.id.button1:

                answerGiven = Integer.parseInt("" + buttonChoice1.getText());

                break;

            case R.id.button2:
                answerGiven = Integer.parseInt("" + buttonChoice2.getText());
                break;

            case R.id.button3:
                answerGiven = Integer.parseInt("" + buttonChoice3.getText());
                break;

        }

        if (answerGiven == correctAnswer) {
            Toast.makeText(getApplicationContext(), "¡Correcto!",
                    Toast.LENGTH_SHORT).show();

            counter.cancel();

            score += 10;

            if ((score % 40) == 0) {
                nextLevel();
            }

            setQuestionAndAnswers();


        } else {
            Toast.makeText(getApplicationContext(), "Incorrecto :(",
                    Toast.LENGTH_SHORT).show();
            gameOver();

        }

    }

    protected void setQuestionAndAnswers() {

        Random randInt = new Random();

        int num1 = randInt.nextInt(12);
        num1++;

        int num2 = randInt.nextInt(12);
        num2++;


        answers = new int[3];
        answers[0] = num1 * num2;
        correctAnswer = answers[0];

        textObjectNum1.setText("" + num1);
        textObjectNum2.setText("" + num2);
        textObjectScore.setText("Score: " + score);

        answers[1] = answers[0] + (randInt.nextInt(10) + 1);
        answers[2] = answers[0] + (randInt.nextInt(10) + 1);

        this.shuffleArray(answers);
        this.shuffleArray(answers);

        buttonChoice1.setText("" + answers[0]);
        buttonChoice2.setText("" + answers[1]);
        buttonChoice3.setText("" + answers[2]);

        counter = new CountDownTimer(counterTime, 1000) {

            public void onTick(long millisUntilFinished) {
                textObjectCounter.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {

                gameOver();
            }
        }.start();


    }
    public void nextLevel() {

        counterTime -= 1000;
        if(counterTime == 1000) {
            return;
        }

    }

    protected void shuffleArray(int[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            if (i == index) {
                ++i;
            } else {
                int a = ar[index];
                ar[index] = ar[i];
                ar[i] = a;
            }
        }
    }

    @Override
    protected void onResume() {

        score = 0;

        super.onResume();

        this.setQuestionAndAnswers();

    }

    protected void onPause() {

        super.onPause();

        counter.cancel();

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplicacion);

        //---------- Operation ----------

        textObjectNum1 =
                (TextView) findViewById(R.id.textNum1);

        textObjectNum2 =
                (TextView) findViewById(R.id.textNum2);
        textObjectNum3 =
                (TextView) findViewById(R.id.textNum3);


        textObjectCounter = (TextView) findViewById(R.id.counter);

        textObjectScore = (TextView) findViewById(R.id.scoreText);


        // ---------- Answers -----------

        buttonChoice1 = (Button) findViewById(R.id.button1);
        buttonChoice2 = (Button) findViewById(R.id.button2);
        buttonChoice3 = (Button) findViewById(R.id.button3);

        buttonChoice1.setOnClickListener(this);
        buttonChoice2.setOnClickListener(this);
        buttonChoice3.setOnClickListener(this);


    }

    protected void gameOver() {
        counter.cancel();
        Intent i;
        i = new Intent(this, ScoreActivity.class);
        i.putExtra("score", score);
        i.putExtra("gameType", "multiplication");
        startActivity(i);
    }
}
