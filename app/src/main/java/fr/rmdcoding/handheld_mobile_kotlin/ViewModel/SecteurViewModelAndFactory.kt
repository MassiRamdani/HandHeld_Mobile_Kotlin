package fr.rmdcoding.handheld_mobile_kotlin.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import fr.rmdcoding.handheld_mobile_kotlin.Model.Entity.Secteur
import fr.rmdcoding.handheld_mobile_kotlin.Model.Repository.RepositorySecteur
import kotlinx.coroutines.launch

class SecteurViewModel(private val repositorySecteur: RepositorySecteur) : ViewModel() {

    val secteurs = repositorySecteur.listSecteurs
    fun insert(secteur: Secteur) = viewModelScope.launch {
        val idNewSecteur = repositorySecteur.insert(secteur)
    }

    fun update(secteur: Secteur) = viewModelScope.launch {
        val nombreLigne = repositorySecteur.update(secteur)
    }

    fun delele(secteur: Secteur) = viewModelScope.launch {
        val nombreLigne = repositorySecteur.delete(secteur)
    }

    fun deleteAllSecteurs() = viewModelScope.launch {
        val nombreLigne = repositorySecteur.deleteAllSecteur()
    }

    fun findByContent(content: String) = viewModelScope.launch {
        val secteur = repositorySecteur.findByContent(content)
    }

    fun getSecteurWithClients() = viewModelScope.launch {
        val secteurs = repositorySecteur.getSecteuWithClients()
    }


}

class SecteurViewModelFactory(private val repositorySecteur: RepositorySecteur) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SecteurViewModel::class.java))
            return SecteurViewModel(repositorySecteur) as T
        throw IllegalArgumentException("class ViewMolde inconnue  ")
    }
}