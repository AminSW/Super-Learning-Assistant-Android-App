package com.example.learningassistant.interfaceResources.iconHierarchy

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

class ClassicIcon(
    private val modifier: Modifier,
    private val address: Int,
    private val color: Color = Color.Black,
)
{
    @Composable
    fun Show()
    {
        Icon(
            modifier = modifier,
            painter = painterResource(id = address),
            contentDescription = null,
            tint = color
        )
    }
}

class IconWithButton(
    private val icon: ClassicIcon,
    private val modifier: Modifier,
    private val onClick: () -> Unit
){

    @Composable
    fun Show()
    {
        IconButton(onClick = { onClick() }, modifier = modifier)
        {
            icon.Show()
        }
    }
}