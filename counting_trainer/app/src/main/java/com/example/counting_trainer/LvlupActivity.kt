package com.example.counting_trainer

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.counting_trainer.firstStart.FirstResult
import com.example.counting_trainer.helpers.TaskHelper
import kotlinx.android.synthetic.main.activity_lvlup.*
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.keybord.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.toolbar.view.*


class LvlupActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lvlup)
        // Настройка toolbar
        to_home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //End toolbar
        val intentWithLvl = getIntent()
        val lvl = intentWithLvl.getIntExtra("lvl", 1)
        if (intentWithLvl.getBooleanExtra("first start", false)) {
            toolbar.tooltext.text = "Определяем уровень"
        }else  toolbar.tooltext.text = "Повышение уровня"
        var current_task_num = 1
        val max_task_num = 10
        var points = 0

        var arrayTask = generateTaskText(lvl)

        val timerObj = object: CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timer.text = "Осталось времени:" + (millisUntilFinished/1000).toString()
            }

            override fun onFinish() {
                if (current_task_num != max_task_num) nextbut.callOnClick()
            }
        }

        timerObj.start()

        nextbut.setOnClickListener {
            if(current_task_num<max_task_num) {
                if (arrayTask[3].toString() == answer.text){
                    points++
                    answer.setBackgroundColor(Color.GREEN)
                }
                else{
                    answer.setBackgroundColor(Color.RED)
                }
                answer.text = ""
                current_task_num++
                arrayTask = generateTaskText(lvl)
                counter.text = "Вопрос $current_task_num/$max_task_num"
                timerObj.start()
            }
            else {
                if(intentWithLvl.getBooleanExtra("first start",false)){
                    val intentForResult = Intent(this, FirstResult::class.java)
                    intentForResult.putExtra("points", points )
                    startActivity(intentForResult)
                }
                else{
                    val intentForResult = Intent(this, ResultActivity::class.java)
                    intentForResult.putExtra("points", points )
                    startActivity(intentForResult)
                }

            }
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