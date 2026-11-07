package com.redyis.as_cuddly_funicular.data.datasource

import com.redyis.as_cuddly_funicular.R
import com.redyis.as_cuddly_funicular.data.dto.AppDto
import javax.inject.Inject

class MockAppDataSource @Inject constructor() {
    fun getApps(): List<AppDto> = listOf(
        AppDto(R.drawable.vk_icon, "VK", "Социальная сеть", "Соцсети"),
        AppDto(R.drawable.vk_music, "VK Музыка", "Музыкальный плеер", "Музыка"),
        AppDto(R.drawable.vk_video, "VK Видео", "Смотрите видео", "Развлечения"),
        AppDto(R.drawable.vk_play, "VK Play", "Игровая платформа", "Игры"),
        AppDto(R.drawable.vk_mail, "Почта Mail.ru", "Почтовый клиент", "Инструменты"),
        AppDto(R.drawable.vk_dzen, "Дзен", "Новости и статьи", "Новости"),
        AppDto(R.drawable.vk_mail, "Облако", "Хранилище файлов", "Инструменты"),
        AppDto(R.drawable.vk_sferum, "Сферум", "Учебный профиль", "Образование"),
        AppDto(R.drawable.vk_marusya, "Маруся", "Голосовой помощник", "Утилиты")
    )
}