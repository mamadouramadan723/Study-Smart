package com.rmd.business.studysmart.data.repository

import com.rmd.business.studysmart.data.datasource.local.dao.SessionDao
import com.rmd.business.studysmart.domain.model.Session
import com.rmd.business.studysmart.domain.repository.SessionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SessionRepositoryImpl @Inject constructor(
        private val sessionDao: SessionDao
) : SessionRepository {

    override suspend fun insertSession(session: Session) {
        sessionDao.insertSession(session)
    }

    override suspend fun deleteSession(session: Session) {
        TODO("Not yet implemented")
    }

    override fun getAllSessions(): Flow<List<Session>> {
        TODO("Not yet implemented")
    }

    override fun getRecentFiveSessions(): Flow<List<Session>> {
        TODO("Not yet implemented")
    }

    override fun getRecentTenSessionsForSubject(subjectId: Int): Flow<List<Session>> {
        TODO("Not yet implemented")
    }

    override fun getTotalSessionsDuration(): Flow<Long> {
        TODO("Not yet implemented")
    }

    override fun getTotalSessionsDurationBySubject(subjectId: Int): Flow<Long> {
        TODO("Not yet implemented")
    }
}