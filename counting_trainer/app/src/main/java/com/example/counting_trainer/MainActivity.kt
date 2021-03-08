package com.example.counting_trainer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.view.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var lvl: String = " Начинающий!"
        toolbar.tooltext.text = "Привет, ваш уровень - " + lvl
        statistics.setOnClickListener {
            val intent = Intent(this,StatisticsMenu::class.java)
            startActivity(intent)
        }








    }
}