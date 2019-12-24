package com.github.coutinhonobre.myfood.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.github.coutinhonobre.myfood.model.Receita

@Dao
interface DaoReceita {

    @Query("select * from receitas")
    fun getAllReceitas(): List<Receita>

    @Query("select * from receitas")
    fun getAllLiveReceitas(): LiveData<List<Receita>>

    @Query("select * from receitas where like = :like")
    fun getAllLiveReceitasLike(like: Boolean): LiveData<List<Receita>>

    @Query("select * from receitas where id = :id")
    fun getAllLiveReceitasID(id: Long): LiveData<List<Receita>>

    @Query("select * from receitas where categoria_id = :categoriaId")
    fun getAllLiveReceitasCategoriaId(categoriaId: Long): LiveData<List<Receita>>


    @Query("select * from receitas where receita = :receita")
    fun getAllLiveReceitasDescricao(receita: String): List<Receita>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAllReceita(categorias: List<Receita>)

    @Insert
    fun addReceita(Receita: Receita)

    @Update
    fun updateReceita(Receita: Receita)
    
}