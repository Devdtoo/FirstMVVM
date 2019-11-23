package com.devdtoo.firstmvvm.data.repositories


import com.devdtoo.firstmvvm.data.network.MyApi
import com.devdtoo.firstmvvm.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository {

    suspend fun userLogin(email: String, password: String) : Response<AuthResponse> {

        return MyApi().userLogin(email, password)

    }

}