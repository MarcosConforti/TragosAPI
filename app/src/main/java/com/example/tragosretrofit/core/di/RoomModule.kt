package com.example.tragosretrofit.core.di

import android.content.Context
import androidx.room.Room
import com.example.tragosretrofit.data.database.DrinkDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DRINK_DATABASE_NAME = "DRINK_DATABASE"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context): DrinkDataBase {

        return Room.databaseBuilder(context,DrinkDataBase::class.java, DRINK_DATABASE_NAME).build()
    }
    @Singleton
    @Provides
    fun provideDrinkDao(db: DrinkDataBase) = db.getDrinkDao()
}