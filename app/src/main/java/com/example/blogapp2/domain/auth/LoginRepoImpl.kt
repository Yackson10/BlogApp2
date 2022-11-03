package com.example.blogapp2.domain.auth

import com.example.blogapp2.data.remote.auth.LoginDataSource
import com.example.blogapp2.domain.home.HomeScreenRepo
import com.google.firebase.auth.FirebaseUser

class LoginRepoImpl(private val dataSource: LoginDataSource): LoginRepo {

    override suspend fun signIn(email: String, password: String): FirebaseUser?
    = dataSource.signIn(email, password)


}