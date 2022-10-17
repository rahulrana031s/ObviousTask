package com.example.obvioustask.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.obvioustask.local.DataCallApi
import com.example.obvioustask.model.ItemData
import com.example.obvioustask.utils.DateComparator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(dataCallApi: DataCallApi) : ViewModel() {
    var itemsData: MutableLiveData<List<ItemData>> =
        MutableLiveData(dataCallApi.getApodItems().sortedWith(DateComparator))
}