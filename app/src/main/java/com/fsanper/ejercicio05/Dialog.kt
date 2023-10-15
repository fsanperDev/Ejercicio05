package com.fsanper.ejercicio05

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Preview(
    name = "P1",
    showSystemUi = true,
    showBackground = true,
    fontScale = 1.1f,
    apiLevel = 33,
    device = Devices.NEXUS_6
)

@Composable
fun DialogExamples(){
    var openMinimalDialog = rememberSaveable() {
        mutableStateOf(false)
    }
    var openDialogWithImage = rememberSaveable() {
        mutableStateOf(false)
    }
    var openDialogCustom = rememberSaveable() {
        mutableStateOf(false)
    }

    Column (
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(text = "Click en los botones para ver los ejemplos de dialog")
        Button(onClick = { openMinimalDialog.value = !openMinimalDialog.value }) {
            Text(text = "Dialog mínimo")
        }
        Button(onClick = { openDialogWithImage.value = !openDialogWithImage.value }) {
            Text(text = "Dialog con una imagen")
        }
        Button(onClick = { openDialogCustom.value = !openDialogCustom.value }) {
            Text(text = "Dialog custom")
        }

        when{
            openMinimalDialog.value -> {
                MinimalDialog(
                    onDimissRequest = {openMinimalDialog.value = false}
                )
            }
            openDialogWithImage.value -> {
                DialogWithImage(
                    onDimissRequest = {openDialogWithImage.value = false},
                    onConfirmation = {openDialogWithImage.value = false},
                    painter = painterResource(id = R.drawable.mount),
                    imageDescription = stringResource(id = R.string.mount)
                )
            }

            openDialogCustom.value -> {
                MyCustomDialog(true) { openDialogCustom.value = false }
            }
        }
    }
}

@Composable
fun MyCustomDialog(show: Boolean, onDimissRequest: () -> Unit) {
    if (show){
        Dialog(onDismissRequest = { onDimissRequest() }) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()) {
                MytittleDialog("Set backup account")
                AccountItem(email = "ejemplo1@email.com", drawable = R.drawable.ac1)
                AccountItem(email = "ejemplo2@email.com", drawable = R.drawable.ac2)
                AccountItem(email = "ejemplo3@email.com", drawable = R.drawable.ac3)
                AccountItem(email = "Añadir nueva cuenta", drawable = R.drawable.add)
            }
        }
    }
}

@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int){
    Row (verticalAlignment = Alignment.CenterVertically){
        Image(painter = painterResource(id = drawable),
            contentDescription = "Avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape))
        Text(
            text = email,
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(8.dp)
        )
    }
}
@Composable
fun MytittleDialog(text: String,) {
    Text(text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = Modifier.padding(bottom = 12.dp)
    )
}

@Composable
fun DialogWithImage(
    onDimissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    painter: Painter,
    imageDescription: String
) {
    Dialog(onDismissRequest = { onDimissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(375.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ){
            Column( modifier = Modifier
                .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,) {
                Image(
                    painter = painter,
                    contentDescription = imageDescription,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(160.dp)
                )
                Text(
                    text = "This is a dialog with buttons and an image.",
                    modifier = Modifier.padding(16.dp),
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    TextButton(
                        onClick = { onDimissRequest() },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text("Dismiss")
                    }
                    TextButton(
                        onClick = { onConfirmation() },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text("Confirm")
                    }
                }
            }
        }
    }
}

@Composable
fun MinimalDialog(onDimissRequest: () -> Unit) {
    Dialog(onDismissRequest = { onDimissRequest() }) {
        Card (
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp)
        ){
            Text(text = "This is a minimal dialog",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center))
        }
    }
}