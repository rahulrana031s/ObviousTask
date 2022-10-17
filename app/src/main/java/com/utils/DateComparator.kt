package com.example.obvioustask.utils

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.obvioustask.model.ItemData
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object DateComparator : Comparator<ItemData> {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun compare(o1: ItemData, o2: ItemData): Int {
        val date1 = LocalDate.parse(o1.date, DateTimeFormatter.ISO_DATE)
        val date2 = LocalDate.parse(o2.date, DateTimeFormatter.ISO_DATE)
        return when {
            date1.isAfter(date2) -> -1
            date2.isAfter(date1) -> 1
            else -> 0
        }
    }
}