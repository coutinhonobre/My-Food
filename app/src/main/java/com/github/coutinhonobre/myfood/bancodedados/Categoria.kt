package com.github.coutinhonobre.myfood.bancodedados

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categorias")
data class Categoria(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = false)
    val id: Long,
    @ColumnInfo(name = "descricao")
    val descricao: String,
    @ColumnInfo(name = "imagem_receita")
    val imagemReceita: String
)
