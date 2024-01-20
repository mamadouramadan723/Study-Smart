package com.rmd.business.studysmart.presentation.ui.dashboard.section

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.rmd.business.studysmart.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardTopAppBar() {
    CenterAlignedTopAppBar(title = {
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.headlineMedium
        )
    })
}