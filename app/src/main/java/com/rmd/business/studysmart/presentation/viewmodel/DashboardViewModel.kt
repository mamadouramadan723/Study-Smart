package com.rmd.business.studysmart.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.rmd.business.studysmart.domain.repository.SubjectRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
        private val subjectRepository: SubjectRepository
) : ViewModel()