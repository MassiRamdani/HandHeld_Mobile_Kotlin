package fr.rmdcoding.handheld_mobile_kotlin.Model.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import fr.rmdcoding.handheld_mobile_kotlin.Model.Entity.Secteur
import fr.rmdcoding.handheld_mobile_kotlin.Model.Entity.SecteurWithClient


@Dao
interface SecteurDao {
    //suspend veut dire que cette fun doit etre executer dans le theread cree pas la coroutine
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(secteur: Secteur): Long

    @Update
    suspend fun update(secteur: Secteur): Int

    @Delete
    suspend fun delete(secteur: Secteur): Int

    @Query("DELETE FROM  Secteur")
    suspend fun deleteAllSecteur(): Int

    @Query("SELECT * FROM Secteur WHERE content LIKE :content")
    suspend fun findByContent(content: String): Secteur

    @Query("SELECT * FROM Secteur")
    fun getAllSecteur(): LiveData<List<Secteur>>

    //on ajout transaction car room a besoin d'executé 2 requete
    @Transaction
    @Query("SELECT * FROM Secteur")
    suspend fun getSecteurWithClients(): List<SecteurWithClient>

}