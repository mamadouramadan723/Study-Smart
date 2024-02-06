package com.rmd.business.studysmart.presentation.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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
    val state by viewModel.state.collectAsStateWithLifecycle()
    TaskScreen(
        state = state,
        snackbarEvent = viewModel.snackbarEventFlow,
        onEvent = viewModel::onEvent,
        onBackButtonClick = { navigator.navigateUp() }
    )
}