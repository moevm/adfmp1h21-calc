package com.example.counting_trainer

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.counting_trainer.firstStart.WelcomeActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        prefs = getSharedPreferences("lvl", MODE_PRIVATE)
        if (prefs.getInt("lvl", 0 ) == 0 ) {
            val intent = Intent(this,WelcomeActivity::class.java)
            startActivity(intent)
        }
        var lvl:Int = prefs.getInt("lvl", 1)
        toolbar.tooltext.text = "Привет, ваш уровень - " + lvl.toString()
        statistics.setOnClickListener {
            val intent = Intent(this,StatisticsMenu::class.java)
            startActivity(intent)
        }
        take_knowledge.setOnClickListener {
            val intent = Intent(this,TheoryActivity::class.java)
            startActivity(intent)
        }
        training.setOnClickListener {
            val intent = Intent(this,TrainingActivity::class.java)
            startActivity(intent)
        }
        lvlup.setOnClickListener {
            val intent = Intent(this,LvlupActivity::class.java)
            intent.putExtra("lvl", lvl)
            startActivity(intent)
        }








    }
}