package com.example.counting_trainer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_statistics_menu.*
import kotlinx.android.synthetic.main.activity_statistics_menu.toolbar
import kotlinx.android.synthetic.main.activity_training_statistics.*
import kotlinx.android.synthetic.main.toolbar.view.*

class TrainingStatistics : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_training_statistics)
        toolbar.tooltext.text = "Статистика тренировок"
        to_main.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}