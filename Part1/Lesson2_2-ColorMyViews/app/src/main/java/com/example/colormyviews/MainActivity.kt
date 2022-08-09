package com.example.colormyviews

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val boxOne = findViewById<TextView>(R.id.box_one_text)
        val boxTwo = findViewById<TextView>(R.id.box_two_text)
        val boxThree = findViewById<TextView>(R.id.box_three_text)
        val boxFour = findViewById<TextView>(R.id.box_four_text)
        val boxFive = findViewById<TextView>(R.id.box_five_text)

        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraint_layout)

        val redButton = findViewById<Button>(R.id.red_button)
        val greenButton = findViewById<Button>(R.id.green_button)
        val yellowButton = findViewById<Button>(R.id.yellow_button)

        val clickableViews: List<View> =
            listOf(boxOne, boxTwo, boxThree, boxFour, boxFive, constraintLayout, redButton, greenButton, yellowButton)
        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it, boxThree, boxFour, boxFive) }
        }
    }

    private fun makeColored(view: View, boxThree:TextView, boxFour:TextView, boxFive:TextView) {
        when (view.id) {

            // Boxes using Color class colors for background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            // Boxes using custom colors for background
            R.id.red_button -> boxThree.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> boxFour.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> boxFive.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}