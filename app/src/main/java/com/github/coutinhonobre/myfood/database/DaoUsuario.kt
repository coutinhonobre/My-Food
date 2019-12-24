package com.github.coutinhonobre.myfood.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.github.coutinhonobre.myfood.model.Usuario

@Dao
interface DaoUsuario {

    @Query("select * from usuarios where username = :username and senha = :senha")
    fun getAllLiveusuarios(username: String, senha: String): LiveData<List<Usuario>>


    @Insert
    fun addUsuario(usuario: Usuario)

    @Update
    fun updateUsuario(usuario: Usuario)

}