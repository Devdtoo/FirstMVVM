package com.devdtoo.firstmvvm.data.network.responses

import com.devdtoo.firstmvvm.data.db.entities.User

data class AuthResponse(
    val isSuccessful : Boolean?,
    val  message : String?,
    val user: User?
)