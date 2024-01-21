package com.rmd.business.studysmart.presentation.route

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.rmd.business.studysmart.domain.model.ScreenNavArgs
import com.rmd.business.studysmart.presentation.ui.subject.SubjectScreen

@Destination(navArgsDelegate = ScreenNavArgs::class)
@Composable
fun SubjectScreenRoute(
        navigator: DestinationsNavigator
) {
    SubjectScreen(onBackButtonClick = { navigator.navigateUp() },
        onAddTaskButtonClick = {},
        onTaskCardClick = {})
}