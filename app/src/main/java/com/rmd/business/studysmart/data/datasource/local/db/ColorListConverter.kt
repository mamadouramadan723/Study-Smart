package com.rmd.business.studysmart.data.datasource.local.db

import androidx.compose.ui.graphics.Color
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ColorListConverter {

    @TypeConverter
    fun fromColorList(colorList: List<Color>): String {
        return Gson().toJson(colorList)
    }

    @TypeConverter
    fun toColorList(colorString: String): List<Color> {
        val listType = object : TypeToken<List<Color>>() {}.type
        return Gson().fromJson(
            colorString,
            listType
        )
    }
}
