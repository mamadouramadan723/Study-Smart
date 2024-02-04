package com.rmd.business.studysmart.data.repository

import com.rmd.business.studysmart.data.datasource.local.dao.SessionDao
import com.rmd.business.studysmart.data.datasource.local.dao.SubjectDao
import com.rmd.business.studysmart.data.datasource.local.dao.TaskDao
import com.rmd.business.studysmart.domain.model.Subject
import com.rmd.business.studysmart.domain.repository.SubjectRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SubjectRepositoryImpl @Inject constructor(
        private val subjectDao: SubjectDao,
        private val taskDao: TaskDao,
        private val sessionDao: SessionDao
) : SubjectRepository {

    override suspend fun upsertSubject(subject: Subject) {
        subjectDao.upsertSubject(subject)
    }

    override fun getTotalSubjectCount(): Flow<Int> {
        return subjectDao.getTotalSubjectCount()
    }

    override fun getTotalGoalHours(): Flow<Float> {
        return subjectDao.getTotalGoalHours()
    }

    override suspend fun deleteSubject(subjectId: Int) {
        taskDao.deleteTasksBySubjectId(subjectId)
        sessionDao.deleteSessionsBySubjectId(subjectId)
        subjectDao.deleteSubject(subjectId)
    }

    override suspend fun getSubjectById(subjectId: Int): Subject? {
        return subjectDao.getSubjectById(subjectId)
    }

    override fun getAllSubjects(): Flow<List<Subject>> {
        return subjectDao.getAllSubjects()
    }
}