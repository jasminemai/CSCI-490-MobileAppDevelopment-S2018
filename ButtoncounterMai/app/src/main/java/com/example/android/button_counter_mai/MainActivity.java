package com.example.android.button_counter_mai;

import android.content.res.Resources;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    int quantity = 0;
    TextView textView;
    String amountClicks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Resources res = getResources();
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.meow);
        if (savedInstanceState != null)
        {
            quantity = savedInstanceState.getInt("quantity");
        }

        Button incrementButton = findViewById(R.id.plus);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                quantity = quantity + 1;
                amountClicks = String.format(res.getString(R.string.counter), quantity);
                textView = findViewById(R.id.textView);
                textView.setText(amountClicks);
            }
        });

        Button decrementButton = findViewById(R.id.subtract);
        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                quantity = quantity - 1;
                amountClicks = String.format(res.getString(R.string.counter), quantity);
                textView = findViewById(R.id.textView);
                textView.setText(amountClicks);
            }
        });

        Button clearButton = findViewById(R.id.clear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                quantity = 0;
                amountClicks = String.format(res.getString(R.string.counter), quantity);
                textView = findViewById(R.id.textView);
                textView.setText(amountClicks);
            }
        });
        textView = findViewById(R.id.textView);
        amountClicks = String.format(res.getString(R.string.counter), quantity);
        textView.setText(amountClicks);

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("quantity", quantity);
    }
}