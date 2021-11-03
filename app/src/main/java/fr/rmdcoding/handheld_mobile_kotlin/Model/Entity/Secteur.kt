package fr.rmdcoding.handheld_mobile_kotlin.Model.Entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*

@Entity(indices = [Index(value = ["content"], unique = true)])
data class Secteur(
    @PrimaryKey
    val secteurId: Int,
    val content: String,
    val adresse: String,
    val libelleJour: String,
    var created_at: Date?,
    var updated_at: Date?
)
