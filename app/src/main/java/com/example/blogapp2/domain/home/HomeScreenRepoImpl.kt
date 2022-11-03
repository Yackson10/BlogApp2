package com.example.blogapp2.domain.home

import com.example.blogapp2.core.Resource
import com.example.blogapp2.data.model.Post
import com.example.blogapp2.data.remote.home.HomeScreenDataSource

class HomeScreenRepoImpl(private  val dataSource: HomeScreenDataSource): HomeScreenRepo {

    override suspend fun getLatestPosts(): Resource<List<Post>> = dataSource.getLatestPosts()

}