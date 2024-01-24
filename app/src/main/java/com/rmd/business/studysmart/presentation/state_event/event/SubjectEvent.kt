package com.rmd.business.studysmart.presentation.state_event.event

import androidx.compose.ui.graphics.Color
import com.rmd.business.studysmart.domain.model.Session
import com.rmd.business.studysmart.domain.model.Task

sealed class SubjectEvent {
    data object UpdateSubject : SubjectEvent()
    data object DeleteSubject : SubjectEvent()
    data object DeleteSession : SubjectEvent()
    data object UpdateProgress : SubjectEvent()
    data class OnTaskIsCompleteChange(val task: Task) : SubjectEvent()
    data class OnSubjectCardColorChange(val color: List<Color>) : SubjectEvent()
    data class OnSubjectNameChange(val name: String) : SubjectEvent()
    data class OnGoalStudyHoursChange(val hours: String) : SubjectEvent()
    data class OnDeleteSessionButtonClick(val session: Session) : SubjectEvent()
}