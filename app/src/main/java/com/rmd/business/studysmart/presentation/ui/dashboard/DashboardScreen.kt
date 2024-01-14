package com.rmd.business.studysmart.presentation.ui.dashboard

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rmd.business.studysmart.presentation.ui.dashboard.section.CountCardSection
import com.rmd.business.studysmart.presentation.ui.dashboard.section.SubjectCardSection
import com.rmd.business.studysmart.presentation.ui.dashboard.section.TasksListSection
import com.rmd.business.studysmart.presentation.ui.dashboard.section.TopAppBar
import com.rmd.business.studysmart.subjects
import com.rmd.business.studysmart.tasks

@Composable
fun DashboardScreen(

) {

    Scaffold(topBar = { TopAppBar() }) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize()
                .padding(padding)
        ) {

            item {
                CountCardSection(
                    modifier = Modifier.fillMaxWidth()
                        .padding(12.dp),
                    subjectCount = 5,
                    studiedHours = "10",
                    goalHours = "15"
                )
            }
            item {
                SubjectCardSection(modifier = Modifier.fillMaxWidth(),
                    subjectList = subjects,
                    onAddIconClicked = {},
                    onSubjectCardClick = {})
            }
            item {
                Button(
                    onClick = { /*onStartSessionButtonClick*/ },
                    modifier = Modifier.fillMaxWidth()
                        .padding(
                            horizontal = 48.dp,
                            vertical = 20.dp
                        )
                ) {
                    Text(text = "Start Study Session")
                }
            }
            TasksListSection(
                sectionTitle = "UPCOMING TASKS",
                emptyListText = "You don't have any upcoming tasks.\n " +
                        "Click the + button in subject screen to add new task.",
                tasks = tasks,
                onCheckBoxClick = {},
                onTaskCardClick = {}
            )

        }
    }
}



