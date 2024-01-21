package com.rmd.business.studysmart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.rmd.business.studysmart.presentation.theme.StudySmartTheme
import com.rmd.business.studysmart.presentation.ui.task.TaskScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StudySmartTheme {
                //DashboardScreen()
                /*SubjectScreen(
                    onBackButtonClick = {},
                    onAddTaskButtonClick = {},
                    onTaskCardClick = {}
                )*/
                TaskScreen(
                    onBackButtonClick = {}
                )

                //SessionScreen(onBackButtonClick = {})
            }
        }
    }
}