package com.example.counting_trainer

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.toolbar.view.*

class ResultActivity : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        prefs = getSharedPreferences("lvl", MODE_PRIVATE)
        val success:String = "Уровень повышен!"
        val fail:String = "Тренируйтесь усерднее!"
        var currentLvl = prefs.getInt("lvl",1)

        val getIntent = intent
        val points = getIntent.getIntExtra("points", 0)
        score.text = "Ваши Баллы:$points"
        if (points >= 8 ){
            restext.text = "Поздравляем, тест пройден!\n Ваш уровень повышен"
            toolbar.tooltext.text = success
            if (currentLvl <3){
                var editor = prefs.edit()
                editor.putInt("lvl", currentLvl+1)
                editor.commit()
            }
        }
        else{
            restext.text = "Вы не набрали достаточного количества баллов для повышения.\n Тренируйтесь усердней"
            toolbar.tooltext.text = fail
        }

        to_main.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}