package com.example.counting_trainer.firstStart

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.counting_trainer.MainActivity
import com.example.counting_trainer.R
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.toolbar.view.*
import com.example.counting_trainer.helpers.ProcessedLvlEnum

class FirstResult : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_result)
        prefs = getSharedPreferences("lvl", MODE_PRIVATE)
        var editor = prefs.edit()

        toolbar.tooltext.text = "Ваш уровень определен"
        val getIntent = intent
        val points = getIntent.getIntExtra("points", 0)
        score.text = "Ваши Баллы:$points"
        when {
            points > 9 -> {
                restext.text = ProcessedLvlEnum.SUPERMIND_LVL.str
                editor.putInt("lvl", 3)
                editor.commit()
            }
            points > 6 -> {
                restext.text = ProcessedLvlEnum.MEDIUM_LVL.str
                editor.putInt("lvl", 2)
                editor.commit()
            }
            points >= 0 -> {
                restext.text = ProcessedLvlEnum.NOOB_LVL.str
                editor.putInt("lvl", 1)
                editor.commit()
            }
        }

        to_main.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}