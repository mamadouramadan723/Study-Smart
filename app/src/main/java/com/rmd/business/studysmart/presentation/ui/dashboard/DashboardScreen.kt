package com.rmd.business.studysmart.presentation.ui.dashboard

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rmd.business.studysmart.data.datasource.local.sessions
import com.rmd.business.studysmart.data.datasource.local.subjects
import com.rmd.business.studysmart.data.datasource.local.tasks
import com.rmd.business.studysmart.domain.model.Subject
import com.rmd.business.studysmart.presentation.component.DialogAdd
import com.rmd.business.studysmart.presentation.component.DialogDelete
import com.rmd.business.studysmart.presentation.ui.dashboard.section.CountCardSection
import com.rmd.business.studysmart.presentation.ui.dashboard.section.DashboardTopAppBar
import com.rmd.business.studysmart.presentation.ui.dashboard.section.StudySessionsSection
import com.rmd.business.studysmart.presentation.ui.dashboard.section.SubjectCardSection
import com.rmd.business.studysmart.presentation.ui.dashboard.section.TasksListSection

@Composable
fun DashboardScreen(

) {
    var isAddSubjectDialogOpen by rememberSaveable { mutableStateOf(false) }
    var isDeleteSessionDialogOpen by rememberSaveable { mutableStateOf(false) }
    var subjectName by remember { mutableStateOf("") }
    var goalHours by remember { mutableStateOf("") }
    var selectedColor by remember { mutableStateOf(Subject.subjectCardColors.random()) }

    DialogAdd(
        isOpen = isAddSubjectDialogOpen,
        subjectName = subjectName,
        goalHours = goalHours,
        onSubjectNameChange = { subjectName = it },
        onGoalHoursChange = { goalHours = it },
        selectedColors = selectedColor,
        onColorChange = { selectedColor = it },
        onDismissRequest = { isAddSubjectDialogOpen = false },
        onConfirmButtonClick = {
            isAddSubjectDialogOpen = false
        })

    DialogDelete(
        isOpen = isDeleteSessionDialogOpen,
        title = "Delete Session?",
        bodyText = "Are you sure, you want to delete this session? Your studied hours will be reduced " + "by this session time. This action can not be undone.",
        onDismissRequest = { isDeleteSessionDialogOpen = false },
        onConfirmButtonClick = { isDeleteSessionDialogOpen = false })

    Scaffold(topBar = { DashboardTopAppBar() }) { padding ->
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
                    onAddIconClicked = { isAddSubjectDialogOpen = true },
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
            TasksListSection(sectionTitle = "UPCOMING TASKS",
                emptyListText = "You don't have any upcoming tasks.\n " + "Click the + button in subject screen to add new task.",
                tasks = tasks,
                onCheckBoxClick = {},
                onTaskCardClick = {})
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
            StudySessionsSection(sectionTitle = "RECENT STUDY SESSIONS",
                emptyListText = "You don't have any recent study sessions.\n " + "Start a study session to begin recording your progress.",
                sessions = sessions,
                onDeleteIconClick = { isDeleteSessionDialogOpen = true })
        }
    }
}



