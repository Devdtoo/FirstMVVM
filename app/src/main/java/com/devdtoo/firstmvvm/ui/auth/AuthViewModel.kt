package com.devdtoo.firstmvvm.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.devdtoo.firstmvvm.data.repositories.UserRepository
import com.devdtoo.firstmvvm.util.Coroutines

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
        Coroutines.main {
            val response = UserRepository().userLogin(email!!, password!!)
            if (response.isSuccessful) {
                authListener?.onSuccess(response.body()?.user!!)
            }else {
                authListener?.onFailure("Error Code: ${response.code()}")
            }
        }





    }

}