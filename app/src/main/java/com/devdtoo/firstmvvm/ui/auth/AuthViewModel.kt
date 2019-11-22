package com.devdtoo.firstmvvm.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.devdtoo.firstmvvm.data.repositories.UserRepository

class AuthViewModel : ViewModel() {

    var email: String? = null
    var password: String? = null

    var authListener: AuthListener? = null

    fun onLoginButtonClick(view: View) {
        authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            //show error message
            authListener?.onFailure("Invalid email or password")
            return
        }

        //success
        val loginResponse = UserRepository().userLogin(email!!, password!!)
        authListener?.onSuccess(loginResponse)

    }

}