package com.example.jduong321.fitnessapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

public class ProgramActivity extends AppCompatActivity {

    private ArrayList<String> programList;    // list of user requests
    private ArrayAdapter programListAdapter;  // adapter for the above list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);

        ListView transactionList = (ListView) findViewById(R.id.listView);

        FileInputStream fis;
        try {
            fis = openFileInput("programs.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            programList = (ArrayList<String>) ois.readObject();
            programListAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, programList);
            transactionList.setAdapter(programListAdapter);
            ois.close();
        } catch (FileNotFoundException e) {
            Log.i(ProgramActivity.class.getSimpleName(),"FILE1 NOT FOUND");
        } catch (IOException e) {
            Log.i(ProgramActivity.class.getSimpleName(),"FILE2 NOT FOUND");
        } catch (ClassNotFoundException e) {
            Log.i(ProgramActivity.class.getSimpleName(),"FILE3 NOT FOUND");
        }


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("name");
            programList.add(value);
            programListAdapter.notifyDataSetChanged();
            //The key argument here must match that used in the other activity
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.program_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.createProgram:
                Intent i = new Intent(ProgramActivity.this,CreateProgramActivity.class);
                startActivity(i);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onPause()
    {
        //if app stops for any reason store listview for next time
        FileOutputStream fos;
        try {
            fos = getApplicationContext().openFileOutput("programs.txt", Context.MODE_PRIVATE);

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(programList);
            Log.i(ProgramActivity.class.getSimpleName(),"WOKE");
            oos.close();
        } catch (FileNotFoundException e) {
            Log.i(ProgramActivity.class.getSimpleName(),"FILE NOT FOUND");
        }catch(IOException e){
            Log.i(ProgramActivity.class.getSimpleName(),"FILE BROKE");
        }
        super.onPause();
    }
}
