package fr.rmdcoding.handheld_mobile_kotlin.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import fr.rmdcoding.handheld_mobile_kotlin.Model.Entity.Client
import fr.rmdcoding.handheld_mobile_kotlin.Model.Repository.RepositoryClient
import kotlinx.coroutines.launch

class ClientViewModel(private val repositoryClient: RepositoryClient) : ViewModel() {

    val clients = repositoryClient.listClients
    fun insert(client: Client) = viewModelScope.launch {
        val idNewClient = repositoryClient.insert(client)
    }

    fun update(client: Client) = viewModelScope.launch {
        val nombreLigne = repositoryClient.update(client)
    }

    fun delele(client: Client) = viewModelScope.launch {
        val nombreLigne = repositoryClient.delete(client)
    }

    fun deleteAllClients() = viewModelScope.launch {
        val nombreLigne = repositoryClient.deleteAllClient()
    }

    fun findByName(name: String) = viewModelScope.launch {
        val client = repositoryClient.findByName(name)
    }

    fun findById(id: String) = viewModelScope.launch {
        val client = repositoryClient.findById(id)
    }

    fun getClientWithSecteurs() = viewModelScope.launch {
        val clients = repositoryClient.getClientWithSecteurs()
    }


}

class ClientViewModelFactory(private val repositoryClient: RepositoryClient) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ClientViewModel::class.java))
            return ClientViewModel(repositoryClient) as T
        throw IllegalArgumentException("class ViewMolde inconnue  ")
    }
}