package com.example.counting_trainer

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.counting_trainer.helpers.TaskHelper
import kotlinx.android.synthetic.main.activity_lvlup.answer
import kotlinx.android.synthetic.main.activity_lvlup.task
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.activity_training.*
import kotlinx.android.synthetic.main.keybord.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.toolbar.view.*
import java.lang.Math.abs

class TrainingActivity : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences
    private var points:Int = 0
    private var fails:Int = 0
    private var passed:Int = 0
    private var actPoints = arrayOf(0, 0, 0, 0)
    private var actFails = arrayOf(0, 0, 0, 0)
    private var actPassed = arrayOf(0, 0, 0, 0)
    private var currentAct:Int = 0
    private var isPassed:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_training)

        // Настройка toolbar
        toolbar.tooltext.text = "Тренировка!"
        to_home.setOnClickListener {
            if(points + fails + passed != 0) {
                saveTrainStat()
                saveActionStat()
            }
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //End toolbar

        val intentWithLvl = getIntent()
        val lvl = intentWithLvl.getIntExtra("lvl", 1)
        var arrayTask = generateTaskText(lvl)

        nextbut.setOnClickListener {
                if (arrayTask[3].toString() == answer.text) {
                    points++
                    actPoints[currentAct]++
                    isPassed = false
                    answer.setBackgroundColor(Color.GREEN)
                    hint.text = ""
                    answer.text = ""
                    arrayTask = generateTaskText(lvl)
                }
                else {
                    answer.setBackgroundColor(Color.RED)
                    fails++
                    actFails[currentAct]++
                    isPassed = true
                    val checkedAnswer = TaskHelper.checkSizeError(arrayTask, answer.text.toString())
                    if (!checkedAnswer.isEmpty()){
                        hint.text = checkedAnswer
                    }
                }
        }

        pass.setOnClickListener {
            passed++
            actPassed[currentAct]++
            isPassed = false
            answer.setBackgroundColor(Color.BLUE)
            answer.text = ""
            arrayTask = generateTaskText(lvl)
          }

        clear_but.setOnClickListener {
            var str:String = answer.text.toString()
            if (str.length != 0){
                str = str.substring(0, str.length - 1)
                answer.text = str
            }
        }

        clear_but.setOnLongClickListener{
            answer.text = ""
            true
        }

        to_main.setOnClickListener {
            if(points + fails + passed != 0) {
                saveTrainStat()
                saveActionStat()
            }
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun digit(view: View){
        val text = (view as Button).text
        if (answer.text.length<6) answer.text = answer.text.toString() + text

    }

    private fun saveTrainStat(){
        // Сохранение статистики тренировки
        prefs = getSharedPreferences("train_stat", Context.MODE_PRIVATE)
        var currentStat = prefs.getStringSet("train_stat", null)
        if(isPassed) passed++
        if (currentStat != null) {
            currentStat.add("$points|$fails|$passed|" + (points + passed).toString())
        }
        else {
            currentStat = setOf("$points|$fails|$passed|" + (points + passed).toString())
        }
        val editor = prefs.edit()
        editor.clear()
        editor.putStringSet("train_stat", currentStat)
        editor.commit()
    }

    private fun saveActionStat(){
        if(isPassed) actPassed[currentAct]++
        val actions = arrayOf("sum", "diff", "mult", "div")
        for(i in 0..3){
            prefs = getSharedPreferences(actions[i] + "_stat", Context.MODE_PRIVATE)
            val answers = actPoints[i] + actPassed[i] + prefs.getInt("answers", 0)
            actPoints[i] +=  prefs.getInt("correct", 0)
            actFails[i] += prefs.getInt("fail", 0)
            actPassed[i] += prefs.getInt("pass", 0)
            val editor = prefs.edit()
            editor.clear()
            editor.putInt("correct", actPoints[i])
            editor.putInt("fail", actFails[i])
            editor.putInt("pass", actPassed[i])
            editor.putInt("answers", answers)
            editor.commit()
        }
    }

    fun generateTaskText(lvl:Int):Array<Int>{
        var action = ""
        var arrayTask = TaskHelper.generateTask(lvl)
        when (arrayTask[2]){
            1-> action = "+"
            2-> action = "-"
            3-> action = "*"
            4-> action = ":"
        }
        currentAct = arrayTask[2] - 1
        task.text = arrayTask[0].toString()+ " " + action + " " + arrayTask[1].toString()
        return arrayTask
    }

}