package com.example.jduong321.fitnessapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Integer> activityPicList = new ArrayList<Integer>(Arrays.asList(R.drawable.food,R.drawable.workout,R.drawable.flex,R.drawable.hiit));
    private ArrayList<String> activityNameList = new ArrayList<String>(Arrays.asList("Calorie Counter","Programs","Progress","HIIT"));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = (ListView) findViewById(R.id.ListView);
        lv.setAdapter(new FitnessAdapter(this,activityPicList,activityNameList));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Log.i("MainActivity","found" +position);
                if(position == 0)
                {
                    Toast.makeText(MainActivity.this,"Calorie clicked", Toast.LENGTH_LONG).show();
                    Log.i("MainActivity","Calorie" +position);
                    Intent i = new Intent(MainActivity.this,CalorieActivity.class);
                    startActivity(i);
                }
                else if(position == 1)
                {
                    Toast.makeText(MainActivity.this,"Program clicked", Toast.LENGTH_LONG).show();
                    Log.i("MainActivity","Program" +position);
                    Intent i = new Intent(MainActivity.this,ProgramActivity.class);
                    startActivity(i);

                }
                else if(position == 2)
                {
                    Toast.makeText(MainActivity.this,"Progress clicked", Toast.LENGTH_LONG).show();
                    Log.i("MainActivity","Progress" +position);
                    //https://developer.android.com/training/camera/photobasics.html

                }
                else if(position == 3)
                {
                    Toast.makeText(MainActivity.this,"HIIT clicked", Toast.LENGTH_LONG).show();
                    Log.i("MainActivity","HIIT" +position);
                    Intent i = new Intent(MainActivity.this,TimerActivity.class);
                    startActivity(i);

                }
            }
        });
    }
}
