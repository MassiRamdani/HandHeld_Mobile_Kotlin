package fr.rmdcoding.handheld_mobile_kotlin.Model.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import fr.rmdcoding.handheld_mobile_kotlin.Model.Entity.Client
import fr.rmdcoding.handheld_mobile_kotlin.Model.Entity.ClientWithSecteur


@Dao
interface ClientDao {
    //suspend veut dire que cette fun doit etre executer dans le theread cree pas la coroutine
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(client: Client): Long

    @Update
    suspend fun update(client: Client): Int

    @Delete
    suspend fun delete(client: Client): Int

    @Query("DELETE FROM  Client")
    suspend fun deleteAllClient(): Int

    @Query("SELECT * FROM Client WHERE name=:name")
    suspend fun findByName(name: String): Client

    @Query("SELECT * FROM Client WHERE name=:id")
    suspend fun findById(id: String): Client

    @Query("SELECT * FROM Client")
    fun getAllClient(): LiveData<List<Client>>

    //on ajout transaction car room a besoin d'executé 2 requete
    @Transaction
    @Query("SELECT * FROM Client")
    suspend fun getClientWithSecteurs(): List<ClientWithSecteur>


}