package fr.rmdcoding.handheld_mobile_kotlin.Model.Repository

import fr.rmdcoding.handheld_mobile_kotlin.Model.Dao.TarifDao
import fr.rmdcoding.handheld_mobile_kotlin.Model.Entity.Tarif

class RepositoryTarif(private val dao: TarifDao) {
    suspend fun insert(tarif: Tarif): Long = dao.insert(tarif)
    suspend fun update(tarif: Tarif): Int = dao.update(tarif)
    suspend fun delete(tarif: Tarif): Int = dao.delete(tarif)
    suspend fun deleteAllTarif(): Int = dao.deleteAllTarif()
    suspend fun findByContent(content: String): Tarif = dao.findByContent(content)
    val listTarifs = dao.getAllTarif()

}