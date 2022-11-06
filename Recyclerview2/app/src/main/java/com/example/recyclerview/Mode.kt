package com.example.recyclerview

import kotlin.random.Random

data class Mode(var title:String)
object Supplier{
    val hobbies_title=arrayOf("Swimming","Reading","Running","Gaming","Programming")
    fun genRandomHobbie(n:Int):ArrayList<Mode>
    {
        val fruitArray=ArrayList<Mode>(n)
        for (i in 1..n)
        {

            fruitArray.add(Mode
                (
                hobbies_title[Random.nextInt(5)],

            )
            )

        }
        return fruitArray
    }

}