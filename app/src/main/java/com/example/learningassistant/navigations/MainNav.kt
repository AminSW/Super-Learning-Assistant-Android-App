package com.example.learningassistant.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learningassistant.videoPlayer.videoplayer1.VideoPlayerActivity

@Composable
fun MainNav(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home Page"){
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
        composable(route = "VideoPlayer"){
            VideoPlayerActivity()
        }
    }
}