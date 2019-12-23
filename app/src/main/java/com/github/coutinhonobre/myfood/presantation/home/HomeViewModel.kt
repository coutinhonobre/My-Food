package com.github.coutinhonobre.myfood.presantation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.coutinhonobre.myfood.model.Categoria
import com.github.coutinhonobre.myfood.model.Receita

class HomeViewModel : ViewModel() {

    private val receitasFavoritas: MutableList<Receita> = mutableListOf()
    val receitasFavoritasLiveData: MutableLiveData<List<Receita>> = MutableLiveData()

    private val categorias: MutableList<Categoria> = mutableListOf()
    val categoriasLiveData: MutableLiveData<List<Categoria>> = MutableLiveData()


    fun getReceitasFavoritas() {

        for (i in 1..15) {
            var categoria = Categoria(
                1, "Categoria", ""
            )
            var receita = Receita(
                i.toLong(),
                "Receita Teste",
                "igredientes 1, igredientes2 ",
                "como preparar",
                "https://www.eucomosim.com/wp-content/uploads/2014/10/fc48ho050-02_xlg-e1412761851676-216x160.jpg",
                3.6F,
                false,
                listOf(categoria)

            )
            receitasFavoritas.add(receita)
        }

        receitasFavoritasLiveData.value = receitasFavoritas

    }

    fun getCategorias(){

        for (i in 1..15){
            var categoria = Categoria(
                i.toLong(), "Categoria $i", "https://www.pizzatec.com.br/assets/uploads/gallery/images/2019/02/wesual-click-1151588-unsplash-1550257050.jpg"
            )
            categorias.add(categoria)
        }
        categoriasLiveData.value = categorias

    }


}
