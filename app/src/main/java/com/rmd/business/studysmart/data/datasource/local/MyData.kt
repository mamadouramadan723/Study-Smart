package com.rmd.business.studysmart.data.datasource.local

import androidx.compose.ui.graphics.toArgb
import com.rmd.business.studysmart.domain.model.Session
import com.rmd.business.studysmart.domain.model.Subject
import com.rmd.business.studysmart.domain.model.Task

fun MyData() {

}

val subjects = listOf(
    Subject(
        name = "English",
        goalHours = 10f,
        colors = Subject.subjectCardColors[0].map { it.toArgb() },
        subjectId = 0
    ),
    Subject(
        name = "Physics",
        goalHours = 10f,
        colors = Subject.subjectCardColors[1].map { it.toArgb() },
        subjectId = 0
    ),
    Subject(
        name = "Maths",
        goalHours = 10f,
        colors = Subject.subjectCardColors[2].map { it.toArgb() },
        subjectId = 0
    ),
    Subject(
        name = "Geology",
        goalHours = 10f,
        colors = Subject.subjectCardColors[3].map { it.toArgb() },
        subjectId = 0
    ),
    Subject(
        name = "Fine Arts",
        goalHours = 10f,
        colors = Subject.subjectCardColors[4].map { it.toArgb() },
        subjectId = 0
    ),
)
val tasks = listOf(
    Task(
        title = "Prepare notes",
        description = "",
        dueDate = 0L,
        priority = 0,
        relatedToSubject = "",
        isComplete = false,
        taskSubjectId = 0,
        taskId = 1
    ),
    Task(
        title = "Do Homework",
        description = "",
        dueDate = 0L,
        priority = 1,
        relatedToSubject = "",
        isComplete = true,
        taskSubjectId = 0,
        taskId = 1
    ),
    Task(
        title = "Go Coaching",
        description = "",
        dueDate = 0L,
        priority = 2,
        relatedToSubject = "",
        isComplete = false,
        taskSubjectId = 0,
        taskId = 1
    ),
    Task(
        title = "Assignment",
        description = "",
        dueDate = 0L,
        priority = 1,
        relatedToSubject = "",
        isComplete = false,
        taskSubjectId = 0,
        taskId = 1
    ),
    Task(
        title = "Write Poem",
        description = "",
        dueDate = 0L,
        priority = 0,
        relatedToSubject = "",
        isComplete = true,
        taskSubjectId = 0,
        taskId = 1
    )
)
val sessions = listOf(
    Session(
        relatedToSubject = "English",
        date = 0L,
        duration = 2,
        sessionSubjectId = 0,
        sessionId = 0
    ),
    Session(
        relatedToSubject = "English",
        date = 0L,
        duration = 2,
        sessionSubjectId = 0,
        sessionId = 0
    ),
    Session(
        relatedToSubject = "Physics",
        date = 0L,
        duration = 2,
        sessionSubjectId = 0,
        sessionId = 0
    ),
    Session(
        relatedToSubject = "Maths",
        date = 0L,
        duration = 2,
        sessionSubjectId = 0,
        sessionId = 0
    ),
    Session(
        relatedToSubject = "English",
        date = 0L,
        duration = 2,
        sessionSubjectId = 0,
        sessionId = 0
    )
)