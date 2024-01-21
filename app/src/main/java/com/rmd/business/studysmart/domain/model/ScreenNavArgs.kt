package com.rmd.business.studysmart.domain.model

data class ScreenNavArgs(
        val subjectId: Int
)

data class TaskScreenNavArgs(
        val taskId: Int?,
        val subjectId: Int?
)

