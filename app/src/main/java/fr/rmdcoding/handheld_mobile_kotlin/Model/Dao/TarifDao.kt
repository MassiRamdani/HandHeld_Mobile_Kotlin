package fr.rmdcoding.handheld_mobile_kotlin.Model.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import fr.rmdcoding.handheld_mobile_kotlin.Model.Entity.Tarif
import fr.rmdcoding.handheld_mobile_kotlin.Model.Entity.TarifWithClient

@Dao
interface TarifDao {
    //suspend veut dire que cette fun doit etre executer dans le theread cree pas la coroutine
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(tarif: Tarif): Long

    @Update
    suspend fun update(tarif: Tarif): Int

    @Delete
    suspend fun delete(tarif: Tarif): Int

    @Query("DELETE FROM  Tarif")
    suspend fun deleteAllTarif(): Int

    @Query("SELECT * FROM Tarif WHERE content LIKE :content")
    suspend fun findByContent(content: String): Tarif

    @Query("SELECT * FROM Tarif")
    fun getAllTarif(): LiveData<List<Tarif>>

    //on ajout transaction car room a besoin d'executé 2 requete
    @Transaction
    @Query("SELECT * FROM Tarif")
    fun getTarifWithClient(): List<TarifWithClient>

    @Transaction
    @Query("SELECT * FROM Tarif where tarifId=:id")
    fun getTarifWithClientById(id: Int): List<TarifWithClient>
}