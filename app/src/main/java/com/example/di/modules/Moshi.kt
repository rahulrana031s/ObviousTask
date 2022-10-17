package com.example.obvioustask.di.modules

import com.example.obvioustask.model.ItemData
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MoshiModule {
    @Provides
    fun providesMoshi() = Moshi.Builder().build()

    @Provides
    fun providesApodItemJsonAdapter(moshi: Moshi): JsonAdapter<List<ItemData>> {
        val listOfItemTypeData = Types.newParameterizedType(List::class.java, ItemData::class.java)
        return moshi.adapter<List<ItemData>>(listOfItemTypeData).failOnUnknown()
    }
}