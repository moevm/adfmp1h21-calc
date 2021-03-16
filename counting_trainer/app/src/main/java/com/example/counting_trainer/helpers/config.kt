package com.example.counting_trainer.helpers

enum class UpLvlEnum(val str: String) {
    FIRST_FAIL_STR("Вы не набрали достаточного количества баллов для повышения.\n Тренируйтесь усердней"),
    SECOND_FAIL_STR("Тренируйтесь усерднее!"),
    FIRST_SUCCESS_STR("Поздравляем, тест пройден!\n Ваш уровень повышен"),
    SECOND_SUCCESS_STR("Уровень повышен!"),
    FIRST_SUPERMIND_STR("Поздравляем, тест пройден!\n Теперь выше вас, только звёзды!"),
    SECOND_SUPERMIND_STR("Это максимальный уровень!"),
}