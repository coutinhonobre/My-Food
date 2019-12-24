package com.github.coutinhonobre.myfood.presantation.cadastro

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.github.coutinhonobre.myfood.model.Usuario
import com.github.coutinhonobre.myfood.repository.AppRepository

class CadastroViewModel(application: Application) : AndroidViewModel(application) {

    private val appRepository = AppRepository(application)

    fun getLogin(username: String, senha: String) = appRepository.getLogin(username, senha)

    fun setLogin(usuario: Usuario) = appRepository.setLogin(usuario)

}
