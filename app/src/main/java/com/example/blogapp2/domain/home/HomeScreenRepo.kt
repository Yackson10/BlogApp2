package com.example.blogapp2.domain.home

import com.example.blogapp2.core.Resource
import com.example.blogapp2.data.model.Post

interface HomeScreenRepo {
    suspend fun getLatestPosts() : Resource<List<Post>>


}