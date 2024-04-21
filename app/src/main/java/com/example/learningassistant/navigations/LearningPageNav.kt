@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.learningassistant.navigations

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learningassistant.learningPageFragments.learningPages.CourseGroup
import com.example.learningassistant.learningPageFragments.learningPages.PrivateGroup
import com.example.learningassistant.learningPageFragments.learningPages.PublicGroup

@Composable
fun LearningPageNav(navControllerHost: NavController){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Course"){
        composable(route = "Course"){
            CourseGroup(navController, navControllerHost)
        }
        composable(route = "Private"){
            PrivateGroup(navController, navControllerHost)
        }
        composable(route = "Public"){
            PublicGroup(navController, navControllerHost)
        }
    }
}