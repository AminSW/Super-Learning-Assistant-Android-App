package com.example.learningassistant

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.learningassistant.learningPageFragments.learningPageResource.TextIconVertical

private var icon1Id = R.drawable.home_empty
private var icon2Id = R.drawable.learning_empty
private var icon3Id = R.drawable.wishlist_empty
private var icon4Id = R.drawable.user_empty

@Composable
fun BottomBar(navController: NavController, page: Int) {
    Surface(modifier = Modifier
        .height(100.dp)
        .padding(0.dp, 10.dp, 0.dp, 0.dp),
        color = Color.White,
        shadowElevation = 2.dp
    ) {
        BottomAppBar(
            containerColor = Color.White
        ){
            Row(modifier = Modifier
                .fillMaxWidth(),
                Arrangement.SpaceEvenly,
                Alignment.CenterVertically)
            {
                IconBar(navController = navController, page = page) }
        }
    }
}

@Composable
fun IconBar(navController: NavController, page: Int){
    ReViewIconsBar(iconNum = page)
    Icons(navController = navController)
}

@Composable
fun Icons(navController: NavController){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(0.dp, 10.dp, 0.dp, 20.dp),horizontalArrangement = Arrangement.SpaceEvenly) {
        BBStandartIcon(address = icon1Id, navController = navController, nextPage = "HomePage", title = "Home")
        BBStandartIcon(address = icon2Id, navController = navController, nextPage = "LearningPage", title = "Learn")
        BBStandartIcon(address = icon3Id, navController = navController, nextPage = "WishListPage", title = "WishList")
        BBStandartIcon(address = icon4Id, navController = navController, nextPage = "AccountPage", title = "Account")
    }
}

@Composable
fun BBStandartIcon(address: Int, navController: NavController, nextPage: String, title: String){
    val size = 50
    val padding = 0   
    val iconColor = Color.Unspecified
    val backgroundColor = Color.White
    TextIconVertical(
        size = size,
        padding = padding,
        address = address,
        iconColor = iconColor,
        backgroundColor = backgroundColor,
        navController, nextPage, title
    )
}

@Composable
fun RestartIconsBar(){
    icon1Id = R.drawable.home_empty
    icon2Id = R.drawable.learning_empty
    icon3Id = R.drawable.wishlist_empty
    icon4Id = R.drawable.user_empty
}

@Composable
fun ReViewIconsBar(iconNum: Int){
    RestartIconsBar()
    when (iconNum) {
        1 -> icon1Id = R.drawable.home_filled
        2 -> icon2Id = R.drawable.learning_filled
        3 -> icon3Id = R.drawable.wishlist_filled
        4 -> icon4Id = R.drawable.user_filled
    }
}