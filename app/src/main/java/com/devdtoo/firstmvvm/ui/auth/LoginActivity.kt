package com.devdtoo.firstmvvm.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.devdtoo.firstmvvm.R
import com.devdtoo.firstmvvm.data.db.entities.User
import com.devdtoo.firstmvvm.databinding.ActivityLoginBinding
import com.devdtoo.firstmvvm.util.hide
import com.devdtoo.firstmvvm.util.show
import com.devdtoo.firstmvvm.util.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Binding the Activity
        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        //Getting viewModel
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)

        //Binding viewModel to the activity
        binding.viewmodel = viewModel

        //defining AuthListener to the viewModel
        viewModel.authListener = this


    }

    override fun onStarted() {
        progress_bar.show()
    }

    override fun onSuccess(user: User) {
        progress_bar.hide()
        toast("${user.name} is logged In")
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        toast(message)
    }
}
