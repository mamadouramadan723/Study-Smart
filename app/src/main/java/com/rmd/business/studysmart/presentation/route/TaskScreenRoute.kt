package com.rmd.business.studysmart.presentation.route

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.rmd.business.studysmart.domain.model.TaskScreenNavArgs
import com.rmd.business.studysmart.presentation.ui.task.TaskScreen

@Destination(navArgsDelegate = TaskScreenNavArgs::class)
@Composable
fun TaskScreenRoute(
        navigator: DestinationsNavigator
) {
    TaskScreen(
        onBackButtonClick = { navigator.navigateUp() }
    )
}