package com.github.coutinhonobre.myfood.presantation.receitas

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.coutinhonobre.myfood.model.Categoria
import com.github.coutinhonobre.myfood.model.Receita

class ListaReceitasViewModel : ViewModel() {
    private val receitas: MutableList<Receita> = mutableListOf()
    val receitaLiveData: MutableLiveData<List<Receita>> = MutableLiveData()




    fun getReceitasCategoria(idCategoria: Long = 0) {

        for (i in 1..15) {
            var categoria = Categoria(
                1, "Categoria", ""
            )
            var receita = Receita(
                i.toLong(),
                "Receita Teste $i",
                "igredientes 1, igredientes2 ",
                "como preparar",
                "https://www.eucomosim.com/wp-content/uploads/2014/10/fc48ho050-02_xlg-e1412761851676-216x160.jpg",
                3.6F,
                false,
                categoria.id



            )
            Log.d("RECE", receita.receita)
            receitas.add(receita)
        }

        receitaLiveData.value = receitas

    }

    fun getReceitasNome(descricao: String){
        var receitaTemp = receitas.filter { it.receita.contains(descricao) }
        receitaLiveData.value = receitaTemp
    }


}
