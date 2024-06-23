package com.example.learningassistant.interfaceResources.buttonHierarchy

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

interface BasicButton {

    @Composable
    fun Show(content: @Composable () -> Unit)

}

enum class Style {
    FILLED,
    UNFILLED
}

abstract class ClassicButton(
    colors: ColorsOfButton,
    borderSize: Int,
    height: Dp,
    roundedShape: Dp,
    padding: Dp
)
    : BasicButton
{

    abstract val style: Style;

    protected var buttonObject = ButtonBuilder(
        onClick = {},
        border = BorderStroke(borderSize.dp, colors.borderColor),
        colors = colors,
        shape = RoundedCornerShape(roundedShape),
        modifier = Modifier
            .height(height)
            .padding(padding),
    )

    @Composable
    override fun Show(content: @Composable () -> Unit) {

        buttonObject.Build {
            content()
        }
    }

    fun setOnClick(onClick: () -> Unit) {
        buttonObject.onClick(onClick)
    }

}




class FilledButton(
    private val colors: ColorsOfButton,
    borderSize: Int,
    height: Dp,
    roundedShape: Dp,
    padding: Dp
): ClassicButton(colors, borderSize, height, roundedShape, padding)
{
    override val style: Style
        get() = Style.FILLED

    @Composable
    override fun Show(content: @Composable () -> Unit) {
        buttonObject.style(style)
        buttonObject.colors(colors)
        super.Show{
            content()
        }
    }
}


class UnfilledButton(
    private val colors: ColorsOfButton,
    borderSize: Int,
    height: Dp,
    roundedShape: Dp,
    padding: Dp
): ClassicButton(colors, borderSize, height, roundedShape, padding)
{
    override val style: Style
        get() = Style.UNFILLED

    @Composable
    override fun Show(content: @Composable () -> Unit) {
        buttonObject.style(style)
        buttonObject.colors(colors)
        super.Show{
            content()
        }
    }
}

