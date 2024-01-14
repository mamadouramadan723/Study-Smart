package com.rmd.business.studysmart.presentation.ui.dashboard

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rmd.business.studysmart.domain.model.Subject
import com.rmd.business.studysmart.presentation.ui.dashboard.section.CountCardSection
import com.rmd.business.studysmart.presentation.ui.dashboard.section.SubjectCardSection
import com.rmd.business.studysmart.presentation.ui.dashboard.section.TopAppBar

@Preview
@Composable
fun DashboardScreen() {

    val subjects = listOf(
        Subject(
            name = "English",
            goalHours = 10f,
            colors = Subject.subjectCardColors[0],
            1
        ),
        Subject(
            name = "English",
            goalHours = 10f,
            colors = Subject.subjectCardColors[1],
            2
        ),
        Subject(
            name = "English",
            goalHours = 10f,
            colors = Subject.subjectCardColors[2],
            3
        ),
        Subject(
            name = "English",
            goalHours = 10f,
            colors = Subject.subjectCardColors[0],
            4
        ),
        Subject(
            name = "English",
            goalHours = 10f,
            colors = Subject.subjectCardColors[1],
            5
        ),
        Subject(
            name = "English",
            goalHours = 10f,
            colors = Subject.subjectCardColors[2],
            6
        )
    )
    Scaffold(topBar = { TopAppBar() }) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize()
                .padding(padding)
        ) {

            item {
                CountCardSection(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    subjectCount = 5,
                    studiedHours = "10",
                    goalHours = "15"
                )
            }
            item {
                SubjectCardSection(
                    modifier = Modifier.fillMaxWidth(),
                    subjectList = subjects,
                    onAddIconClicked = {},
                    onSubjectCardClick = {}
                )
            }
        }
    }
}



