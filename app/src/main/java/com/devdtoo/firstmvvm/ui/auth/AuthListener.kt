package com.devdtoo.firstmvvm.ui.auth

import androidx.lifecycle.LiveData
import com.devdtoo.firstmvvm.data.db.entities.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(user: User )
    fun onFailure(message: String)
}