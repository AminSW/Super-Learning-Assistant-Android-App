package com.example.learningassistant.learningPageFragments.learningPageResource

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.learningassistant.BottomBar
import com.example.learningassistant.interfaceResources.iconHierarchy.ClassicIcon
import com.example.learningassistant.interfaceResources.iconHierarchy.IconWithButton
import com.example.learningassistant.ui.theme.detailColor

val mainColor = Color(113,190,130)
val notNotificationColor = Color(181, 181, 181)

@Composable
fun TextIconVertical(size: Int, padding: Int, address: Int, iconColor: Color,
                     backgroundColor: Color,
                     navController: NavController?,
                     nextPage: String,
                     title: String) {
    var height = size
    if (title.isNotEmpty()) height += 50
    val icon = ClassicIcon(modifier = Modifier.size(30.dp), address = address, color = iconColor)
    Surface(modifier = Modifier
        .width(size.dp)
        .height(height.dp)
        .padding(padding.dp), color = backgroundColor) {
        Column {
            IconWithButton(
                icon = icon,
                modifier = Modifier.size(40.dp),
            )
            {
                navController?.navigate(nextPage)
            }.Show()
            Text(text = title, fontSize = 12.sp)
        }

    }
}
@Composable
fun TextIconHorizontal(width: Int, height: Int, padding: Int, address: Int, iconColor: Color,
                     backgroundColor: Color,
                     navController: NavController?,
                     nextPage: String,
                     title: String, fontSize: Int, fontWeight: FontWeight, color: Color) {
    Surface(modifier = Modifier
        .height(height.dp)
        .width(width.dp)
        .padding(padding.dp), color = backgroundColor) {
        Row {
            IconButton(onClick = { navController?.navigate(nextPage) }, modifier = Modifier.size(40.dp))
            {
                Icon(modifier = Modifier.size(30.dp),
                    painter = painterResource(id = address),
                    contentDescription = null,
                    tint = iconColor,)
            }
            Text(text = title, fontSize = fontSize.sp, fontWeight = fontWeight, color = color)
        }

    }
}

@Composable
fun SpecialMainText() {
    Surface(color = Color.White) {
        Text(text = "My Learning Groups", textAlign = TextAlign.Center)
    }
}

@Composable
fun LinearProgressBar(totalTask: Int, completedTask: Int){
    val progress = (completedTask.toFloat()/totalTask)
    Column(Modifier.padding(5.dp, 0.dp, 0.dp, 0.dp)) {
        Row {
            Text(text = "$completedTask",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = detailColor)
            Text(text = "/$totalTask",
                fontSize = 15.sp,
                modifier = Modifier.width(60.dp),
                fontWeight = FontWeight.SemiBold)

            Spacer(modifier = Modifier.padding(80.dp, 0.dp, 0.dp, 0.dp))

            Text(text = (progress*100).toInt().toString()+"%",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.width(60.dp),
                textAlign = TextAlign.End)
        }

        Surface {
            LinearProgressIndicator(
                progress =  progress ,
                Modifier
                    .width(215.dp)
                    .size(10.dp),
                color = mainColor
            )
        }
    }
}

@Composable
fun PageInterfaceForLearningPages(
    navController: NavController,
    navControllerHost: NavController,
    pageNumber: Int,
    operation: @Composable () -> Unit
){
    Surface(color = Color.Blue) {
        Scaffold(topBar = { AppTopBar(navController = navController) },
            bottomBar = { BottomBar(navController = navControllerHost, page = pageNumber) })
        {
            Surface(modifier = Modifier
                .fillMaxSize()
                .padding(0.dp, 70.dp, 0.dp, 0.dp)
            )
            {
                it.hashCode()
                operation()
            }
        }
    }
}

