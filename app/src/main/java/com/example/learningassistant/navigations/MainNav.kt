package com.example.learningassistant.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainNav(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "HomePage"){
        composable(route = "LearningPage"){
            LearningPageNav(navController)
        }
        composable(route = "HomePage"){
            HomePageNav(navController)
        }
        composable(route = "WishListPage"){
            WishListPageNav(navController)
        }
        composable(route = "AccountPage"){
            AccountPageNav(navController)
        }
    }
}