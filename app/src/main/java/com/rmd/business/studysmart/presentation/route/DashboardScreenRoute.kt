package com.rmd.business.studysmart.presentation.route

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.rmd.business.studysmart.domain.model.SubjectScreenNavArgs
import com.rmd.business.studysmart.domain.model.TaskScreenNavArgs
import com.rmd.business.studysmart.presentation.route.destinations.SessionScreenRouteDestination
import com.rmd.business.studysmart.presentation.route.destinations.SubjectScreenRouteDestination
import com.rmd.business.studysmart.presentation.route.destinations.TaskScreenRouteDestination
import com.rmd.business.studysmart.presentation.ui.dashboard.DashboardScreen

@Destination(start = true)
@Composable
fun DashboardScreenRoute(
        navigator: DestinationsNavigator
) {
    DashboardScreen(onSubjectCardClick = { subjectId ->
        subjectId?.let {
            val navArg = SubjectScreenNavArgs(subjectId = subjectId)
            navigator.navigate(SubjectScreenRouteDestination(navArgs = navArg))
        }
    },
        onTaskCardClick = { taskId ->
            val navArg = TaskScreenNavArgs(
                taskId = taskId,
                subjectId = null
            )
            navigator.navigate(TaskScreenRouteDestination(navArgs = navArg))
        },
        onStartSessionButtonClick = {
            navigator.navigate(SessionScreenRouteDestination())
        })
}