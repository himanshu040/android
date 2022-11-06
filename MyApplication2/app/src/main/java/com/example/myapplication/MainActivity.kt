package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lv.adapter=ArrayAdapter(this,R.layout.list,R.id.tv, arrayOf("Apple","mango","orange"))
         lv.setOnItemClickListener { parent, view, i, l ->
             Toast.makeText(this, "jhonny eat $i ${view.tv.text}", Toast.LENGTH_SHORT).show()
         }

    }
}