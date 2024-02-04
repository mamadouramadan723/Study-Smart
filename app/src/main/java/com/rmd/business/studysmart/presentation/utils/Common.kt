package com.rmd.business.studysmart.presentation.utils

import androidx.compose.ui.graphics.Color
import com.rmd.business.studysmart.presentation.theme.Green
import com.rmd.business.studysmart.presentation.theme.Orange
import com.rmd.business.studysmart.presentation.theme.Red
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter

enum class Priority(
        val title: String,
        val color: Color,
        val value: Int
) {
    LOW(
        title = "Low",
        color = Green,
        value = 0
    ),
    MEDIUM(
        title = "Medium",
        color = Orange,
        value = 1
    ),
    HIGH(
        title = "High",
        color = Red,
        value = 2
    );

    companion object {
        fun fromInt(value: Int) = entries.firstOrNull { it.value == value } ?: MEDIUM
    }
}

fun Long?.changeMillisToDateString(): String {
    val date: LocalDate = this?.let {
        Instant.ofEpochMilli(it)
            .atZone(ZoneId.systemDefault())
            .toLocalDate()
    } ?: LocalDate.now()
    return date.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"))
}

fun Long.toHours(): Float {
    val hours = this.toFloat() / 3600f
    return "%.2f".format(hours)
        .replace(
            ",",
            "."
        )
        .toFloat()
}