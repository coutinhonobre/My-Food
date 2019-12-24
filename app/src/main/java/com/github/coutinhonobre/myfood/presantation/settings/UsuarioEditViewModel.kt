package com.github.coutinhonobre.myfood.presantation.settings

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.github.coutinhonobre.myfood.repository.AppRepository

class UsuarioEditViewModel(application: Application) : AndroidViewModel(application) {

    private val appRepository = AppRepository(application)

    fun getLoginID(id: Long) = appRepository.getAllLiveChecarUsuarioID(id)
}
