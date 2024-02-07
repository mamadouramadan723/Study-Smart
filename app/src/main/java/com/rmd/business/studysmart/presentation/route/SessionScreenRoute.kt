package com.rmd.business.studysmart.presentation.route

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.DeepLink
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.rmd.business.studysmart.presentation.service.StudySessionTimerService
import com.rmd.business.studysmart.presentation.ui.session.SessionScreen
import com.rmd.business.studysmart.presentation.viewmodel.SessionViewModel

@Destination(
    deepLinks = [
        DeepLink(
            action = Intent.ACTION_VIEW,
            uriPattern = "study_smart://dashboard/session"
        )
    ]
)

@Composable
fun SessionScreenRoute(
        navigator: DestinationsNavigator,
        timerService: StudySessionTimerService
) {
    val viewModel: SessionViewModel = hiltViewModel()

    SessionScreen(
        onBackButtonClick = { navigator.navigateUp() },
        timerService = timerService
    )
}