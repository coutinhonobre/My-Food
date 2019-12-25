package com.github.coutinhonobre.myfood.presantation.settings

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.coutinhonobre.myfood.model.Usuario
import com.github.coutinhonobre.myfood.repository.AppRepository

class UsuarioEditViewModel(application: Application) : AndroidViewModel(application) {


    private val appRepository = AppRepository(application)

    fun getLogin(id : Long) = appRepository.getAllLiveChecarUsuario(id)

    fun updateUsuario(usuario: Usuario) = appRepository.updateUsuario(usuario)

}
