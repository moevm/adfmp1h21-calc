package com.example.counting_trainer.firstStart

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.counting_trainer.LvlupActivity
import com.example.counting_trainer.MainActivity
import com.example.counting_trainer.R
import kotlinx.android.synthetic.main.activity_choose.*
import kotlinx.android.synthetic.main.toolbar.view.*

class ChooseActivity : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)
        prefs = getSharedPreferences("lvl", MODE_PRIVATE)
        var editor = prefs.edit()
        toolbar.tooltext.text = "Выберите ваш уровень"
        medium.setOnClickListener {
            editor.putInt("lvl", 2)
            editor.commit()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
        noob.setOnClickListener {
            editor.putInt("lvl", 1)
            editor.commit()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        supermind.setOnClickListener {
            editor.putInt("lvl", 3)
            editor.commit()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}