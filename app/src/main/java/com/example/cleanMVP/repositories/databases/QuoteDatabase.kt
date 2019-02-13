package com.example.cleanMVP.repositories.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cleanMVP.domain.entities.Quote
import com.example.cleanMVP.repositories.daos.QuoteDao

@Database(entities = [Quote::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun quoteDao() : QuoteDao
}