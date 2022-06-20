package com.example.wbinternw8part3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wbinternw8part3.model.AppState
import com.example.wbinternw8part3.model.repository.Repository
import com.example.wbinternw8part3.model.repository.RepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoriteViewModel(
    private val repository: Repository = RepositoryImpl()
) : ViewModel() {

    private val _data = MutableLiveData<AppState>()

    val liveData: LiveData<AppState> = _data

    fun getData() {
        _data.postValue(AppState.Loading)
        viewModelScope.launch { loadData() }
    }

    private suspend fun loadData() = withContext(Dispatchers.IO) {
        try {
            _data.postValue(AppState.SuccessFavorite(repository.getDataFromDB()))
        } catch (e: Throwable) {
            _data.postValue(AppState.Error(e))
        }
    }
}