package com.example.tictactoe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val b1 = findViewById<Button>(R.id.play)
        val b2 = findViewById<Button>(R.id.quit)

        b1.setOnClickListener {
            val nextpage = Intent(this, tictactoe2::class.java)
            startActivity(nextpage)
        } //Start Game

        b2.setOnClickListener{
            val quit : AlertDialog = AlertDialog.Builder(this).create()
            quit.setTitle("Leave")
            quit.setMessage("Do you want to leave player??")
            quit.setButton(AlertDialog.BUTTON_POSITIVE,"Yes"){
                dialog, which -> finish()
                dialog.dismiss()
            } //Quit Game Dialog

            quit.setButton(AlertDialog.BUTTON_NEGATIVE,"No"){
                dialog, which ->
                dialog.dismiss()
            } //Stay in Game
            quit.show() //Show dialog
        }
    }
}
