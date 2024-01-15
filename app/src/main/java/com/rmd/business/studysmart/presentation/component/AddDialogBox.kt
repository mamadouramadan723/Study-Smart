package com.rmd.business.studysmart.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.rmd.business.studysmart.domain.model.Subject

@Composable
fun AddDialogBox(
        subjectNameError: String?,
        goalHoursError: String?,
        selectedColors: List<Color>,
        subjectName: String,
        goalHours: String,
        onColorChange: (List<Color>) -> Unit,
        onSubjectNameChange: (String) -> Unit,
        onGoalHoursChange: (String) -> Unit
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Subject.subjectCardColors.forEach { colors ->
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .border(
                            width = 1.dp,
                            color = if (colors == selectedColors) Color.Black
                            else Color.Transparent,
                            shape = CircleShape
                        )
                        .background(brush = Brush.verticalGradient(colors))
                        .clickable { onColorChange(colors) }
                )
            }
        }
        OutlinedTextField(
            value = subjectName,
            onValueChange = onSubjectNameChange,
            label = { Text(text = "Subject Name") },
            singleLine = true,
            isError = subjectNameError != null && subjectName.isNotBlank(),
            supportingText = { Text(text = subjectNameError.orEmpty()) }
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = goalHours,
            onValueChange = onGoalHoursChange,
            label = { Text(text = "Goal Study Hours") },
            singleLine = true,
            isError = goalHoursError != null && goalHours.isNotBlank(),
            supportingText = { Text(text = goalHoursError.orEmpty()) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}