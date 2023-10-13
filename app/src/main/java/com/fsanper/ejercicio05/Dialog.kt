package com.fsanper.ejercicio05

import android.app.Dialog
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Preview(
    name = "P1",
    showBackground = true,
    fontScale = 1.1f,
    showSystemUi = true,
    apiLevel = 33,
    device = Devices.NEXUS_6
)
@Composable
fun DialogExample() {
    var openMinimalDialog by rememberSaveable { mutableStateOf(false) }
    var openDialogwithImage by rememberSaveable { mutableStateOf(false) }
    var openDialogCustom by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Click en los botones para ver los ejemplos de Dialog")

        Button(onClick = { openMinimalDialog = !openMinimalDialog }) {
            Text(text = "Dialog mínimo")
        }
        when {
            openMinimalDialog -> {
                MinimalDialog(
                    onDismissRequest = { openMinimalDialog = false }
                )
            }
        }

        Button(onClick = { openDialogwithImage = !openDialogwithImage }) {
            Text(text = "Dialog con una imagen")
        }
        when {
            openDialogwithImage -> {
                DialogWithImage(
                    onDismissRequest = { openDialogwithImage = false },
                    onConfirmation = { openDialogwithImage = false },
                    painter = painterResource(id = R.drawable.mount),
                    imageDescription = stringResource(id = R.string.mount)
                )
            }
        }

        Button(onClick = { openDialogCustom = !openDialogCustom }) {
            Text(text = "Dialog con una imagen")
        }
        when {
            openDialogwithImage -> {

            }
        }
    }
}

@Composable
fun MinimalDialog(onDismissRequest: () -> Unit) {
    Dialog(onDismissRequest = { onDismissRequest }) {
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp)
        ) {
            Text(
                text = "This is a minimal dialog",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        }
    }
}

@Composable
fun DialogWithImage(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    painter: Painter,
    imageDescription: String
) {
    Dialog(onDismissRequest = { onDismissRequest }) {
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(375.dp)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painter,
                    contentDescription = imageDescription,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.height(160.dp)
                )
                Text(text = "This is a dialog with buttons and an imagen", modifier = Modifier.padding(16.dp))
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextButton(onClick = { onDismissRequest },modifier= Modifier.padding(8.dp)) {
                        Text(text = "cancel")
                    }
                    TextButton(onClick = { onConfirmation },modifier= Modifier.padding(8.dp)) {
                        Text(text = "confirm")
                    }

                }
            }
        }
    }
}