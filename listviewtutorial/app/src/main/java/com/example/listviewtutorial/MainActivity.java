package com.example.listviewtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    String[] names=new String[]{"Aman","Himanshu","Vishal" };
    ListView lvnames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvnames=findViewById(R.id.lvNames);
        ArrayAdapter<String> newAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,android.R.id.text1,
                                                                      names);
        lvnames.setAdapter(newAdapter);

    }
}