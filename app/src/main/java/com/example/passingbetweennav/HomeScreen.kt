package com.example.passingbetweennav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun FirstScreen(navController: NavController){

    var nameValue  by remember{ mutableStateOf("")}
    var ageValue  by remember{ mutableStateOf("")}

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {

        TextField(
            value = nameValue,
            onValueChange ={ nameValue = it },
            modifier = Modifier.padding(bottom = 10.dp),
            placeholder = { Text(text = "Enter your name")}
        )
        TextField(
            value = ageValue,
            onValueChange ={ ageValue = it },
            modifier = Modifier.padding(bottom = 10.dp),
            placeholder = { Text(text = "Enter your age")}
        )
        Button(onClick = {
            navController.navigate("bscreen?name=$nameValue&age=$ageValue")
        }) {
            Text(text = "Pass")
        }
    }
}