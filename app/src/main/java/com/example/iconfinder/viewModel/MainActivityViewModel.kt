package com.example.iconfinder.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.iconfinder.Repository
import com.example.iconfinder.model.Icon

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private var recentQuery = "\"\""
    private var recentCount = 0
    private var recentIndex = 0
    private var latestData = MutableLiveData<List<Icon>>()

    fun getIcons(query: String, count: Int, index: Int): LiveData<List<Icon>> {
        if (query == recentQuery && recentCount == count && recentIndex == index) {
            return latestData
        }
        recentQuery = query
        recentCount = count
        recentIndex = index

        latestData = Repository.getIcons(query, count, index)

        return latestData

    }
}