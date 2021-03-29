package com.example.counting_trainer

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.toolbar.view.*
import com.example.counting_trainer.helpers.TaskHelper

class ResultActivity : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        // Настройка toolbar
        to_home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //End toolbar
        prefs = getSharedPreferences("lvl", MODE_PRIVATE)
        var currentLvl = prefs.getInt("lvl",1)


        val getIntent = intent
        val points = getIntent.getIntExtra("points", 0)
        score.text = "Ваши Баллы:$points"
        val resultTest = TaskHelper.lvlUpCheck(points, currentLvl)
        if (points >= 8 ) {
            restext.text = resultTest[0].str
            toolbar.tooltext.text = resultTest[1].str
            if (currentLvl < 3) {
                var editor = prefs.edit()
                editor.clear()
                editor.putInt("lvl", currentLvl+1)
                editor.commit()
            }
        }
        else {
            restext.text = resultTest[0].str
            toolbar.tooltext.text = resultTest[1].str
        }

        to_main.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}