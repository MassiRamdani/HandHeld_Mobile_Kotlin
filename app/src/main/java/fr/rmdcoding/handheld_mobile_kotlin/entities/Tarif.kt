package fr.rmdcoding.handheld_mobile_kotlin.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity
data class Tarif(
    @PrimaryKey
    var id: Int,
    @ColumnInfo(name = "tarif_name")
    var content: String,
    @ColumnInfo(name = "created_at")
    var created_at: Date,
    @ColumnInfo(name = "updated_at")
    var updated_at: Date
)