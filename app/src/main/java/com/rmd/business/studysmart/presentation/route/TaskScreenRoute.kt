package com.rmd.business.studysmart.presentation.route

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.rmd.business.studysmart.domain.model.TaskScreenNavArgs
import com.rmd.business.studysmart.presentation.ui.task.TaskScreen
import com.rmd.business.studysmart.presentation.viewmodel.TaskViewModel

@Destination(navArgsDelegate = TaskScreenNavArgs::class)
@Composable
fun TaskScreenRoute(
        navigator: DestinationsNavigator
) {
    val viewModel: TaskViewModel = hiltViewModel()
    TaskScreen(
        onBackButtonClick = { navigator.navigateUp() }
    )
}