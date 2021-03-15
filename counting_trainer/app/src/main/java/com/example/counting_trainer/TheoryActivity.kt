package com.example.counting_trainer

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.counting_trainer.firstStart.WelcomeActivity
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.activity_theory.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.toolbar.view.*

class TheoryActivity : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theory)

        // Настройка toolbar
        toolbar.tooltext.text = "Теория"
        to_home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        prefs = getSharedPreferences("lvl", MODE_PRIVATE)
        if (prefs.getInt("lvl", 0 ) == 0 ) {
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
        }
        var lvl:Int = prefs.getInt("lvl", 1)

        webViewTheory.loadUrl("file:///android_asset/web/noobTheory.html")
        //End toolbar
//        to_main.setOnClickListener {
//            val intent = Intent(this,MainActivity::class.java)
//            startActivity(intent)
//        }
//        next.setOnClickListener {  }

    }
}