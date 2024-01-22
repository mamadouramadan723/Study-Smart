package com.rmd.business.studysmart.domain.model

data class SubjectScreenNavArgs(
        val subjectId: Int
)

data class TaskScreenNavArgs(
        val taskId: Int?,
        val subjectId: Int?
)

