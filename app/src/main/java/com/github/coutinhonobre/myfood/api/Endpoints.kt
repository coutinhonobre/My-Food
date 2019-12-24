package com.github.coutinhonobre.myfood.api

import com.github.coutinhonobre.myfood.api.modelos.Categorias
import com.github.coutinhonobre.myfood.api.modelos.Receitas
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Endpoints {

    @GET("v3tow")
    fun getAllReceitas() : Call<Receitas>

    @GET("1dk9g0")
    fun getAllCategorias() : Call<Categorias>


}