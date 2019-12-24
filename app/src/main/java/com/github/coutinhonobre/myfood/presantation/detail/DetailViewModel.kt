package com.github.coutinhonobre.myfood.presantation.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.github.coutinhonobre.myfood.model.Receita
import com.github.coutinhonobre.myfood.repository.AppRepository

class DetailViewModel(application: Application) : AndroidViewModel(application) {


    private val appRepository = AppRepository(application)


    fun getReceitaCategoria(idReceita: Long) = appRepository.getAllLiveReceitasID(idReceita)


    fun updateReceita(receita: Receita) = appRepository.updateReceita(receita)


}
