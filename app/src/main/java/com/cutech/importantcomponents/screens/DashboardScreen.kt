package com.cutech.importantcomponents.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DashboardScreen(
    onClick: () -> Unit,
    showToast: () -> Unit
) {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Row {
            Button(onClick = onClick) {
                Text(text = "Home Screen")
            }

            Spacer(modifier = Modifier.padding(horizontal = 5.dp))

            Button(onClick = showToast) {
                Text(text = "Show toast message")
            }
        }
    }
}