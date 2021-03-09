package com.example.counting_trainer.firstStart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.counting_trainer.MainActivity
import com.example.counting_trainer.R
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.toolbar.view.*

class FirstResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_result)
        toolbar.tooltext.text = "Ваш уровень определен"
        val getIntent = intent
        val points = getIntent.getIntExtra("points", 0)
        score.text = "Ваши Баллы:$points"
        when {
            points > 9 -> {
                restext.text = "Ваш уровень: Сверхразум"
            }
            points > 6 -> {
                restext.text = "Ваш уровень: Средний"
            }
            points >= 0 -> {
                restext.text = "Ваш уровень: Начинающий"
            }
        }

        to_main.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}