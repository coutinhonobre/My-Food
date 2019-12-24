package com.github.coutinhonobre.myfood.repository

import android.content.Context
import android.util.Log
import com.github.coutinhonobre.myfood.api.ApiService
import com.github.coutinhonobre.myfood.api.modelos.Categorias
import com.github.coutinhonobre.myfood.api.modelos.Receitas
import com.github.coutinhonobre.myfood.database.AppDataBase
import com.github.coutinhonobre.myfood.model.Categoria
import com.github.coutinhonobre.myfood.model.Receita
import org.jetbrains.anko.doAsync
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppRepository(val context: Context) {

    val request = ApiService.getEndpoints()

    val database = AppDataBase.getInstance(context)


    fun getAllCategorias() = database.Dao().getAllCategorias()

    fun getAllReceitas() = database.Dao().getAllLiveReceitas()

    fun getAllReceitasPorCategoria(categoriaId: Long) =
        database.Dao().getAllLiveReceitasCategoriaId(categoriaId)

    fun fetchDataReceitasFromServer() {

        request.getAllReceitas().enqueue(object : Callback<Receitas>{
            override fun onFailure(call: Call<Receitas>, t: Throwable) {
                Log.e("Falha", "Requisição Falhou!")
            }

            override fun onResponse(call: Call<Receitas>, response: Response<Receitas>) {
                if (response.code() == 200) {
                    val resultado = response.body()
                    resultado?.let {
                        doAsync {
                            var receitasModel: MutableList<Receita> = mutableListOf()
                            it.receitas.forEach { r ->
                                if(database.Dao().getAllLiveReceitasDescricao(r.receita).isEmpty()){
                                    receitasModel.add(
                                        Receita(
                                            receita = r.receita,
                                            ingredientes = r.ingredientes,
                                            like = false,
                                            categoriaId = r.categorias,
                                            linkImagem = r.linkImagem,
                                            modoPreparo = r.modoPreparo,
                                            rating = 0F
                                        )
                                    )
                                }
                            }
                            database.Dao().addAllReceita(receitasModel)
                            Log.i("RECEITA", "Requisição de RECEITA ${receitasModel.size}!")
                        }
                    }
                }
            }

        })



    }

    fun fetchDataCategoriasFromServer() {

        request.getAllCategorias().enqueue(object : Callback<Categorias> {
            override fun onFailure(call: Call<Categorias>, t: Throwable) {
                Log.e("Falha", "Requisição Falhou!")
            }

            override fun onResponse(call: Call<Categorias>, response: Response<Categorias>) {
                if (response.code() == 200) {
                    val resultado = response.body()
                    resultado?.let {
                        doAsync {
                            var categoriasModel: MutableList<Categoria> = mutableListOf()
                            it.categorias.forEach { c ->
                                if (database.Dao().getAllCategoriasID(c.id).isEmpty()) {
                                    categoriasModel.add(
                                        Categoria(
                                            id = c.id,
                                            descricao = c.descricao,
                                            imagemReceita = c.imagemReceita
                                        )
                                    )
                                } else {
                                    Log.e(
                                        "CATEGORIA",
                                        "${database.Dao().getAllCategoriasID(c.id)[0].descricao}"
                                    )
                                }
                            }
                            database.Dao().addAllCategoria(categoriasModel)
                            Log.i("CATEGORIA", "Requisição de Categoria ${categoriasModel.size}!")
                        }
                    }
                }
            }

        })

    }


}