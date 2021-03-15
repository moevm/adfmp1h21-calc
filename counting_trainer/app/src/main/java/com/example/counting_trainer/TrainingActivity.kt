package com.example.counting_trainer

import android.content.Intent
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_training)
        // Настройка toolbar
        toolbar.tooltext.text = "Тренировка!"
        to_home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //End toolbar
        var points:Int = 0
        val intentWithLvl = getIntent()
        val lvl = intentWithLvl.getIntExtra("lvl", 1)
        var arrayTask = generateTaskText(lvl)

        nextbut.setOnClickListener {
                if (arrayTask[3].toString() == answer.text) {
                    points++
                    answer.setBackgroundColor(Color.GREEN)
                    hint.text = ""
                    answer.text = ""
                    arrayTask = generateTaskText(lvl)
                }
                else{
                    answer.setBackgroundColor(Color.RED)
                    if (!answer.text.toString().isEmpty()){
                        when {
                            abs(arrayTask[3] - answer.text.toString().toInt()) < 3 -> hint.text = "Вы близки к правильному ответу!"
                            abs(arrayTask[3] - answer.text.toString().toInt()) < 10 -> hint.text = "Умеренная ошибка!"
                            abs(arrayTask[3] - answer.text.toString().toInt()) >= 10 -> hint.text = "Грубая ошибка!"
                        }
                    }
                }
        }

        pass.setOnClickListener {
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
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


    }

    fun digit(view: View){
        val text = (view as Button).text
        if (answer.text.length<6) answer.text = answer.text.toString() + text

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
        task.text = arrayTask[0].toString()+ " " + action + " " + arrayTask[1].toString()
        return arrayTask
    }

}