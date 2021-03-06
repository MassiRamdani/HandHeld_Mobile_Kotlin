package fr.rmdcoding.handheld_mobile_kotlin.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import fr.rmdcoding.handheld_mobile_kotlin.Model.Entity.Tarif
import fr.rmdcoding.handheld_mobile_kotlin.Model.Repository.RepositoryTarif
import kotlinx.coroutines.launch

class TarifViewModel(private val repositoryTarif: RepositoryTarif) : ViewModel() {

    val tarifs = repositoryTarif.listTarifs
    fun insert(tarif: Tarif) = viewModelScope.launch {
        val idNewTarif = repositoryTarif.insert(tarif)
    }

    fun update(tarif: Tarif) = viewModelScope.launch {
        val nombreLigne = repositoryTarif.update(tarif)
    }

    fun delele(tarif: Tarif) = viewModelScope.launch {
        val nombreLigne = repositoryTarif.delete(tarif)
    }

    fun deleteAlltarif() = viewModelScope.launch {
        val nombreLigne = repositoryTarif.deleteAllTarif()
    }

    fun findByContent(content: String) = viewModelScope.launch {
        val tarif = repositoryTarif.findByContent(content)
    }

}

class TarifVMFactory(private val repositoryTarif: RepositoryTarif) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TarifViewModel::class.java))
            return TarifViewModel(repositoryTarif) as T
        throw IllegalArgumentException("class ViewMolde inconnue  ")
    }
}