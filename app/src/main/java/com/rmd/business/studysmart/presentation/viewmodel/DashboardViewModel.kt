package com.rmd.business.studysmart.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.rmd.business.studysmart.domain.repository.SessionRepository
import com.rmd.business.studysmart.domain.repository.SubjectRepository
import com.rmd.business.studysmart.domain.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
        private val subjectRepository: SubjectRepository,
        private val sessionRepository: SessionRepository,
        private val taskRepository: TaskRepository
) : ViewModel()