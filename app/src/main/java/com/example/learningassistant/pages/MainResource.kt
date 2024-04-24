package com.example.learningassistant.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.learningassistant.BottomBar
import com.example.learningassistant.learningPageFragments.learningPageResource.TextIconVertical
import com.example.learningassistant.ui.theme.containerColor
import com.example.learningassistant.ui.theme.detailColor
import com.example.learningassistant.ui.theme.fontSizeMainHeader
import com.example.learningassistant.ui.theme.fontSizeMini
import com.example.mylearningasistant4.InterfaceCreator

private val interfaceCreator = InterfaceCreator()

class InterfaceCreator{

    @Composable
    fun MainInterface(
        navControllerHost: NavController,
        pageNumber: Int,
        bottomBar: @Composable () -> Unit = {},
        topBar: @Composable () -> Unit = {},
        operation: @Composable () -> Unit
    ) {
        Surface(color = Color.Unspecified, modifier = Modifier.fillMaxHeight()) {
            Scaffold(
                containerColor = Color.Unspecified,
                bottomBar = bottomBar,
                topBar = topBar
            ){
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 0.dp, 0.dp, 0.dp)
                ) {
                    it.calculateTopPadding()
                    operation()
                }
            }
        }
    }
}


@Composable
fun PageInterfaceClassic(
    navControllerHost: NavController,
    pageNumber: Int,
    operation: @Composable () -> Unit
){
    interfaceCreator.MainInterface(navControllerHost = navControllerHost, pageNumber = pageNumber,
        bottomBar = { BottomBar(navController = navControllerHost, page = pageNumber) })
    {
        operation()
    }
}


@Composable
fun UnfilledButton(borderColor: Color, borderSize: Int, context: String, contextColor: Color, height: Dp, roundedShape: Dp, padding: Int) {
    Button(
        onClick = {},
        border = BorderStroke(borderSize.dp, borderColor),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = contextColor
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.height(height).padding(padding.dp)
    ) {
        Text(text = context, fontSize = fontSizeMini)
    }
}

@Composable
fun FilledButton(borderColor: Color, borderSize: Int, context: String, contextColor: Color, height: Dp, roundedShape: Dp, padding: Int) {

    Button(
        onClick = {},
        border = BorderStroke(borderSize.dp, borderColor),
        colors = ButtonDefaults.buttonColors(
            containerColor = contextColor,
            contentColor = contextColor
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.height(height).padding(padding.dp)
    )
    {
        Text(text = context, fontSize = fontSizeMini, color = Color.White)
    }
}

@Composable
fun TopicText(text: String, padding: Int){
    Text(text = text,
        fontSize = fontSizeMainHeader,
        modifier = Modifier.padding(padding.dp),
        fontWeight = FontWeight.W700)
}

@Composable
fun DetailText(text: String, padding: Int){
    Text(text = text,
        fontSize = 22.sp,
        modifier = Modifier.padding(padding.dp),
        fontWeight = FontWeight.W700,
        color = detailColor)
}


class TopBarCreator(val navControllerHost: NavController, val height: Dp,
                    private val verticalAlignment: Alignment.Vertical,
                    private val horizontalArrangement: Arrangement.Horizontal,
                    private val modifier: Modifier){
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun TopAppBarDefault(navController: NavController,
                                 height: Dp,
                                 barRow: @Composable () -> Unit = {})
    {
        TopAppBar(
            title = {},
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.White,
                titleContentColor = Color.Unspecified,
                scrolledContainerColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(height),
            actions = {
                Surface(
                    modifier = modifier,
                    color = containerColor
                ) {
                    Row(
                        verticalAlignment = verticalAlignment,
                        horizontalArrangement = horizontalArrangement
                    ) {
                        barRow()
                    }
                }
            }
        )
    }

    @Composable
    fun TopBarClassic(imageId: Int, imageWidth: Int, imageHeight: Int,
                      title: String,
                      iconId: Int, iconSize: Int,){
        TopAppBarDefault(navController = navControllerHost, height = height, barRow = {

            Image(
                modifier = Modifier
                    .width(imageWidth.dp)
                    .height(imageHeight.dp)
                    .padding(10.dp, 0.dp, 0.dp, 0.dp),
                painter = painterResource(id = imageId),
                contentDescription = null
            )
            Text(text = title)
            TextIconVertical(
                size = iconSize,
                padding = 5,
                address = iconId,
                iconColor = Color.Unspecified,
                backgroundColor = Color.White,
                navController = navControllerHost,
                nextPage = "",
                title = ""
            )
        })
    }
    @Composable
    fun TopBarClassic(title: String,
                      iconId: Int,
                      iconSize: Int){
        TopAppBarDefault(navController = navControllerHost, height = height, barRow = {
            Text(text = title)
            TextIconVertical(
                size = iconSize,
                padding = 5,
                address = iconId,
                iconColor = Color.Unspecified,
                backgroundColor = Color.White,
                navController = navControllerHost,
                nextPage = "",
                title = ""
            )
        })
    }


}