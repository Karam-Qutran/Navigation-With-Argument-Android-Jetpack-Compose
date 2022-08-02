package com.example.passingbetweennav

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Nava() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home" ){

        composable(route = "home"){
            FirstScreen(navController = navController)
        }
        composable(
            route = "bscreen?name={name}&age={age}",
            arguments = listOf(
                navArgument("name"){
                    defaultValue = "user"
                },
                navArgument("age"){
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ) { backStackEntre ->
            SecondScreen(
                name = backStackEntre.arguments?.getString("name"),
                age =  backStackEntre.arguments?.getInt("age").toString()
            )
        }
    }
}