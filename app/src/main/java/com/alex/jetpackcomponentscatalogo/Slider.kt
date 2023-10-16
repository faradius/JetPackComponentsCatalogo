package com.alex.jetpackcomponentscatalogo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.RangeSlider
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BasicSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by remember {
            mutableStateOf(0f)
        }
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
        Text(text = sliderPosition.toString())
    }

}

@Composable
fun AdvanceSlider() {
    Column(Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by remember {
            mutableStateOf(0f)
        }
        var completeValue by remember {
            mutableStateOf("")
        }
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            onValueChangeFinished = {completeValue = sliderPosition.toString()},
            valueRange = 0f..10f,
            steps = 9,
            enabled = true
        )
        Text(text = completeValue)
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyRangeSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        var currentStartRange by rememberSaveable { mutableStateOf(0f) }
        var currentEndRange by rememberSaveable { mutableStateOf(10f) }
        var currentRange by remember { mutableStateOf(currentStartRange..currentEndRange) }

        RangeSlider(
            values = currentRange,
            onValueChange = {
                currentStartRange = it.start
                currentEndRange = it.endInclusive
                currentRange = it
            },
        )

        Text(text = "Valor Inferior ${currentRange.start}")
        Text(text = "Valor Superior ${currentRange.endInclusive}")
    }


}

