package fr.rmdcoding.handheld_mobile_kotlin.Model.Repository

import fr.rmdcoding.handheld_mobile_kotlin.Model.Dao.ClientDao
import fr.rmdcoding.handheld_mobile_kotlin.Model.Entity.Client
import fr.rmdcoding.handheld_mobile_kotlin.Model.Entity.ClientWithSecteur

class RepositoryClient(private val dao: ClientDao) {
    suspend fun insert(client: Client): Long = dao.insert(client)
    suspend fun update(client: Client): Int = dao.update(client)
    suspend fun delete(client: Client): Int = dao.delete(client)
    suspend fun deleteAllClient(): Int = dao.deleteAllClient()
    suspend fun findByName(name: String): Client = dao.findByName(name)
    suspend fun findById(id: String): Client = dao.findById(id)
    suspend fun getClientWithSecteurs(): List<ClientWithSecteur> = dao.getClientWithSecteurs()

    val listClients = dao.getAllClient()

}