package com.rmd.business.studysmart.data.repository

import com.rmd.business.studysmart.data.datasource.local.dao.SubjectDao
import com.rmd.business.studysmart.domain.model.Subject
import com.rmd.business.studysmart.domain.repository.SubjectRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SessionRepositoryImpl @Inject constructor(
        private val subjectDao: SubjectDao
) : SubjectRepository {

    override suspend fun upsertSubject(subject: Subject) {
        subjectDao.upsertSubject(subject)
    }

    override fun getTotalSubjectCount(): Flow<Int> {
        TODO("Not yet implemented")
    }

    override fun getTotalGoalHours(): Flow<Float> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteSubject(subjectInt: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun getSubjectById(subjectInt: Int): Subject? {
        TODO("Not yet implemented")
    }

    override fun getAllSubjects(): Flow<List<Subject>> {
        TODO("Not yet implemented")
    }
}