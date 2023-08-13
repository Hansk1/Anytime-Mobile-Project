package com.example.anytime_mobile_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    ArrayList<String> calculations = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        ListView calcHistoryListView = (ListView) findViewById(R.id.calculationsHistoryListView);

        if (getIntent().hasExtra("calculationsKey")) {
            calculations = getIntent().getStringArrayListExtra("calculationsKey");
        } else {
            System.out.println("No calculations");
        }

        adapter = new ArrayAdapter<String>(this, R.layout.calculations_history_listview_detail, calculations);
        calcHistoryListView.setAdapter(adapter);

        Button clearHistoryBtn = (Button) findViewById(R.id.clearHistoryBtn);
        clearHistoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculations.clear();
                CalculatorActivity.calculations.clear();
                adapter.notifyDataSetChanged();
            }
        });
    }
}