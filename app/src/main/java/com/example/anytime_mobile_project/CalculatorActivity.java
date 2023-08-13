package com.example.anytime_mobile_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class CalculatorActivity extends AppCompatActivity {

    public static ArrayList<String> calculations = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Button addBtn = (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText firstNumText = (EditText) findViewById(R.id.firstNumberEditText);
                EditText secondNumText = (EditText) findViewById(R.id.secondNumberEditText);
                TextView resultText = (TextView) findViewById(R.id.resultTextView);

                int num1 = Integer.parseInt(firstNumText.getText().toString());
                int num2 = Integer.parseInt(secondNumText.getText().toString());
                int result = num1 + num2;
                String resultString = num1 + " + " + num2 + " = " + result;
                resultText.setText(resultString);
                calculations.add(resultString);
            }
        });

        Button subBtn = (Button) findViewById(R.id.subtractionBtn);
        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText firstNumText = (EditText) findViewById(R.id.firstNumberEditText);
                EditText secondNumText = (EditText) findViewById(R.id.secondNumberEditText);
                TextView resultText = (TextView) findViewById(R.id.resultTextView);

                int num1 = Integer.parseInt(firstNumText.getText().toString());
                int num2 = Integer.parseInt(secondNumText.getText().toString());
                int result = num1 - num2;
                String resultString = num1 + " - " + num2 + " = " + result;
                resultText.setText(resultString);
                calculations.add(resultString);
            }
        });

        Button multBtn = (Button) findViewById(R.id.multiplicationBtn);
        multBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText firstNumText = (EditText) findViewById(R.id.firstNumberEditText);
                EditText secondNumText = (EditText) findViewById(R.id.secondNumberEditText);
                TextView resultText = (TextView) findViewById(R.id.resultTextView);

                int num1 = Integer.parseInt(firstNumText.getText().toString());
                int num2 = Integer.parseInt(secondNumText.getText().toString());
                int result = num1 * num2;
                String resultString = num1 + " x " + num2 + " = " + result;
                resultText.setText(resultString);
                calculations.add(resultString);
            }
        });

        Button historyBtn = (Button) findViewById(R.id.historyButton);
        historyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //System.out.println(calculations);
                Intent startIntent = new Intent(getApplicationContext(), HistoryActivity.class);
                startIntent.putStringArrayListExtra("calculationsKey", calculations);
                startActivity(startIntent);
            }
        });
    }
}