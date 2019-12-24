package com.github.coutinhonobre.myfood.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios")
data class Usuario(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "nome")
    val nome: String,
    @ColumnInfo(name = "username")
    val username: String,
    @ColumnInfo(name = "senha")
    val senha: String
)










