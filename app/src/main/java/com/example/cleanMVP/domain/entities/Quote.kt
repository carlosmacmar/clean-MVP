package com.example.cleanMVP.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quotes_table")
data class Quote (@PrimaryKey(autoGenerate = true) var id: Int?,
                  @ColumnInfo(name = "quote_text") var text: String,
                  @ColumnInfo(name = "quote_author") var author: String) {

    override fun toString(): String {
        return "$text - $author"
    }
}