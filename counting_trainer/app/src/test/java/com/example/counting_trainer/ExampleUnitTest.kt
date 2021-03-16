package com.example.counting_trainer

import org.junit.Test

import org.junit.Assert.*
import com.example.counting_trainer.helpers.TaskHelper
import com.example.counting_trainer.TrainingActivity
import com.example.counting_trainer.helpers.UpLvlEnum
import kotlinx.android.synthetic.main.activity_lvlup.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testingTashGenerate() {
        // Lvl - noob
        var resultGenerate: Int? = null;
        var isNormalLvL: Boolean = false
        var arrayTask:Array<Int> = TaskHelper.generateTask(1)
        if (arrayTask !== null) {
            when (arrayTask[2]) {
                1 -> {
                    resultGenerate = arrayTask[0] + arrayTask[1]
                    isNormalLvL = resultGenerate <= 40
                }
                2 -> {
                    resultGenerate = arrayTask[0] - arrayTask[1]
                    isNormalLvL = resultGenerate <= 20 && resultGenerate >= -20
                }
                3 -> {
                    resultGenerate = arrayTask[0] * arrayTask[1]
                    isNormalLvL = resultGenerate <= 100 && resultGenerate >= 0
                }
                4 -> {
                    if (arrayTask[1] !== 0) {
                        resultGenerate = arrayTask[0] / arrayTask[1]
                        isNormalLvL = resultGenerate <= 100 && resultGenerate >= 0
                    }
                }
            }
        }
        // println("${resultGenerate} ${isNormalLvL} ${arrayTask[0]} ${arrayTask[1]} ${arrayTask[2]} ${arrayTask[3]}")
        assertEquals(arrayTask[3], resultGenerate)
        assertEquals(true, isNormalLvL)

        // Lvl - medium
        resultGenerate = null;
        isNormalLvL = false
        arrayTask = TaskHelper.generateTask(2)
        if (arrayTask !== null) {
            when (arrayTask[2]) {
                1 -> {
                    resultGenerate = arrayTask[0] + arrayTask[1]
                    isNormalLvL = resultGenerate <= 200
                }
                2 -> {
                    resultGenerate = arrayTask[0] - arrayTask[1]
                    isNormalLvL = resultGenerate <= 100 && resultGenerate >= -80
                }
                3 -> {
                    resultGenerate = arrayTask[0] * arrayTask[1]
                    isNormalLvL = resultGenerate <= 400 && resultGenerate >= 0
                }
                4 -> {
                    if (arrayTask[1] !== 0) {
                        resultGenerate = arrayTask[0] / arrayTask[1]
                        isNormalLvL = resultGenerate <= 400 && resultGenerate >= 0
                    }
                }
            }
        }
        // println("${resultGenerate} ${isNormalLvL} ${arrayTask[0]} ${arrayTask[1]} ${arrayTask[2]} ${arrayTask[3]}")
        assertEquals(arrayTask[3], resultGenerate)
        assertEquals(true, isNormalLvL)

        // Lvl - supermind
        resultGenerate = null;
        isNormalLvL = false
        arrayTask = TaskHelper.generateTask(3)
        if (arrayTask !== null) {
            when (arrayTask[2]) {
                1 -> {
                    resultGenerate = arrayTask[0] + arrayTask[1]
                    isNormalLvL = resultGenerate <= 400
                }
                2 -> {
                    resultGenerate = arrayTask[0] - arrayTask[1]
                    isNormalLvL = resultGenerate <= 100 && resultGenerate >= -100
                }
                3 -> {
                    resultGenerate = arrayTask[0] * arrayTask[1]
                    isNormalLvL = resultGenerate <= 900 && resultGenerate >= 0
                }
                4 -> {
                    if (arrayTask[1] !== 0) {
                        resultGenerate = arrayTask[0] / arrayTask[1]
                        isNormalLvL = resultGenerate <= 900 && resultGenerate >= 0
                    }
                }
            }
        }
        // println("${resultGenerate} ${isNormalLvL} ${arrayTask[0]} ${arrayTask[1]} ${arrayTask[2]} ${arrayTask[3]}")
        assertEquals(arrayTask[3], resultGenerate)
        assertEquals(true, isNormalLvL)
    }

    @Test
    fun testingCheckAnswerUser() {
        // Lvl - medium
        var resultGenerate: Int? = null;
        var isNormalLvL: Boolean = false
        var arrayTask:Array<Int> = TaskHelper.generateTask(2)
        if (arrayTask !== null) {
            when (arrayTask[2]) {
                1 -> {
                    resultGenerate = arrayTask[0] + arrayTask[1]
                    isNormalLvL = resultGenerate <= 200
                }
                2 -> {
                    resultGenerate = arrayTask[0] - arrayTask[1]
                    isNormalLvL = resultGenerate <= 100 && resultGenerate >= -80
                }
                3 -> {
                    resultGenerate = arrayTask[0] * arrayTask[1]
                    isNormalLvL = resultGenerate <= 400 && resultGenerate >= 0
                }
                4 -> {
                    if (arrayTask[1] !== 0) {
                        resultGenerate = arrayTask[0] / arrayTask[1]
                        isNormalLvL = resultGenerate <= 400 && resultGenerate >= 0
                    }
                }
            }
        }
        // println("${resultGenerate} ${isNormalLvL} ${arrayTask[0]} ${arrayTask[1]} ${arrayTask[2]} ${arrayTask[3]}")
        assertEquals(arrayTask[3], resultGenerate)
        assertEquals(true, isNormalLvL)
        assertEquals("", "")
        assertEquals("Вы близки к правильному ответу!",
            TaskHelper.checkSizeError(arrayTask, (arrayTask[3] - 2).toString()))
        assertEquals("Умеренная ошибка!",
            TaskHelper.checkSizeError(arrayTask, (arrayTask[3] - 3).toString()))
        assertEquals("Умеренная ошибка!",
            TaskHelper.checkSizeError(arrayTask, (arrayTask[3] - 9).toString()))
        assertEquals("Грубая ошибка!",
            TaskHelper.checkSizeError(arrayTask, (arrayTask[3] - 10).toString()))
        assertEquals("Грубая ошибка!",
            TaskHelper.checkSizeError(arrayTask, (arrayTask[3] - 11).toString()))
    }

    @Test
    fun testingUpLvl() {
        var lvl = 2
        var resFalseOne = TaskHelper.lvlUpCheck(7, lvl)
        var resFalseTwo = TaskHelper.lvlUpCheck(8, lvl)
        var resFalseThree = TaskHelper.lvlUpCheck(9, lvl)
        assertEquals(UpLvlEnum.FIRST_FAIL_STR, resFalseOne[0])
        assertEquals(UpLvlEnum.SECOND_FAIL_STR, resFalseOne[1])
        assertEquals(UpLvlEnum.FIRST_SUCCESS_STR, resFalseTwo[0])
        assertEquals(UpLvlEnum.SECOND_SUCCESS_STR, resFalseTwo[1])
        assertEquals(UpLvlEnum.FIRST_SUCCESS_STR, resFalseThree[0])
        assertEquals(UpLvlEnum.SECOND_SUCCESS_STR, resFalseThree[1])

        lvl = 3
        resFalseOne = TaskHelper.lvlUpCheck(7, lvl)
        resFalseTwo = TaskHelper.lvlUpCheck(8, lvl)
        resFalseThree = TaskHelper.lvlUpCheck(9, lvl)
        assertEquals(UpLvlEnum.FIRST_FAIL_STR, resFalseOne[0])
        assertEquals(UpLvlEnum.SECOND_FAIL_STR, resFalseOne[1])
        assertEquals(UpLvlEnum.FIRST_SUPERMIND_STR, resFalseTwo[0])
        assertEquals(UpLvlEnum.SECOND_SUPERMIND_STR, resFalseTwo[1])
        assertEquals(UpLvlEnum.FIRST_SUPERMIND_STR, resFalseThree[0])
        assertEquals(UpLvlEnum.SECOND_SUPERMIND_STR, resFalseThree[1])
    }
}