package com.github.coutinhonobre.myfood.presantation.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.coutinhonobre.myfood.model.Categoria
import com.github.coutinhonobre.myfood.model.Receita

class DetailViewModel : ViewModel() {
    private lateinit var receita: Receita
    val receitaLiveData: MutableLiveData<Receita> = MutableLiveData()


    fun getReceitaCategoria(idReceita: Long) {

        var categoria = Categoria(
            1, "Categoria", ""
        )
        receita = Receita(
            idReceita,
            "Receita Teste $idReceita",
            "igredientes 1, igredientes2 ",
            "como preparar",
            "https://www.eucomosim.com/wp-content/uploads/2014/10/fc48ho050-02_xlg-e1412761851676-216x160.jpg",
            3.6F,
            false,
            listOf(categoria)
        )


        receitaLiveData.value = receita

    }


}
