package com.example.counting_trainer.helpers

enum class UpLvlEnum(val str: String) {
    FIRST_FAIL_STR("Вы не набрали достаточного количества баллов для повышения.\n Тренируйтесь усердней"),
    SECOND_FAIL_STR("Тренируйтесь усерднее!"),
    FIRST_SUCCESS_STR("Поздравляем, тест пройден!\n Ваш уровень повышен"),
    SECOND_SUCCESS_STR("Уровень повышен!"),
    FIRST_SUPERMIND_STR("Поздравляем, тест пройден!\n Теперь выше вас, только звёзды!"),
    SECOND_SUPERMIND_STR("Это максимальный уровень!"),
}

enum class CurrentLvlEnum(val str: String) {
    NOOB_LVL("Привет, ваш уровень - Начинающий"),
    MEDIUM_LVL("Привет, ваш уровень - Средний"),
    SUPERMIND_LVL("Привет, ваш уровень - Сверхразум")
}

enum class ProcessedLvlEnum(val str: String) {
    NOOB_LVL("Ваш уровень: Начинающий"),
    MEDIUM_LVL("Ваш уровень: Средний"),
    SUPERMIND_LVL("Ваш уровень: Сверхразум")
}

enum class SizeErorEnum(val str: String) {
    NEAR("Вы близки к правильному ответу!"),
    MEDIUM("Умеренная ошибка!"),
    HIGH("Грубая ошибка!")
}