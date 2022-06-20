package com.example.wbinternw8part3.model.room

import androidx.room.Room
import com.example.wbinternw8part3.app.App

object FavoriteDataBaseFactory {
    private val dataBase: FavoriteDataBase by lazy {
        Room.databaseBuilder(App.ContextHolder.context, FavoriteDataBase::class.java, "favorite.db")
            .build()
    }

    fun create(): FavoriteDataBase = dataBase
}