package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class HobbiesAdapter(val context:Context,val hobbies:List<Mode>) :RecyclerView.Adapter<HobbiesAdapter.myViewHolder>(){
    inner class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
     fun setdata(hobby:Mode?,position: Int)
     {
         itemView.txvTitle.text= hobby!!.title
     }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
       return myViewHolder(view)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
      val hobby=hobbies[position]
        holder.setdata(hobby,position)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

}