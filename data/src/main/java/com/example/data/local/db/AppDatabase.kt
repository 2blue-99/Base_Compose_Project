package com.example.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lucky_lotto.data.local.dao.KeywordDao
import com.lucky_lotto.data.local.entity.KeywordEntity

@Database(
    entities = [KeywordEntity::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun keywordDao(): KeywordDao
}