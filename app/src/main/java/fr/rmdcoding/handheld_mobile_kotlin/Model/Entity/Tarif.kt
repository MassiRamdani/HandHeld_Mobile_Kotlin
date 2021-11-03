package fr.rmdcoding.handheld_mobile_kotlin.Model.Entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import java.util.*


@Entity
data class Tarif(
    @PrimaryKey
    var tarifId: Int,
    var content: String,

    var created_at: Date?,

    var updated_at: Date?
)

@Entity
data class TarifWithClient(
    @Embedded val tarif: Tarif,
    @Relation(
        parentColumn = "clientId",
        entityColumn = "tarifId"
    )
    val clients: List<Client>
)