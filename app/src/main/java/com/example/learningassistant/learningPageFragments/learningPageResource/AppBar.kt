@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.learningassistant.learningPageFragments.learningPageResource

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.learningassistant.ui.theme.textUnitScheme

private val firstColor = Color.White
private val secondColor = Color.Unspecified
private val textColor = Color.Black



@Composable
fun AppTopBar(navController: NavController) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White,
            titleContentColor = Color.Unspecified,
            scrolledContainerColor = Color.White
        ),
        title = { SpecialMainText() }
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 60.dp, 0.dp, 30.dp),
        Arrangement.SpaceEvenly,
        Alignment.CenterVertically
    )
    {
        UpMenuBar(navController = navController)
    }
}
@Composable
fun UpMenuBar(navController: NavController){
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center)
    {
        SpecialMenuButton(title = "Course", navAddress = "Course", navController = navController)
        SpecialMenuButton(title = "Private", navAddress = "Private", navController = navController)
        SpecialMenuButton(title = "Public", navAddress = "Public", navController = navController)
    }

}

@Composable
fun SpecialMenuButton(title: String, navAddress: String, navController: NavController){

    Surface(modifier = Modifier)
    {
        Button(
            onClick =
            {
                navController.navigate(navAddress)
            },

            colors = buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black,
                disabledContainerColor = Color.White,
                disabledContentColor = Color.Black
            ),

            modifier = Modifier
                .width(130.dp)
                .background(Color.White)
        )
        {
            Text(title, fontSize = MaterialTheme.textUnitScheme.fontSizeHuge, fontWeight = FontWeight.W400)
        }
    }
}