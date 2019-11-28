package id.co.baseexample.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.co.baseexample.data.dao.TeamDao
import id.co.baseexample.data.dao.WordDao
import id.co.baseexample.data.entity.TeamEntity
import id.co.baseexample.data.entity.WordEntity

@Database(
    entities = [
        WordEntity::class,
        TeamEntity::class
    ], version = 2
)
abstract class database : RoomDatabase() {
    abstract fun wordDao() : WordDao
    abstract fun teamDao() : TeamDao

    companion object {
        @Volatile
        private var INSTANCE: database? = null

        fun getDatabase(context: Context) : database {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    database::class.java,
                    "base_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}