package com.rmd.business.studysmart.presentation.route

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.rmd.business.studysmart.presentation.ui.session.SessionScreen
import com.rmd.business.studysmart.presentation.viewmodel.SessionViewModel

@Destination
@Composable
fun SessionScreenRoute(
        navigator: DestinationsNavigator
) {
    val viewModel: SessionViewModel = hiltViewModel()

    SessionScreen(onBackButtonClick = { navigator.navigateUp() })
}