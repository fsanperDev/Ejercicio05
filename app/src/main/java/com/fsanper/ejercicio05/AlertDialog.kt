package com.fsanper.ejercicio05

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "P1",
    showBackground = true, fontScale = 1.1f, showSystemUi = true, apiLevel = 33,
    device = Devices.NEXUS_6
)
@Composable
fun MyAlertDialog() {
    val openDialog = rememberSaveable {
        mutableStateOf(true)
    }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            icon = {Icon(Icons.Filled.Favorite, contentDescription = null)},
            title = { Text(text = "Title") },
            text = { Text(text = "My text ...") },
            confirmButton = {
                TextButton(onClick = { openDialog.value = false }) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = { openDialog.value = false }) {
                    Text(text = "Dismiss")
                }
            }
        )
    }

}