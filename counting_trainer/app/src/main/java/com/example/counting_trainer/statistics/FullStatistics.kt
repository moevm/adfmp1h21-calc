package com.example.counting_trainer

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.LimitLine
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.MPPointF
import com.github.mikephil.charting.utils.Utils
import kotlinx.android.synthetic.main.activity_full_statistics.*
import kotlinx.android.synthetic.main.activity_statistics_menu.toolbar
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.toolbar.view.*


class FullStatistics : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_statistics)
        // Настройка toolbar
        toolbar.tooltext.text = "Общая статистика"
        to_home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //End toolbar

        Utils.init(this)
        val actions = arrayOf("sum", "diff", "mult", "div")
        val descriptions = arrayOf("Сложение", "Вычитание", "Умножение", "Деление")

        for(i in 0..3){

            prefs = getSharedPreferences(actions[i] + "_stat", MODE_PRIVATE)
            val actCorrect:Int = prefs.getInt("correct", 0)
            val actFail:Int = prefs.getInt("fail", 0)
            val actPass:Int = prefs.getInt("pass", 0)
            val actAnswers:Int = prefs.getInt("answers", 0)

            val text = TextView(this)
            text.setTextColor(ContextCompat.getColor(this, R.color.black))
            text.textSize = 14f
            text.gravity = Gravity.CENTER_HORIZONTAL
            if(actAnswers != 0){
                text.text = "\n\n" + descriptions[i] + ": "
                scrollView.addView(text)

                val correct = ArrayList<BarEntry>()
                val fail = ArrayList<BarEntry>()
                val pass = ArrayList<BarEntry>()

                correct.add(BarEntry(0f, actCorrect.toFloat()))
                val correctDataSet = BarDataSet(correct, "Правильно")
                correctDataSet.color = ContextCompat.getColor(this, R.color.green)

                fail.add(BarEntry(1f, actFail.toFloat()))
                val failDataSet = BarDataSet(fail, "Неправильно")
                failDataSet.color = ContextCompat.getColor(this, R.color.red)

                pass.add(BarEntry(2f, actPass.toFloat()))
                val passDataSet = BarDataSet(pass, "Пропущено")
                passDataSet.color = ContextCompat.getColor(this, R.color.grey)

                val line = LimitLine(actAnswers.toFloat(), "Всего заданий")
                line.lineWidth = 2f
                line.labelPosition = LimitLine.LimitLabelPosition.RIGHT_TOP

                val chart = BarChart(this)
                scrollView.addView(chart)

                val data = BarData(correctDataSet, failDataSet, passDataSet)
                data.barWidth = 0.9f
                chart.data = data
                chart.axisLeft.addLimitLine(line)
                chart.axisLeft.axisMinimum = 0f
                chart.axisRight.axisMinimum = 0f
                chart.description.text = ""

                var max:Int = actAnswers
                if(max < actFail) max = actFail
                max++
                chart.axisLeft.axisMaximum = max.toFloat()
                chart.axisRight.axisMaximum = max.toFloat()
                if(max < 10) {
                    chart.layoutParams.height = 100*max
                    chart.axisLeft.granularity = 1f
                    chart.axisRight.granularity = 1f
                }
                else {
                    max /= 5
                    chart.layoutParams.height = 1000
                    chart.axisLeft.granularity = max.toFloat()
                    chart.axisRight.granularity = max.toFloat()
                }
                chart.xAxis.setDrawLabels(false)
            }
            else{
                text.text = "\n\nЗа время использования программы ещё не решался пример с действием \"" + descriptions[i] + "\""
                scrollView.addView(text)
            }

        }
    }
}