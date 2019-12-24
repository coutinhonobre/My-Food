package com.github.coutinhonobre.myfood.presantation.receitas

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.github.coutinhonobre.myfood.repository.AppRepository

class ListaReceitasViewModel(application: Application) : AndroidViewModel(application) {


    private val appRepository = AppRepository(application)


    fun getReceitasCategoria(idCategoria: Long = 0) =
        appRepository.getAllReceitasPorCategoria(idCategoria)


}
