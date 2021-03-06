package com.github.coutinhonobre.myfood.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "receitas")
data class Receita(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "receita")
    val receita: String,
    @ColumnInfo(name = "ingredientes")
    val ingredientes: String,
    @ColumnInfo(name = "modo_preparo")
    val modoPreparo: String,
    @ColumnInfo(name = "link_imagem")
    val linkImagem: String,
    @ColumnInfo(name = "rating")
    var rating: Float = 0F,
    @ColumnInfo(name = "like")
    var like: Boolean = false,
    @ColumnInfo(name = "categoria_id")
    val categoriaId: Long
)