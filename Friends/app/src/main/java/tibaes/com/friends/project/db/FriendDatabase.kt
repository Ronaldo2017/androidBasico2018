package tibaes.com.friends.project.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import kotlinx.coroutines.experimental.CoroutineScope

@Database(entities = [Friend::class], version = 1)
abstract class FriendDatabase: RoomDatabase() {

    abstract fun friendDAO():FriendDao

    companion object {

        @Volatile
        private var INSTANCE: FriendDatabase? = null
        fun getDatabase(context: Context, scope: CoroutineScope):FriendDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        FriendDatabase::class.java,
                        "friend-database"
                )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                instance
            }
        }
    }
}