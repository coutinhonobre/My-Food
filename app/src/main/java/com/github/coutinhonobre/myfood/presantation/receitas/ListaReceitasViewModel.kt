package com.github.coutinhonobre.myfood.presantation.receitas

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.coutinhonobre.myfood.model.Categoria
import com.github.coutinhonobre.myfood.model.Receita
import com.github.coutinhonobre.myfood.repository.AppRepository

class ListaReceitasViewModel(application: Application) : AndroidViewModel(application) {

    var receitaLiveData: MutableLiveData<List<Receita>> = MutableLiveData()

    private val appRepository = AppRepository(application)


    fun getReceitasCategoria(idCategoria: Long = 0) =
        appRepository.getAllReceitasPorCategoria(idCategoria)





}
