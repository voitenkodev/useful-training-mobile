package controls

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import DesignComponent

@Composable
fun Modifier.secondaryBackground() = this
    .background(
        color = DesignComponent.colors.secondary,
        shape = DesignComponent.shape.default
    )
    .clip(shape = DesignComponent.shape.default)
