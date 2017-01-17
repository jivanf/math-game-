package com.example.jivan.mathgame;

import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Stopwatch {

    static int interval;
    static Timer timer;
    TextView counterObj;

    Stopwatch(TextView counter){

        int delay = 1000;
        int period = 1000;

        counterObj = counter;



        timer = new Timer();

        interval = 10;

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                setInterval();



                counterObj.setText("sdsd");

            }
        }, delay, period);

    }

    protected int setInterval() {
        if (interval == 1) {
            timer.cancel();
        }

        --interval;

        return interval;

    }
}
