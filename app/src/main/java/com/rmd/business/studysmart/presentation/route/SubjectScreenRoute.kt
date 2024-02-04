package com.rmd.business.studysmart.presentation.route

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.rmd.business.studysmart.domain.model.SubjectScreenNavArgs
import com.rmd.business.studysmart.domain.model.TaskScreenNavArgs
import com.rmd.business.studysmart.presentation.route.destinations.TaskScreenRouteDestination
import com.rmd.business.studysmart.presentation.ui.subject.SubjectScreen
import com.rmd.business.studysmart.presentation.viewmodel.SubjectViewModel

@Destination(navArgsDelegate = SubjectScreenNavArgs::class)
@Composable
fun SubjectScreenRoute(
        navigator: DestinationsNavigator
) {
    val viewModel: SubjectViewModel = hiltViewModel()

    SubjectScreen(
        onBackButtonClick = { navigator.navigateUp() },
        onAddTaskButtonClick = {
            val navArg = TaskScreenNavArgs(
                taskId = null,
                subjectId = -1
            )
            navigator.navigate(TaskScreenRouteDestination(navArgs = navArg))
        },
        onTaskCardClick = { taskId ->
            val navArg = TaskScreenNavArgs(
                taskId = taskId,
                subjectId = null
            )
            navigator.navigate(TaskScreenRouteDestination(navArgs = navArg))
        }
    )
}