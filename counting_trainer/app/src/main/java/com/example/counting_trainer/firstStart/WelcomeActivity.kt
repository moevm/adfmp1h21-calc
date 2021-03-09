package com.example.counting_trainer.firstStart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.counting_trainer.LvlupActivity
import com.example.counting_trainer.R
import kotlinx.android.synthetic.main.activity_welcome.*
import kotlinx.android.synthetic.main.toolbar.view.*

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        toolbar.tooltext.text = "Добро пожаловать"
        choose.setOnClickListener {
            val intent = Intent(this, ChooseActivity::class.java)
            startActivity(intent)
        }
        test.setOnClickListener {
            val intent = Intent(this, LvlupActivity::class.java)
            intent.putExtra("lvl", 2)
            intent.putExtra("first start", true)
            startActivity(intent)
        }
    }
}