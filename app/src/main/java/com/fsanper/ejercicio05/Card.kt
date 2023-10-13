package com.fsanper.ejercicio05

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(
    name = "P1",
    showBackground = true, fontScale = 1.1f, showSystemUi = true, apiLevel = 33,
    device = Devices.NEXUS_6
)
@Composable
fun CardMinimal() {
    Card() {
        Text(text = "Mi tarjeta")
    }
}

@Composable
fun OutlinedCardExample(){
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        OutlinedCard(
            //colors = CardDefaults.cardColors(containerColor = Color.Green),
            border = BorderStroke(1.dp, Color.Red),
            modifier = Modifier.size(width = 240.dp, height = 100.dp)) {
            Text(text = "Mi relleno.....",
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center)

        }
    }
}

@Composable
fun FilledCardExample() {
    Row(
        modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Card(modifier = Modifier.size(width = 240.dp, height = 100.dp)) {
            Text(text = "Mi relleno.....",
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center)

        }
    }
}


@Composable
fun ElevatedCardExample() {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            modifier = Modifier.size(width = 240.dp, height = 100.dp)) {
            Text(text = "Mi relleno.....",
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center)

        }
    }
}