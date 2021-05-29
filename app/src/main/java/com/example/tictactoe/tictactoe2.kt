package com.example.tictactoe

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_tictactoe2.*
import java.util.*

class tictactoe2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tictactoe2)
    }

    fun btClick(view: View){
        val chosen = view as Button
        var cellID = 0
        when(chosen.id){
            R.id.b1 -> cellID = 1
            R.id.b2 -> cellID = 2
            R.id.b3 -> cellID = 3
            R.id.b4 -> cellID = 4
            R.id.b5 -> cellID = 5
            R.id.b6 -> cellID = 6
            R.id.b7 -> cellID = 7
            R.id.b8 -> cellID = 8
            R.id.b9 -> cellID = 9

        }

        playGame(cellID,chosen)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    private fun playGame(cellID: Int, chosen: Button) {
        if(activePlayer==1){
            chosen.setBackgroundColor(Color.parseColor("#8B0000"))
            chosen.text = "X"
            chosen.setTextColor(Color.WHITE)
            player1.add(cellID)
            activePlayer = 2
            botPlay()
        }else{
            chosen.setBackgroundColor(Color.parseColor("#000080"))
            chosen.text = "O"
            chosen.setTextColor(Color.YELLOW)
            player2.add(cellID)
            activePlayer = 1
        }
        chosen.isEnabled = false;
    }
    private fun botPlay() {
        val emptyCells=ArrayList<Int>()
        for (cellID in 1..9){
            if(!(player1.contains(cellID) || player2.contains(cellID))){
                emptyCells.add(cellID)
            }
        }

        val r = Random()
        val randIndex = r.nextInt(emptyCells.size-0)+0
        val cellID = emptyCells[randIndex]

        var chosen:Button
        when(cellID){
            1-> chosen=b1
            2-> chosen=b2
            3-> chosen=b3
            4-> chosen=b4
            5-> chosen=b5
            6-> chosen=b6
            7-> chosen=b7
            8-> chosen=b8
            9-> chosen=b9
            else -> chosen = b1

        }


        playGame(cellID,chosen)

    }
}

