package com.example.learningassistant.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learningassistant.views.HomePage

@Composable
fun HomePageNav(navControllerHost: NavController){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Main"){
        composable(route = "Main"){
            HomePage(navController, navControllerHost)
        }
    }
}