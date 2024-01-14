package com.rmd.business.studysmart.presentation.ui.dashboard.section

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rmd.business.studysmart.presentation.component.CountCardComponent

@Composable
fun CountCardSection(
        modifier: Modifier,
        subjectCount: Int,
        studiedHours: String,
        goalHours: String
) {
    Row(modifier = modifier) {
        CountCardComponent(
            modifier = Modifier.weight(1f),
            headingText = "Subject Count",
            count = "$subjectCount"
        )
        Spacer(modifier = Modifier.width(10.dp))
        CountCardComponent(
            modifier = Modifier.weight(1f),
            headingText = "Studied Hours",
            count = studiedHours
        )
        Spacer(modifier = Modifier.width(10.dp))
        CountCardComponent(
            modifier = Modifier.weight(1f),
            headingText = "Goal Study Hours",
            count = goalHours
        )
        /*Spacer(modifier = Modifier.width(10.dp))
        CountCardComponent(
            modifier = Modifier.weight(1f),
            headingText = "Other Hours",
            count = goalHours
        )*/
    }
}