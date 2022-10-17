package com.example.obvioustask.local

import android.content.Context
import com.example.obvioustask.R
import com.example.obvioustask.model.ItemData
import com.squareup.moshi.JsonAdapter
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DataCallApi @Inject constructor(
    @ApplicationContext private val context: Context,
    private val jsonAdapter: JsonAdapter<List<ItemData>>
) {
    fun getApodItems(): List<ItemData> {
        val res = context.resources.openRawResource(R.raw.data)
        val jsonString = res.bufferedReader().use { it.readText() }
        return jsonAdapter.fromJson(jsonString) ?: error("Failed to parse JSON")
    }
}