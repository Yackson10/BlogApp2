package com.example.blogapp2.domain.auth

import com.example.blogapp2.core.Resource
import com.example.blogapp2.data.model.Post
import com.google.firebase.auth.FirebaseUser

interface LoginRepo {
    suspend fun signIn(email: String, password: String): FirebaseUser?


}