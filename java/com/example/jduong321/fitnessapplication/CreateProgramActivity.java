package com.example.jduong321.fitnessapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Jacky on 6/16/2017.
 */

public class CreateProgramActivity  extends AppCompatActivity {

    private Button createButton;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createprogram);

        editText = (EditText) findViewById(R.id.textView);
        createButton = (Button) findViewById(R.id.create);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CreateProgramActivity.this,ProgramActivity.class);
                String s = editText.getText().toString();
                i.putExtra("name",s);
                startActivity(i);
            }
        });
    }


}
