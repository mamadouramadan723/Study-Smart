package com.rmd.business.studysmart.data.datasource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.rmd.business.studysmart.data.datasource.local.dao.SessionDao
import com.rmd.business.studysmart.data.datasource.local.dao.SubjectDao
import com.rmd.business.studysmart.data.datasource.local.dao.TaskDao
import com.rmd.business.studysmart.domain.model.Session
import com.rmd.business.studysmart.domain.model.Subject
import com.rmd.business.studysmart.domain.model.Task

@Database(
    entities = [Subject::class, Session::class, Task::class],
    version = 1
)
@TypeConverters(ColorListConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun subjectDao(): SubjectDao
    abstract fun taskDao(): TaskDao
    abstract fun sessionDao(): SessionDao
}