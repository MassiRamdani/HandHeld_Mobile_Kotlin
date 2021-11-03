package fr.rmdcoding.handheld_mobile_kotlin.Model.Entity

import androidx.room.*
import java.util.*


@Entity
data class Client(
    @PrimaryKey
    val clientID: String,
    val tarifId: Int,
    val reference: String,
    val name: String,
    val adresse: String,
    val tel: String,
    val fix: String,
    val gps_x: Double,
    val gps_y: Double,
    val codebarre: String,
    val qrCode: String,
    val ancienSolde: Double,
    val solde: Double,
    val rc: String,
    val ai: String,
    val mf: String,
    val nis: String,
    val activite: String,
    var created_at: Date?,
    var updated_at: Date?
)

@Entity(primaryKeys = ["clientId", "secteurId"])
data class ClientSecteurRef(
    val clientId: String,
    val secteurId: Int
)

data class ClientWithSecteur(
    @Embedded val client: Client,
    @Relation(
        parentColumn = "clientId",
        entityColumn = "secteurID",
        associateBy = Junction(ClientSecteurRef::class)
    )
    val secteurs: List<Secteur>
)

data class SecteurWithClient(
    @Embedded val secteur: Secteur,
    @Relation(
        parentColumn = "secteurID",
        entityColumn = "clientId",
        associateBy = Junction(ClientSecteurRef::class)
    )
    val clients: List<Client>
)

