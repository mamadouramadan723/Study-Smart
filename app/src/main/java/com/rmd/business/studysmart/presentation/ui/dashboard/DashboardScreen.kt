package com.rmd.business.studysmart.presentation.ui.dashboard

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rmd.business.studysmart.domain.model.Session
import com.rmd.business.studysmart.domain.model.Task
import com.rmd.business.studysmart.presentation.component.DialogAdd
import com.rmd.business.studysmart.presentation.component.DialogDelete
import com.rmd.business.studysmart.presentation.component.TasksList
import com.rmd.business.studysmart.presentation.event.DashboardEvent
import com.rmd.business.studysmart.presentation.event.SnackbarEvent
import com.rmd.business.studysmart.presentation.state.DashboardState
import com.rmd.business.studysmart.presentation.ui.dashboard.section.CountCardSection
import com.rmd.business.studysmart.presentation.ui.dashboard.section.DashboardTopAppBar
import com.rmd.business.studysmart.presentation.ui.dashboard.section.StudySessionsSection
import com.rmd.business.studysmart.presentation.ui.dashboard.section.SubjectCardSection
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest

@Composable
fun DashboardScreen(
        state: DashboardState,
        tasks: List<Task>,
        recentSessions: List<Session>,
        onEvent: (DashboardEvent) -> Unit,
        snackbarEvent: SharedFlow<SnackbarEvent>,
        onSubjectCardClick: (Int?) -> Unit,
        onTaskCardClick: (Int?) -> Unit,
        onStartSessionButtonClick: () -> Unit
) {
    var isAddSubjectDialogOpen by rememberSaveable { mutableStateOf(false) }
    var isDeleteSessionDialogOpen by rememberSaveable { mutableStateOf(false) }

    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = true) {
        snackbarEvent.collectLatest { event ->
            when (event) {
                is SnackbarEvent.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(
                        message = event.message,
                        duration = event.duration
                    )
                }

                SnackbarEvent.NavigateUp -> {}
            }
        }
    }

    DialogAdd(
        isOpen = isAddSubjectDialogOpen,
        subjectName = state.subjectName,
        goalHours = state.goalStudyHours,
        selectedColors = state.subjectCardColors,
        onColorChange = { onEvent(DashboardEvent.OnSubjectCardColorChange(it)) },
        onSubjectNameChange = { onEvent(DashboardEvent.OnSubjectNameChange(it)) },
        onGoalHoursChange = { onEvent(DashboardEvent.OnGoalStudyHoursChange(it)) },
        onDismissRequest = { isAddSubjectDialogOpen = false },
        onConfirmButtonClick = {
            onEvent(DashboardEvent.SaveSubject)
            isAddSubjectDialogOpen = false
        })

    DialogDelete(isOpen = isDeleteSessionDialogOpen,
        title = "Delete Session?",
        bodyText = "Are you sure, you want to delete this session? Your studied hours will be reduced " + "by this session time. This action can not be undone.",
        onDismissRequest = { isDeleteSessionDialogOpen = false },
        onConfirmButtonClick = {
            onEvent(DashboardEvent.DeleteSession)
            isDeleteSessionDialogOpen = false
        })

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        topBar = { DashboardTopAppBar() }) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize()
                .padding(padding)
        ) {

            item {
                CountCardSection(
                    modifier = Modifier.fillMaxWidth()
                        .padding(12.dp),
                    subjectCount = state.totalSubjectCount,
                    goalHours = state.totalGoalStudyHours.toString(),
                    studiedHours = state.totalStudiedHours.toString()
                )
            }
            item {
                SubjectCardSection(
                    modifier = Modifier.fillMaxWidth(),
                    subjectList = state.subjects,
                    onAddIconClicked = { isAddSubjectDialogOpen = true },
                    onSubjectCardClick = onSubjectCardClick
                )
            }
            item {
                Button(
                    onClick = onStartSessionButtonClick,
                    modifier = Modifier.fillMaxWidth()
                        .padding(
                            horizontal = 48.dp,
                            vertical = 20.dp
                        )
                ) {
                    Text(text = "Start Study Session")
                }
            }
            TasksList(
                sectionTitle = "UPCOMING TASKS",
                emptyListText = "You don't have any upcoming tasks.\n " + "Click the + button in subject screen to add new task.",
                tasks = tasks,
                onCheckBoxClick = { onEvent(DashboardEvent.OnTaskIsCompleteChange(it)) },
                onTaskCardClick = onTaskCardClick
            )
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
            StudySessionsSection(sectionTitle = "RECENT STUDY SESSIONS",
                emptyListText = "You don't have any recent study sessions.\n " + "Start a study session to begin recording your progress.",
                sessions = recentSessions,
                onDeleteIconClick = {
                    onEvent(DashboardEvent.OnDeleteSessionButtonClick(it))
                    isDeleteSessionDialogOpen = true
                })
        }
    }
}



