package com.example.jduong321.fitnessapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;

/**
 * Created by Jacky on 6/9/2017.
 */

public class TimerActivity extends AppCompatActivity {
    //countdowntimer

    private int counter;
    private Button roundPlus;
    private Button roundMinus;
    private Button hiitPlus;
    private Button hiitMinus;
    private Button restPlus;
    private Button restMinus;
    private Button start;
    private TextView restText;
    private TextView hiitText;
    private TextView roundText;
    private TextView mainText;

    long timeInMillies = 0L;
    long timeSwap = 0L;
    long finalTime = 0L;
    long startTime = 0L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        mainText = (TextView) findViewById(R.id.mainText);
        start = (Button) findViewById(R.id.startButton);

        roundText = (TextView) findViewById(R.id.roundText);
        roundPlus = (Button) findViewById(R.id.roundplusButton);
        roundMinus = (Button) findViewById(R.id.roundminusButton);

        hiitText = (TextView) findViewById(R.id.hiitText);
        hiitPlus = (Button) findViewById(R.id.hiitplusButton);
        hiitMinus = (Button) findViewById(R.id.hiitminusButton);

        restText = (TextView) findViewById(R.id.restText);
        restPlus = (Button) findViewById(R.id.restplusButton);
        restMinus = (Button) findViewById(R.id.restminusButton);

        roundPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = roundText.getText().toString();
                int inc = Integer.parseInt(temp) +1;
                roundText.setText("" +inc);
            }
        });

        roundMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = roundText.getText().toString();
                int inc = Integer.parseInt(temp) -1;
                roundText.setText("" +inc);
            }
        });

        hiitMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = hiitText.getText().toString();
                int inc = Integer.parseInt(temp) -1;
                hiitText.setText("" +inc);
            }
        });

        hiitPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = hiitText.getText().toString();
                int inc = Integer.parseInt(temp) +1;
                hiitText.setText("" +inc);
            }
        });

        restMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = restText.getText().toString();
                int inc = Integer.parseInt(temp) -1;
                restText.setText("" +inc);
            }
        });

        restPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = restText.getText().toString();
                int inc = Integer.parseInt(temp) +1;
                restText.setText("" +inc);
            }
        });

        start.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                counter = Integer.parseInt(hiitText.getText().toString());

                Log.i("TimerActivity","found" +counter);
                new CountDownTimer(counter*1000, 500){
                    public void onTick(long millisUntilFinished){
                        long seconds = millisUntilFinished / 1000;
                        /**
                        mainText.setText(timeFormat.format(millisUntilFinished));
                        long te = 50000 - millisUntilFinished;
                        restText.setText("Time Elapsed: " + timeFormat.format(te));
                         **/

                        mainText.setText(String.format("%02d:%02d:%02d", seconds / 3600,
                                (seconds % 3600) / 60, (seconds % 60)));
                    }
                    public  void onFinish(){
                        mainText.setText("FINISH!!");
                    }
                }.start();
            }
        });
    }
}
