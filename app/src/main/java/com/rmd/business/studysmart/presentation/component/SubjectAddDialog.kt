package com.rmd.business.studysmart.presentation.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

@Composable
fun SubjectAddDialog(
        isOpen: Boolean,
        title: String = "Add/Update Subject",
        selectedColors: List<Color>,
        subjectName: String,
        goalHours: String,
        onColorChange: (List<Color>) -> Unit,
        onSubjectNameChange: (String) -> Unit,
        onGoalHoursChange: (String) -> Unit,
        onDismissRequest: () -> Unit,
        onConfirmButtonClick: () -> Unit
) {
    var subjectNameError by rememberSaveable { mutableStateOf<String?>(null) }
    var goalHoursError by rememberSaveable { mutableStateOf<String?>(null) }

    subjectNameError = when {
        subjectName.isBlank() -> "Please enter subject name."
        subjectName.length < 2 -> "Subject name is too short."
        subjectName.length > 20 -> "Subject name is too long."
        else -> null
    }
    goalHoursError = when {
        goalHours.isBlank() -> "Please enter goal study hours."
        goalHours.toFloatOrNull() == null -> "Invalid number."
        goalHours.toFloat() < 1f -> "Please set at least 1 hour."
        goalHours.toFloat() > 1000f -> "Please set a maximum of 1000 hours."
        else -> null
    }

    if (isOpen) {
        AlertDialog(
            onDismissRequest = onDismissRequest,
            title = { Text(text = title) },
            text = {
                AddDialogBox(
                    subjectNameError = subjectNameError,
                    goalHoursError = goalHoursError,
                    selectedColors = selectedColors,
                    subjectName = subjectName,
                    goalHours = goalHours,
                    onColorChange = onColorChange,
                    onSubjectNameChange = onSubjectNameChange,
                    onGoalHoursChange = onGoalHoursChange
                )
            },
            dismissButton = {
                TextButton(onClick = onDismissRequest) {
                    Text(text = "Cancel")
                }
            },
            confirmButton = {
                TextButton(
                    onClick = onConfirmButtonClick,
                    enabled = subjectNameError == null && goalHoursError == null
                ) {
                    Text(text = "Save")
                }
            }
        )
    }
}