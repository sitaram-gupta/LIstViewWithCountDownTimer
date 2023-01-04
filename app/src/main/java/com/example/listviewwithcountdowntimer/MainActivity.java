package com.example.listviewwithcountdowntimer;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static CustomAdapter adapter;
    ListView listView;
    ArrayList<DataModel> dataModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);

        dataModels.add(new DataModel("one"));
        dataModels.add(new DataModel("two"));
        dataModels.add(new DataModel("three"));
        dataModels.add(new DataModel("four"));
        dataModels.add(new DataModel("five"));
        dataModels.add(new DataModel("six"));
        dataModels.add(new DataModel("seven"));
        dataModels.add(new DataModel("eight"));
        dataModels.add(new DataModel("nine"));
        dataModels.add(new DataModel("ten"));

        adapter = new CustomAdapter(dataModels, getApplicationContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DataModel dataModel = dataModels.get(position);

                Snackbar.make(view, dataModel.nothing, Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
            }
        });
    }
}