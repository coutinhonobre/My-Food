package com.github.coutinhonobre.myfood.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categorias")
data class Categoria(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Long,
    @ColumnInfo(name = "descricao")
    val descricao: String,
    @ColumnInfo(name = "imagem_receita")
    val imagemReceita: String
)