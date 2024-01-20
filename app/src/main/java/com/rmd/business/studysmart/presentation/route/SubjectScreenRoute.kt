package com.rmd.business.studysmart.presentation.route

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.rmd.business.studysmart.domain.model.SubjectScreenNavArgs
import com.rmd.business.studysmart.presentation.ui.subject.SubjectScreen

@Destination(navArgsDelegate = SubjectScreenNavArgs::class)
@Composable
fun SubjectScreenRoute(
        navigator: DestinationsNavigator
) {
    SubjectScreen(onBackButtonClick = { navigator.navigateUp() },
        onAddTaskButtonClick = {},
        onTaskCardClick = {})
}