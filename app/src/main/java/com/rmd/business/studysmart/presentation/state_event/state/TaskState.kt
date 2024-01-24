package com.rmd.business.studysmart.presentation.state_event.state

import com.rmd.business.studysmart.domain.model.Subject
import com.rmd.business.studysmart.presentation.utils.Priority

data class TaskState(
        val title: String = "",
        val description: String = "",
        val dueDate: Long? = null,
        val isTaskComplete: Boolean = false,
        val priority: Priority = Priority.LOW,
        val relatedToSubject: String? = null,
        val subjects: List<Subject> = emptyList(),
        val subjectId: Int? = null,
        val currentTaskId: Int? = null
)