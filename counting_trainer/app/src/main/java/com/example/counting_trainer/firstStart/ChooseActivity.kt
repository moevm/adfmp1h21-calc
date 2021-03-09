package com.example.counting_trainer.firstStart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.counting_trainer.LvlupActivity
import com.example.counting_trainer.MainActivity
import com.example.counting_trainer.R
import kotlinx.android.synthetic.main.activity_choose.*
import kotlinx.android.synthetic.main.toolbar.view.*

class ChooseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)
        toolbar.tooltext.text = "Выберите ваш уровень"
        medium.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        noob.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        supermind.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}