package com.example.recyclerview

import kotlin.random.Random

data class Fruits (
     val name:String,
     val origin:String,
     val quantity:Int
 )
 {
     companion object{
         val fruit_name=arrayOf("MAngo","kiwi","Strawberry","Pineapple","Guava","Banana")
         val Origins= arrayOf("Lucknow","Patna","Nagpur","Srinagar","Mysore")
         fun genRandomFruits(n:Int):ArrayList<Fruits>
         {
             val fruitArray=ArrayList<Fruits>(n)
             for (i in 1..n)
             {

                fruitArray.add(Fruits
                    (
                    fruit_name[Random.nextInt(6)],
                    Origins[Random.nextInt(5)],
                    Random.nextInt(10)*100
                                                    )
                )

             }
             return fruitArray
         }
     }
 }


