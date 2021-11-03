package fr.rmdcoding.handheld_mobile_kotlin.Model.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity
data class Tarif(
    @PrimaryKey
    var id: Int,
    var content: String,
    var created_at: Date,
    var updated_at: Date
)