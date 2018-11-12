package tibaes.com.friends.project.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "friend_table")
data class Friend (
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        val id: Long,
        @ColumnInfo(name = "nome")
        var nome: String,
        @ColumnInfo(name = "telefone")
        var telefone: String = ""
        )