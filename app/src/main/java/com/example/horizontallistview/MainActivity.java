package com.example.horizontallistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HorizontalListView listView = findViewById(R.id.listView);
        ListAdapter listAdapter = new ListAdapter(getApplicationContext(), new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.title_bar))));
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            listAdapter.setSelectedPosition(position);
            listAdapter.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(), listAdapter.arrayList.get(position), Toast.LENGTH_SHORT);
        });

    }

}