package com.example.counting_trainer

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Typeface
import android.os.Bundle
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_statistics_menu.toolbar
import kotlinx.android.synthetic.main.activity_training_statistics.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.toolbar.view.*


class TrainingStatistics : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_training_statistics)
        // Настройка toolbar
        toolbar.tooltext.text = "Статистика тренировок"
        to_home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //End toolbar

        val titleRow = TableRow(this)

        tableLayout.isStretchAllColumns = true;
        tableLayout.isShrinkAllColumns = true;
        val indexTitle = TextView(this)
        indexTitle.text = "№"
        indexTitle.typeface = Typeface.DEFAULT_BOLD

        val correctTitle = TextView(this)
        correctTitle.text = "Правильно"
        correctTitle.typeface = Typeface.DEFAULT_BOLD

        val failTitle = TextView(this)
        failTitle.text = "Неправильно"
        failTitle.typeface = Typeface.DEFAULT_BOLD

        val passTitle = TextView(this)
        passTitle.text = "Пропущено"
        passTitle.typeface = Typeface.DEFAULT_BOLD

        val answersTitle = TextView(this)
        answersTitle.text = "Всего"
        answersTitle.typeface = Typeface.DEFAULT_BOLD

        titleRow.addView(indexTitle)
        titleRow.addView(correctTitle)
        titleRow.addView(failTitle)
        titleRow.addView(passTitle)
        titleRow.addView(answersTitle)

        tableLayout.addView(titleRow)

        prefs = getSharedPreferences( "train_stat", MODE_PRIVATE)
        val currentStat = prefs.getStringSet("train_stat", null)
        var counter = 0
        if(currentStat != null){
            currentStat.forEach{
                counter++
                val tableRow = TableRow(this)

                val indexView = TextView(this)
                indexView.text = counter.toString()

                val correctView = TextView(this)
                correctView.text = it.substringBefore('|')

                val failView = TextView(this)
                failView.text = it.substringAfter('|').substringBefore('|')

                val passView = TextView(this)
                passView.text = it.substringBeforeLast('|').substringAfterLast('|')

                val answerView = TextView(this)
                answerView.text = it.substringAfterLast('|')

                tableRow.addView(indexView)
                tableRow.addView(correctView)
                tableRow.addView(failView)
                tableRow.addView(passView)
                tableRow.addView(answerView)

                tableLayout.addView(tableRow)
            }
        }
    }
}