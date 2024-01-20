package com.rmd.business.studysmart.presentation.route

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.rmd.business.studysmart.presentation.ui.dashboard.DashboardScreen

@Destination(start = true)
@Composable
fun DashboardScreenRoute(
        navigator: DestinationsNavigator
) {
    DashboardScreen(
        onSubjectCardClick = {},
        onTaskCardClick = {},
        onStartSessionButtonClick = {}
    )
}