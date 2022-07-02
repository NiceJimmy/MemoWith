package com.myapp.memowith.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.myapp.memowith.data.model.AlarmListItem

@Database(version = 1, entities = [AlarmListItem::class])

abstract class AppDataBase : RoomDatabase() {

    companion object{
        private var INSTANCE: AppDataBase? = null
        fun getInstance(context: Context): AppDataBase{
            if(INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppDataBase::class.java,
                    "memo_with_database").build()
            }
            return INSTANCE as AppDataBase
        }

    }
}