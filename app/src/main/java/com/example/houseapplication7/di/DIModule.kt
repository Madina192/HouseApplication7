package com.example.houseapplication7.di

import android.content.Context
import androidx.room.Room
import com.example.houseapplication7.data.db.HouseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DIModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context) {
        Room.databaseBuilder(
            context = context,
            klass = HouseDatabase::class.java,
            "house_database"
        ).build()
    }

    @Provides
    fun provideCameraDao(roomDatabase : HouseDatabase){
        roomDatabase.getCameraDao()
    }

    @Provides
    fun provideDoorDao(roomDatabase : HouseDatabase){
        roomDatabase.getDoorDao()
    }
}