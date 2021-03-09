package com.example.counting_trainer.firstStart

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.counting_trainer.MainActivity
import com.example.counting_trainer.R
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.toolbar.view.*

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
                restext.text = "Ваш уровень: Сверхразум"
                editor.putInt("lvl", 3)
                editor.commit()
            }
            points > 6 -> {
                restext.text = "Ваш уровень: Средний"
                editor.putInt("lvl", 2)
                editor.commit()
            }
            points >= 0 -> {
                restext.text = "Ваш уровень: Начинающий"
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