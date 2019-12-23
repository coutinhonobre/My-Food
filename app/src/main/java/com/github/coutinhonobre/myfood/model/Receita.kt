package com.github.coutinhonobre.myfood.model

data class Receita(
    val id: Long,
    val receita: String,
    val ingredientes: String,
    val modoPreparo: String,
    val linkImagem: String,
    val rating: Float,
    val like: Boolean,
    val categorias: List<Categoria>
)