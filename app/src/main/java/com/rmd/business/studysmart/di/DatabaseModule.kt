package com.rmd.business.studysmart.di

import android.app.Application
import androidx.room.Room
import com.rmd.business.studysmart.data.datasource.local.dao.SessionDao
import com.rmd.business.studysmart.data.datasource.local.dao.SubjectDao
import com.rmd.business.studysmart.data.datasource.local.dao.TaskDao
import com.rmd.business.studysmart.data.datasource.local.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    
    @Provides
    @Singleton
    fun provideDatabase(
            application: Application
    ): AppDatabase {
        return Room
            .databaseBuilder(
                application,
                AppDatabase::class.java,
                "studysmart.db"
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideSubjectDao(database: AppDatabase): SubjectDao {
        return database.subjectDao()
    }

    @Provides
    @Singleton
    fun provideTaskDaoDao(database: AppDatabase): TaskDao {
        return database.taskDao()
    }

    @Provides
    @Singleton
    fun provideSessionDao(database: AppDatabase): SessionDao {
        return database.sessionDao()
    }
}