package com.example.learningassistant.interfaceResources.groupRowResources

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

interface ViewComponent {
    @Composable
    fun Show()
}

class ImageHolder(
    private val modifier: Modifier,
    private val shape: Shape = RoundedCornerShape(15.dp),
    private val image: Int
):
    ViewComponent
{
    @Composable
    override fun Show() {
        Surface(
            modifier = modifier,
            shape = shape
        ) {
            Image(painter = painterResource(id = image), contentDescription = null)
        }
    }
}

class TextInfoHolder(
    private val modifier: Modifier
)
    : ViewComponent
{

    private val contentList = mutableStateListOf<@Composable () -> Unit>()

    @Composable
    override fun Show() {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        )
        {
            for (content in contentList) {
                content()
            }
        }
    }

    fun addContent(newContent: @Composable () -> Unit) {
        contentList.add(newContent)
    }
}

interface RecursiveViewHolder: ViewComponent
{
    fun addContent(newContent: @Composable () -> Unit)
    @Composable
    override fun Show()
}


class ColumnRecursiveViewHolder(private val modifier: Modifier)
    : RecursiveViewHolder
{
    private val contentList = mutableStateListOf<@Composable () -> Unit>()

    @Composable
    override fun Show() {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            for (content in contentList)
            {
                content()
            }
        }
    }

    override fun addContent(newContent: @Composable () -> Unit) {
        contentList.add(newContent)
    }


}

class RowRecursiveViewHolder(private val modifier: Modifier) : RecursiveViewHolder {
    private val contentList = mutableStateListOf<@Composable () -> Unit>()

    @Composable
    override fun Show() {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            for (content in contentList) {
                content()
            }
        }
    }

    override fun addContent(newContent: @Composable () -> Unit) {
        contentList.add(newContent)
    }
}