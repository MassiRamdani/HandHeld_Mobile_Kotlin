package fr.rmdcoding.handheld_mobile_kotlin.Model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import fr.rmdcoding.handheld_mobile_kotlin.Model.Dao.TarifDao

import fr.rmdcoding.handheld_mobile_kotlin.Model.Entity.Tarif
import fr.rmdcoding.handheld_mobile_kotlin.Utils.Converters

@Database(entities = [Tarif::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {
    abstract val tarifDao: TarifDao

    //on a besoin qu'une seul instance de base de donnee alors on utilise companion object
    companion object {
        private var INSTANCE: AppDataBase? = null

        //fonction qui retourne l'instance de la bdd
        fun getInstance(context: Context): AppDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance =
                        Room.databaseBuilder(context, AppDataBase::class.java, "dbHht").build()
                }
                return instance
            }
        }
    }
}