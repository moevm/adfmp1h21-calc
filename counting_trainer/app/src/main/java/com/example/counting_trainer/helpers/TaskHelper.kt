package com.example.counting_trainer.helpers

import kotlinx.android.synthetic.main.activity_lvlup.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.toolbar.view.*

class TaskHelper(lvl:Int) {
    companion object Factory{
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

        fun checkSizeError(arrayTask:Array<Int>, textAnswer: String): String {
            var sizeError: String = ""
            if (!textAnswer.isEmpty()) {
                when {
                    Math.abs(arrayTask[3] - textAnswer.toInt()) < 3 -> sizeError = "Вы близки к правильному ответу!"
                    Math.abs(arrayTask[3] - textAnswer.toInt()) < 10 -> sizeError = "Умеренная ошибка!"
                    Math.abs(arrayTask[3] - textAnswer.toInt()) >= 10 -> sizeError = "Грубая ошибка!"
                }
            }
            return sizeError;
        }

        fun lvlUpCheck(points: Int, currentLvl: Int): Array<String> {
            var resultText = ""
            val success:String = "Уровень повышен!"
            val fail:String = "Тренируйтесь усерднее!"
            var secondText = ""
            if (points >= 8 ) {
                resultText = "Поздравляем, тест пройден!\n Ваш уровень повышен"
                secondText = success
                if (currentLvl >= 3) {
                    resultText = "Поздравляем, тест пройден!\n Теперь выше вас, только звёзды!"
                    secondText = "Это максимальный уровень!"
                }
            }
            else {
                resultText = "Вы не набрали достаточного количества баллов для повышения.\n Тренируйтесь усердней"
                secondText = fail
            }
            return arrayOf(resultText, secondText)
        }
    }
}