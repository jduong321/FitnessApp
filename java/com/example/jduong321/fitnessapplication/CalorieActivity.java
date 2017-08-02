package com.example.jduong321.fitnessapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by Jacky on 6/10/2017.
 */

public class CalorieActivity extends AppCompatActivity {

    private Button addButton;
    private ListView foodList;
    private EditText foodName;
    private EditText foodCalorie;
    private TextView totalCalorie;

    private ArrayList<String> listFood;    // list of user requests
    private ArrayAdapter listFoodAdapter;  // adapter for the above list

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie);

        addButton = (Button) findViewById(R.id.addButton);
        foodList = (ListView) findViewById(R.id.listView);
        foodName = (EditText) findViewById(R.id.inputName);
        foodCalorie = (EditText) findViewById(R.id.inputNumber);
        totalCalorie = (TextView) findViewById(R.id.totalNumber);


        FileInputStream fis;
        try {
            fis = openFileInput("listview.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            listFood = (ArrayList<String>) ois.readObject();
            //CREATE ADAPTER TO HAVE TWO TEXTVIEW
            //https://stackoverflow.com/questions/20985668/is-there-a-way-to-update-multiple-textview-with-arrayadapter

            listFoodAdapter = new ArrayAdapter(this, R.layout.calorie_layout,R.id.foodCalorie, listFood);
            foodList.setAdapter(listFoodAdapter);
            ois.close();
        } catch (FileNotFoundException e) {
            Log.i(CalorieActivity.class.getSimpleName(),"FILE1 NOT FOUND");
            Log.i(CalorieActivity.class.getSimpleName(),e.getMessage());
        } catch (IOException e) {
            Log.i(CalorieActivity.class.getSimpleName(),e.getMessage());
            Log.i(CalorieActivity.class.getSimpleName(),"FILE2 NOT FOUND");
        } catch (ClassNotFoundException e) {
            Log.i(CalorieActivity.class.getSimpleName(),e.getMessage());
            Log.i(CalorieActivity.class.getSimpleName(),"FILE3 NOT FOUND");
        }
        if(listFood == null) {
            listFood = new ArrayList<String>();
            Log.i(CalorieActivity.class.getSimpleName(),"Created listFood");
        }
        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                String name, count;
                if(foodName != null ||foodCalorie != null) {
                    count = foodCalorie.getText().toString();
                    name = foodName.getText().toString();
                    Log.i(CalorieActivity.class.getSimpleName(),name);
                    Log.i(CalorieActivity.class.getSimpleName(),count);
                    listFood.add(count);
                    listFoodAdapter.notifyDataSetChanged();
                    updateTotal();
                }
                else
                {
                    //some error
                }


            }
        });
    }
    //THIS DOESNT WORK
    public void updateTotal()
    {

        int itemsCount = foodList.getChildCount();
        int totalCal = 0;
        for(int i = 0; i < itemsCount; i++)
        {
            View view = foodList.getChildAt(i);
            //String itemName = ((TextView) view.findViewById(R.id.foodName)).getText().toString();
            String itemCal = ((TextView) view.findViewById(R.id.foodCalorie)).getText().toString();
            int num = Integer.parseInt(itemCal);
            totalCal+=num;
        }
        Log.i(CalorieActivity.class.getSimpleName(),Integer.toString(totalCal));
        totalCalorie.setText(Integer.toString(totalCal));
    }
    @Override
    public void onPause()
    {
        //if app stops for any reason store listview for next time
        String filename = "listview.txt";
        FileOutputStream fos;
        try {
            fos = getApplicationContext().openFileOutput(filename, Context.MODE_PRIVATE);

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listFood);
            Log.i(CalorieActivity.class.getSimpleName(),"WOKE");
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onPause();
    }
}
