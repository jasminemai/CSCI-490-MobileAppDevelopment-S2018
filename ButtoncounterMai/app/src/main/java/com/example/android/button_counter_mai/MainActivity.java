package com.example.android.button_counter_mai;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();
        String amountClicks = String.format(res.getString(R.string.counter), quantity);
        TextView textView = findViewById(R.id.textView);
        textView.setText(amountClicks);
        Button clearButton = findViewById(R.id.button);
        Button incrementButton = findViewById(R.id.button2);
        Button decrementButton = findViewById(R.id.button3);
        clearButton.setOnClickListener(onClick);
        incrementButton.setOnClickListener(onClick);
        decrementButton.setOnClickListener(onClick);
    }
    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Resources res = getResources();
            switch (view.getId()) {
                case R.id.button:
                    quantity = 0;
                    String amountClicks = String.format(res.getString(R.string.counter), quantity);
                    TextView textView = findViewById(R.id.textView);
                    textView.setText(amountClicks);
                    break;
                case R.id.button2:
                    quantity = quantity + 1;
                    amountClicks = String.format(res.getString(R.string.counter), quantity);
                    textView = findViewById(R.id.textView);
                    textView.setText(amountClicks);
                    break;
                case R.id.button3:
                    quantity = quantity - 1;
                    amountClicks = String.format(res.getString(R.string.counter), quantity);
                    textView = findViewById(R.id.textView);
                    textView.setText(amountClicks);
                    break;
            }

        }
    };
}