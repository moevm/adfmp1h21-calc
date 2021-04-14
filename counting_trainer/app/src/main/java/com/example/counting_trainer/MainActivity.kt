package com.example.counting_trainer

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.counting_trainer.firstStart.WelcomeActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.view.*
import kotlinx.android.synthetic.main.toolbar.*
import com.example.counting_trainer.helpers.CurrentLvlEnum

class MainActivity : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //End toolbar
        prefs = getSharedPreferences("lvl", MODE_PRIVATE)
        if (prefs.getInt("lvl", 0 ) == 0 ) {
            val intent = Intent(this,WelcomeActivity::class.java)
            startActivity(intent)
        }
        var lvl:Int = prefs.getInt("lvl", 1)
        when (lvl) {
            1-> toolbar.tooltext.text = CurrentLvlEnum.NOOB_LVL.str
            2-> toolbar.tooltext.text = CurrentLvlEnum.MEDIUM_LVL.str
            3-> toolbar.tooltext.text = CurrentLvlEnum.SUPERMIND_LVL.str
        }
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
            intent.putExtra("lvl", lvl)
            startActivity(intent)
        }
        lvlup.setOnClickListener {
            val intent = Intent(this,LvlupActivity::class.java)
            intent.putExtra("lvl", lvl)
            startActivity(intent)
        }
    }
}