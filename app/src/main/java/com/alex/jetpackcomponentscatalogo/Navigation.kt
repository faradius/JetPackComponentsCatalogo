package com.alex.jetpackcomponentscatalogo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.alex.jetpackcomponentscatalogo.model.Routes

@Composable
fun Screen1(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ){
        Text(text = "Pantalla 1", modifier = Modifier.align(Alignment.Center).clickable { navigationController.navigate(Routes.Pantalla2.route) })
    }
}

@Composable
fun Screen2(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ){
        Text(text = "Pantalla 2", modifier = Modifier.align(Alignment.Center).clickable { navigationController.navigate(Routes.Pantalla3.route) })
    }
}

@Composable
fun Screen3(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)
    ){
        Text(text = "Pantalla 3", modifier = Modifier.align(Alignment.Center).clickable { navigationController.navigate("pantalla4/2") })
    }
}

@Composable
fun Screen4(navigationController: NavHostController, name:Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ){
        Text(text = name.toString(), modifier = Modifier.align(Alignment.Center))
    }
}