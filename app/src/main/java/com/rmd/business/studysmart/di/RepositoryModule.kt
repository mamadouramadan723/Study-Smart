package com.rmd.business.studysmart.di

import com.rmd.business.studysmart.data.repository.SessionRepositoryImpl
import com.rmd.business.studysmart.data.repository.SubjectRepositoryImpl
import com.rmd.business.studysmart.data.repository.TaskRepositoryImpl
import com.rmd.business.studysmart.domain.repository.SessionRepository
import com.rmd.business.studysmart.domain.repository.SubjectRepository
import com.rmd.business.studysmart.domain.repository.TaskRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindSubjectRepository(
            impl: SubjectRepositoryImpl
    ): SubjectRepository

    @Singleton
    @Binds
    abstract fun bindTaskRepository(
            impl: TaskRepositoryImpl
    ): TaskRepository

    @Singleton
    @Binds
    abstract fun bindSessionRepository(
            impl: SessionRepositoryImpl
    ): SessionRepository
}