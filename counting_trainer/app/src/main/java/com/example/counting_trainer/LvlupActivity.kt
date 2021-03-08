package com.example.counting_trainer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lvlup.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.toolbar.view.*

class LvlupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lvlup)
        toolbar.tooltext.text = "Повышение уровня"
        answer.setOnClickListener {
            val intent = Intent(this,ResultActivity::class.java)
            startActivity(intent)
        }
    }

}