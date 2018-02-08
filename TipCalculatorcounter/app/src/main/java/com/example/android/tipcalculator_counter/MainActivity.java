package com.example.android.tipcalculator_counter;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Double tip;
    private Double total;
    private int partySize = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tipTotal = findViewById(R.id.tipTotal);
        final TextView totalBill = findViewById(R.id.totalText);
        final Button calculate = findViewById(R.id.calculate);
        final EditText otherText = findViewById(R.id.otherText);
        calculate.setEnabled(false);
        otherText.setEnabled(false);

        final EditText bill = findViewById(R.id.billAmount);
        final EditText numParty = findViewById(R.id.numParty);
        View.OnKeyListener mKeyListener = new View.OnKeyListener() {

            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                switch (view.getId()) {
                    case R.id.billAmount:
                        if (bill.getText().length() > 0 && Double.parseDouble(bill.getText().toString()) > 1.00) {
                            calculate.setEnabled(true);
                            break;
                        }
                        else
                        {
                            showErrorAlert("Too low of bill!", R.id.billAmount);
                        }
                    case R.id.numParty:
                        if (numParty.getText().length() > 0)
                        {
                            partySize = Integer.parseInt(numParty.getText().toString());
                            break;
                        }
                    case R.id.radioOther:
                    {
                        otherText.setEnabled(true);
                    }

                }
                return false;
            }

        };
        bill.setOnKeyListener(mKeyListener);
        numParty.setOnKeyListener(mKeyListener);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText billId = findViewById(R.id.billAmount);
                Double bill = Double.parseDouble(billId.getText().toString());
                RadioButton opt15 = findViewById(R.id.radio15);
                RadioButton opt18 = findViewById(R.id.radio18);
                RadioButton opt20 = findViewById(R.id.radio20);
                RadioButton optOther = findViewById(R.id.radioOther);
                final Resources res = getResources();

                if (opt15.isChecked()) {
                    tip = bill * 0.15;
                    total = bill + tip;
                    if (partySize == 1) {
                        tipTotal.setText(String.format(res.getString(R.string.dollarSign), tip));
                        totalBill.setText(String.format(res.getString(R.string.dollarSign2), total));

                    }
                    else
                    {

                        total = total / partySize ;
                        tipTotal.setText(String.format(res.getString(R.string.dollarSign), tip));
                        totalBill.setText(String.format(res.getString(R.string.dollarSign2), total));

                    }
                } else if (opt18.isChecked()) {
                    tip = bill * 0.18;
                    total = bill + tip;
                    if (partySize == 1) {
                        tipTotal.setText(String.format(res.getString(R.string.dollarSign), tip));
                        totalBill.setText(String.format(res.getString(R.string.dollarSign2), total));

                    }
                    else
                    {

                        total = total / partySize ;
                        tipTotal.setText(String.format(res.getString(R.string.dollarSign), tip));
                        totalBill.setText(String.format(res.getString(R.string.dollarSign2), total));

                    }
                } else if (opt20.isChecked()) {
                    tip = bill * 0.20;
                    total = bill + tip;
                    if (partySize == 1) {
                        tipTotal.setText(String.format(res.getString(R.string.dollarSign), tip));
                        totalBill.setText(String.format(res.getString(R.string.dollarSign2), total));

                    }
                    else
                    {

                        total = total / partySize ;
                        tipTotal.setText(String.format(res.getString(R.string.dollarSign), tip));
                        totalBill.setText(String.format(res.getString(R.string.dollarSign2), total));

                    }
                }
                else if (optOther.isChecked())
                {
                    tip = bill * (Double.parseDouble(otherText.getText().toString())/100);
                    total = bill + tip;
                    if (partySize == 1) {
                        tipTotal.setText(String.format(res.getString(R.string.dollarSign), tip));
                        totalBill.setText(String.format(res.getString(R.string.dollarSign2), total));

                    }
                    else
                    {

                        total = total / partySize ;
                        tipTotal.setText(String.format(res.getString(R.string.dollarSign), tip));
                        totalBill.setText(String.format(res.getString(R.string.dollarSign2), total));

                    }
                }

            }
        });


    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putDouble("total", total);
        savedInstanceState.putDouble("tip", tip);
    }

    private void showErrorAlert(String errorMessage, final int fieldId) {
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(errorMessage)
                .setNeutralButton("Close",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                findViewById(fieldId).requestFocus();
                            }
                        }).show();
    }
}
