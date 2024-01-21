package com.rmd.business.studysmart.presentation.route

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.rmd.business.studysmart.presentation.ui.session.SessionScreen

@Destination
@Composable
fun SessionScreenRoute(
        navigator: DestinationsNavigator
) {
    SessionScreen(onBackButtonClick = { navigator.navigateUp() })
}
