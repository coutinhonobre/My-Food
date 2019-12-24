package com.github.coutinhonobre.myfood.presantation.home

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.coutinhonobre.myfood.model.Categoria
import com.github.coutinhonobre.myfood.model.Receita
import com.github.coutinhonobre.myfood.repository.AppRepository

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val appRepository = AppRepository(application)


    init {
        appRepository.fetchDataReceitasFromServer()
        appRepository.fetchDataCategoriasFromServer()
    }


    fun getReceitasFavoritas() = appRepository.getAllReceitasLike()

    fun getCategorias() = appRepository.getAllCategorias()


}
