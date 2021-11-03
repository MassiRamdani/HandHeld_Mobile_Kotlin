package fr.rmdcoding.handheld_mobile_kotlin.Model.Repository

import fr.rmdcoding.handheld_mobile_kotlin.Model.Dao.SecteurDao
import fr.rmdcoding.handheld_mobile_kotlin.Model.Entity.Secteur
import fr.rmdcoding.handheld_mobile_kotlin.Model.Entity.SecteurWithClient

class RepositorySecteur(private val dao: SecteurDao) {
    suspend fun insert(secteur: Secteur): Long = dao.insert(secteur)
    suspend fun update(secteur: Secteur): Int = dao.update(secteur)
    suspend fun delete(secteur: Secteur): Int = dao.delete(secteur)
    suspend fun deleteAllSecteur(): Int = dao.deleteAllSecteur()
    suspend fun findByContent(content: String): Secteur = dao.findByContent(content)
    suspend fun getSecteuWithClients(): List<SecteurWithClient> = dao.getSecteurWithClients()

    val listSecteurs = dao.getAllSecteur()

}