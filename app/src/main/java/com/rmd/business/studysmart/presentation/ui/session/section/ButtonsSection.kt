package com.rmd.business.studysmart.presentation.ui.session.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rmd.business.studysmart.presentation.theme.Red
import com.rmd.business.studysmart.presentation.utils.TimerState

@Composable
fun ButtonsSection(
        modifier: Modifier,
        startButtonClick: () -> Unit,
        cancelButtonClick: () -> Unit,
        finishButtonClick: () -> Unit,
        timerState: TimerState,
        seconds: String
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = cancelButtonClick,
            enabled = seconds != "00" && timerState != TimerState.STARTED
        ) {
            Text(
                modifier = Modifier.padding(
                    horizontal = 10.dp,
                    vertical = 5.dp
                ),
                text = "Cancel"
            )
        }
        Button(
            onClick = startButtonClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = if (timerState == TimerState.STARTED) Red
                else MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            )
        ) {
            Text(
                modifier = Modifier.padding(
                    horizontal = 10.dp,
                    vertical = 5.dp
                ),
                text = when (timerState) {
                    TimerState.STARTED -> "Stop"
                    TimerState.STOPPED -> "Resume"
                    else -> "Start"
                }
            )
        }
        Button(
            onClick = finishButtonClick,
            enabled = seconds != "00" && timerState != TimerState.STARTED
        ) {
            Text(
                modifier = Modifier.padding(
                    horizontal = 10.dp,
                    vertical = 5.dp
                ),
                text = "Finish"
            )
        }
    }
}