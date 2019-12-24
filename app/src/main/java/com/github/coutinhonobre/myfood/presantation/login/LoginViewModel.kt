package com.github.coutinhonobre.myfood.presantation.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.github.coutinhonobre.myfood.repository.AppRepository

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val appRepository = AppRepository(application)

    fun getLogin(username: String, senha: String) = appRepository.getLogin(username, senha)


}