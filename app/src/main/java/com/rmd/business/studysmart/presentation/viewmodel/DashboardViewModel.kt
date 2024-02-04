package com.rmd.business.studysmart.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.rmd.business.studysmart.domain.repository.SubjectRepository
import com.rmd.business.studysmart.presentation.state.DashboardState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
        private val subjectRepository: SubjectRepository
) :
    ViewModel() {
    private val _state = MutableStateFlow(DashboardState())
}