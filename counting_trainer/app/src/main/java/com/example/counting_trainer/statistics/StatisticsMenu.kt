package com.example.counting_trainer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_statistics_menu.*
import kotlinx.android.synthetic.main.toolbar.view.*

class StatisticsMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics_menu)
        toolbar.tooltext.text = "Статистика"
        full_st.setOnClickListener {
            val full_intent = Intent(this, FullStatistics::class.java)
            startActivity(full_intent)
        }
        tr_st.setOnClickListener {
            val tr_intent = Intent(this, TrainingStatistics::class.java)
            startActivity(tr_intent)
        }
    }
}