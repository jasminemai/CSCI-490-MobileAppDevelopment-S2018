package com.example.jasmine.gitreference_mai;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Jasmine on 3/1/2018.
 */

public class Addition extends MainActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addition);
        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText command = findViewById(R.id.commandET);
                String commandString = command.getText().toString();
                EditText example = findViewById(R.id.exampleET);
                String exampleString = example.getText().toString();
                EditText explanation = findViewById(R.id.explanationET);
                String explanationString = explanation.getText().toString();
                EditText section = findViewById(R.id.sectionET);
                String sectionString = section.getText().toString();
            }
        });
    }
}