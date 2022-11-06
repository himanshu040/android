package com.example.permission;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv=findViewById(R.id.lv);
        String[] fruits=new String[]{
                "Apple","mango","orange"

        };
        ArrayAdapter<String> newAdapter=new ArrayAdapter<>(this,R.layout.list_of_fruit,R.id.tv,
                fruits);
        lv.setAdapter(newAdapter);
        
    }
}