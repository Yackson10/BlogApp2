package com.example.blogapp2.data.remote.auth

import com.example.blogapp2.core.Resource
import com.example.blogapp2.data.model.Post
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class LoginDataSource {

    suspend fun signIn(email: String, password: String) : FirebaseUser?{
        val authResult = FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).await()
        return authResult.user

    }
}