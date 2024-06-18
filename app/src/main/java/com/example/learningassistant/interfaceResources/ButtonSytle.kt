package com.example.learningassistant.interfaceResources

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

// Sealed class to represent different button styles (you can add more)

data class ColorsOfButton(
    val borderColor: Color,
    val contentColor: Color,
)

// Builder class for creating Button instances
class ButtonBuilder() {
    private var onClick: () -> Unit = {}
    private var modifier: Modifier = Modifier
    private var enabled: Boolean = true
    private var colors: ColorsOfButton = ColorsOfButton(Color.White, Color.Black)
    private var interactionSource: MutableInteractionSource = MutableInteractionSource() // No remember here  private var shape: Shape = RoundedCornerShape(4.dp)
    private var shape: Shape = RoundedCornerShape(4.dp) // Default
    private var border: BorderStroke? = null
    private var contentPadding: PaddingValues = ButtonDefaults.ContentPadding
    private var style: Style = Style.FILLED

    fun onClick(onClick: () -> Unit) = apply { this.onClick = onClick }
    fun modifier(modifier: Modifier) = apply { this.modifier = modifier }
    fun enabled(enabled: Boolean) = apply { this.enabled = enabled }
    fun colors(colors: ColorsOfButton) = apply { this.colors = colors }
    fun interactionSource(interactionSource: MutableInteractionSource) = apply { this.interactionSource = interactionSource }
    fun shape(shape: Shape): ButtonBuilder { // Explicitly return ButtonBuilder
        this.shape = shape
        return this
    }
    fun style(style: Style) = apply { this.style = style }
    fun border(border: BorderStroke?) = apply { this.border = border }
    fun contentPadding(contentPadding: PaddingValues) = apply { this.contentPadding = contentPadding }


    // Optional constructor
    constructor(
        onClick: () -> Unit = {},
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        colors: ColorsOfButton = ColorsOfButton(Color.White, Color.Black),
        interactionSource: MutableInteractionSource = MutableInteractionSource(),
        shape: Shape = RoundedCornerShape(4.dp),
        border: BorderStroke? = null,
        contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    ) : this() {
        this.onClick = onClick
        this.modifier = modifier
        this.enabled = enabled
        this.colors = colors
        this.interactionSource = interactionSource
        this.shape = shape
        this.border = border
        this.contentPadding = contentPadding
    }

    @Composable
    fun Build(content: @Composable () -> Unit) {
        val resolvedColors = ButtonDefaults.buttonColors(colors.borderColor, colors.contentColor, colors.borderColor, colors.contentColor)
        val finalModifier = modifier
            .then(
                when (style) {
                    Style.FILLED -> Modifier.background(colors.borderColor)
                    Style.UNFILLED -> Modifier.background(Color.White) // No background for outlined style
                    // Handle other styles as needed
                }
            )
            .clickable(
                onClick = onClick,
                enabled = enabled,
                interactionSource = interactionSource,
                indication = null // You might want to customize this
            )



        Button(
            onClick = onClick,
            modifier = finalModifier,
            enabled = enabled,
            colors = resolvedColors, // Use the resolved ButtonColors
            interactionSource = interactionSource,
            shape = shape,
            border = border,
            contentPadding = contentPadding
        ) {
            content()
        }
    }
}