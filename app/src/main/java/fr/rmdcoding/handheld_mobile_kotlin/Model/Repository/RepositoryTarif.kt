package fr.rmdcoding.handheld_mobile_kotlin.Model.Repository

import fr.rmdcoding.handheld_mobile_kotlin.Model.Dao.TarifDao
import fr.rmdcoding.handheld_mobile_kotlin.Model.Entity.Tarif
import fr.rmdcoding.handheld_mobile_kotlin.Model.Entity.TarifWithClient

class RepositoryTarif(private val dao: TarifDao) {
    suspend fun insert(tarif: Tarif): Long = dao.insert(tarif)
    suspend fun update(tarif: Tarif): Int = dao.update(tarif)
    suspend fun delete(tarif: Tarif): Int = dao.delete(tarif)
    suspend fun deleteAllTarif(): Int = dao.deleteAllTarif()
    suspend fun findByContent(content: String): Tarif = dao.findByContent(content)
    fun getTarifWithClient(): List<TarifWithClient> = dao.getTarifWithClient()
    fun getTarifWithClientById(id: Int): List<TarifWithClient> = dao.getTarifWithClientById(id)

    val listTarifs = dao.getAllTarif()

}