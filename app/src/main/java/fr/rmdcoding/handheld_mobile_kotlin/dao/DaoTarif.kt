package fr.rmdcoding.handheld_mobile_kotlin.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import fr.rmdcoding.handheld_mobile_kotlin.entities.Tarif


interface DaoTarif {
    @Query("SELECT * FROM tarif")
    fun getAll(): List<Tarif>

    @Query("SELECT * FROM tarif WHERE created_at LIKE :title")
    fun findByTitle(title: String): Tarif

    @Insert
    fun insertAll(vararg todo: Tarif)

    @Delete
    fun delete(tarif: Tarif)

    @Update
    fun updateTodo(vararg tarifs: Tarif)
}