package com.example.blogapp2.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.blogapp2.core.Resource
import com.example.blogapp2.domain.home.HomeScreenRepo
import kotlinx.coroutines.Dispatchers

class HomeScreenViewModel(private val repo: HomeScreenRepo): ViewModel() {

    fun fetchLatestPosts() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getLatestPosts())
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }
}

class HomeScreenViewModelFactory(private val repo: HomeScreenRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeScreenViewModel(repo) as T
        //return modelClass.getConstructor(HomeScreenRepo::class.java).newInstance(repo)
    }

}