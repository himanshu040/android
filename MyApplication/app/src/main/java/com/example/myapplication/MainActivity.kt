package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {
    var PLAYER = true
    var turnCount = 0
    var boardStatus = Array(3){IntArray(3)}
    lateinit var board : Array<Array<Button>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        board= arrayOf(arrayOf(b1,b2,b3), arrayOf(b4,b5,b6), arrayOf(b7,b8,b9))
        initializeboardstatus()
       for(i in board)
       {
           for(barton in i)
               barton.setOnClickListener(this)
       }

     reset.setOnClickListener{
              initializeboardstatus()
         turnCount=0
     }
    }

    private fun initializeboardstatus() {
        PLAYER=true
        for (i in 0..2)
            for (j in 0..2)
            {
                boardStatus[i][j]=-1
                board[i][j].isEnabled=true
                board[i][j].text=""
            }
        updated("Player X turn")
    }

    override fun onClick(view: View?) {
        if (view != null) {
            when(view.id) {
                   R.id.b1->{
                       update(row=0,column=0,player= PLAYER)

                   }
                R.id.b2->{
                    update(row=0,column = 1,player= PLAYER)
                }
                R.id.b3-> {
                    update(row=0,column=2,player= PLAYER)
                }
                R.id.b4->{
                    update(row=1,column=0,player= PLAYER)
                }
                R.id.b5->{
                    update(row=1,column=1,player= PLAYER)
                }
                R.id.b6->{
                    update(row=1,column=2,player= PLAYER)
                }
                R.id.b7->{
                    update(row=2,column=0,player= PLAYER)
            }
                R.id.b8->{
                    update(row=2,column=1,player= PLAYER)
                }
                R.id.b9->{
                    update(row=2,column=2,player= PLAYER)

                }
            }
        }
        turnCount++
     PLAYER=!PLAYER
        if(PLAYER)
            updated("Player X turn")
        else
            updated("player 0 turn")
        if(turnCount==9)
            updated("DRAW")
        checkwinner()
    }

    private fun checkwinner() {
        for(i in 0..2)
            {
                if(boardStatus[i][0]==boardStatus[i][1]&&boardStatus[i][0]==boardStatus[i][2])
                {
                    if(boardStatus[i][0]==1)
                        updated("Player X win")
                    else if(boardStatus[i][0]==0)
                        updated("Player 0 win")
                    break
                }
                if(boardStatus[0][i]==boardStatus[1][i]&&boardStatus[0][i]==boardStatus[2][i])
                {
                    if(boardStatus[0][i]==1)
                        updated("Player X win")
                    else if(boardStatus[0][i]==0)
                        updated("Player 0 win")
                    break
                }


            }
        if(boardStatus[0][0]==boardStatus[1][1]&&boardStatus[0][0]==boardStatus[2][2])
        {
            if(boardStatus[0][0]==1)
                updated("Player X win")
            else if(boardStatus[0][0]==0)
                updated("Player 0 win")
        }
        if(boardStatus[0][2]==boardStatus[1][1]&&boardStatus[0][2]==boardStatus[2][0])
        {
            if(boardStatus[0][2]==1)
                updated("Player X win")
            else if(boardStatus[0][2]==0)
                updated("Player 0 win")
        }

    }

    private fun updated(s: String) {
        if(s.contains("win"))
            disableButton()
        result.text=s
        if(s.contains("win"))
            disableButton()

    }
    private fun disableButton()
    {
        for(i in board)
        {
            for(button in i)
                button.isEnabled=false
        }

    }

    private fun update(row: Int, column: Int, player: Boolean) {
        val text:String=if(player) "X" else "0"
        val value=if(player) 1 else 0
        board[row][column].apply {
            isEnabled=false
            setText(text)
        }
        boardStatus[row][column]=value
    }
}