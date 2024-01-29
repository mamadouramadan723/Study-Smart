package com.rmd.business.studysmart.presentation.event

import androidx.compose.material3.SnackbarDuration

sealed class SnackbarEvent {
    data class ShowSnackbar(
            val message: String,
            val duration: SnackbarDuration = SnackbarDuration.Short
    ) : SnackbarEvent()

    data object NavigateUp : SnackbarEvent()
}