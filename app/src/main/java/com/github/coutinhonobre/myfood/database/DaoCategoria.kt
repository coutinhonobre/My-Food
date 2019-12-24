package com.github.coutinhonobre.myfood.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.github.coutinhonobre.myfood.model.Categoria

@Dao
interface DaoCategoria {


    @Query("select * from categorias")
    fun getAllCategorias(): LiveData<List<Categoria>>

    @Query("select * from categorias where id = :id")
    fun getAllLiveCategoriasID(id: Long): LiveData<List<Categoria>>

    @Query("select * from categorias where id = :id")
    fun getAllCategoriasID(id: Long): List<Categoria>

    @Query("select * from categorias where descricao = :descricao")
    fun getAllLiveCategoriasDescricao(descricao: String): List<Categoria>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAllCategoria(categorias: List<Categoria>)

    @Insert
    fun addCategoria(categoria: Categoria)

    @Update
    fun updateCategoria(categoria: Categoria)
}