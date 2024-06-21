package com.example.learningassistant.learningPageFragments.learningPageResource.learningPageRows

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

class GroupRowBuilder {
    private val viewComponentList = mutableListOf<ViewComponent>()
    private var recursiveViewHolder: RecursiveViewHolder? = null
    private var textInfoHolder: TextInfoHolder? = null

    @Composable
    fun Show() {
        for (viewComponent in viewComponentList) {
            viewComponent.Show()
        }
    }

    fun addImage(modifier: Modifier, image: Int): GroupRowBuilder {
        val viewComponent = ImageHolder(modifier, image)
        viewComponentList.add(viewComponent)
        return this
    }

    fun withText(modifier: Modifier, content: @Composable () -> Unit): GroupRowBuilder {
        if (textInfoHolder == null) textInfoHolder = TextInfoHolder(modifier)
        textInfoHolder!!.addContent {
            content()
        }
        return this
    }

    fun addText(): GroupRowBuilder {
        textInfoHolder?.let { viewComponentList.add(it) }
        textInfoHolder = null
        return this
    }

    fun withColumnViewHolder(modifier: Modifier, content: @Composable () -> Unit): GroupRowBuilder {
        if (recursiveViewHolder == null) recursiveViewHolder = ColumnRecursiveViewHolder(modifier)
        (recursiveViewHolder as ColumnRecursiveViewHolder).addContent {
            content()
        }
        return this
    }

    fun withRowViewHolder(modifier: Modifier, content: @Composable () -> Unit): GroupRowBuilder {
        if (recursiveViewHolder == null)recursiveViewHolder = RowRecursiveViewHolder(modifier)
        (recursiveViewHolder as RowRecursiveViewHolder).addContent {
            content()
        }
        return this
    }

    fun addRecursiveViewHolder(): GroupRowBuilder {
        recursiveViewHolder?.let {
            viewComponentList.add(it)
            // Don't reset recursiveViewHolder here
        }
        return this
    }
}