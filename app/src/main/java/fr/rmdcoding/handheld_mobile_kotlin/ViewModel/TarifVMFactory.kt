package fr.rmdcoding.handheld_mobile_kotlin.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fr.rmdcoding.handheld_mobile_kotlin.Model.Repository.RepositoryTarif

/* cette class permet d'instancier une instance dans
    les views lequelle instance va nous permettre d'initialiser
    un objet ou une instance de TarifVM toujours dans les views */

class TarifVMFactory(private val repositoryTarif: RepositoryTarif) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TarifVM::class.java))
            return TarifVM(repositoryTarif) as T
        throw IllegalArgumentException("class ViewMolde inconnue  ")
    }


}