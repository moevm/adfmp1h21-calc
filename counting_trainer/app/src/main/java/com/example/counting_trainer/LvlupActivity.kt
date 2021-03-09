package com.example.counting_trainer

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_lvlup.*
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.keybord.*
import kotlinx.android.synthetic.main.toolbar.view.*

class LvlupActivity : AppCompatActivity() {

    fun generateTask(lvl: Int):Array<Int>{
        var first_number:Int = 0
        var second_number:Int = 0
        var action = 0
        var result = 0
        when (lvl){
            1 -> {
                action = (1..4).random()
                when(action){
                    1->{
                        first_number = (1..20).random()
                        second_number = (1..20).random()
                        result = first_number + second_number
                    }
                    2->{
                        first_number = (1..20).random()
                        second_number = (1..20).random()
                        if (first_number < second_number) {
                            val swap:Int = second_number
                            second_number = first_number
                            first_number = swap
                        }
                        result = first_number - second_number
                    }
                    3->{
                        first_number = (1..10).random()
                        second_number = (1..10).random()
                        result = first_number * second_number
                    }
                    4->{
                        first_number = (1..10).random()
                        second_number = (1..10).random()
                        result =  (first_number * second_number )/ second_number
                        first_number *= second_number
                    }
                }
            }
            2 -> {
                action = (1..4).random()
                when(action){
                    1->{
                        first_number = (20..100).random()
                        second_number = (20..100).random()
                        result = first_number + second_number
                    }
                    2->{
                        first_number = (20..100).random()
                        second_number = (20..100).random()
                        if (first_number < second_number) {
                            val swap:Int = second_number
                            second_number = first_number
                            first_number = swap
                        }
                        result = first_number - second_number
                    }
                    3->{
                        first_number = (10..20).random()
                        second_number = (10..20).random()
                        result = first_number * second_number
                    }
                    4->{
                        first_number = (10..20).random()
                        second_number = (10..20).random()
                        result =  (first_number * second_number )/ second_number
                        first_number *= second_number
                    }
                }
            }
            3 -> {
                action = (1..4).random()
                when(action){
                    1->{
                        first_number = (100..200).random()
                        second_number = (100..200).random()
                        result = first_number + second_number
                    }
                    2->{
                        first_number = (100..200).random()
                        second_number = (100..200).random()
                        if (first_number < second_number) {
                            val swap:Int = second_number
                            second_number = first_number
                            first_number = swap
                        }
                        result = first_number - second_number
                    }
                    3->{
                        first_number = (15..30).random()
                        second_number = (15..30).random()
                        result = first_number * second_number
                    }
                    4->{
                        first_number = (15..30).random()
                        second_number = (15..30).random()
                        result =  (first_number * second_number )/ second_number
                        first_number *= second_number
                    }
                }
            }
        }
        return arrayOf(first_number,second_number,action,result)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lvlup)
        toolbar.tooltext.text = "Повышение уровня"
        var current_task_num:Int = 1
        val max_task_num:Int = 10
        var points:Int = 0
        val lvl:Int = 1
        var  arrayTask = generateTask(lvl)
        var action:String = ""
        when (arrayTask[2]){
            1-> action = "+"
            2-> action = "-"
            3-> action = "*"
            4-> action = ":"

        }
        task.text = arrayTask[0].toString()+ " " + action + " " + arrayTask[1].toString()
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
                arrayTask = generateTask(lvl)
                when (arrayTask[2]){
                    1-> action = "+"
                    2-> action = "-"
                    3-> action = "*"
                    4-> action = ":"

                }
                task.text = arrayTask[0].toString()+ " " + action + " " + arrayTask[1].toString()
                counter.text = "Вопрос $current_task_num/$max_task_num"
                timerObj.start()
            }
            else {
                val intent = Intent(this, ResultActivity::class.java)
                startActivity(intent)
            }
        }

        one_but.setOnClickListener {
            answer.text = answer.text.toString() + "1"
        }
        two_but.setOnClickListener {
            answer.text = answer.text.toString() + "2"
        }
        three_but.setOnClickListener {
            answer.text = answer.text.toString() + "3"
        }
        four_but.setOnClickListener {
            answer.text = answer.text.toString() + "4"
        }
        five_but.setOnClickListener {
            answer.text = answer.text.toString() + "5"
        }
        six_but.setOnClickListener {
            answer.text = answer.text.toString() + "6"
        }
        seven_but.setOnClickListener {
            answer.text = answer.text.toString() + "7"
        }
        eight_but.setOnClickListener {
            answer.text = answer.text.toString() + "8"
        }
        nine_but.setOnClickListener {
            answer.text = answer.text.toString() + "9"
        }
        zero_but.setOnClickListener {
            answer.text = answer.text.toString() + "0"
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

}