package by.agentges.fueler.core.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Refill::class], version = 1)
abstract class FuelerDatabase : RoomDatabase() {
    abstract fun refillDao(): RefillDao
}