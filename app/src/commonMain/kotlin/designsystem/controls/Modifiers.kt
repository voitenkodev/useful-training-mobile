package designsystem.controls

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import designsystem.atomic.DesignComponent

@Composable
fun Modifier.secondaryBackground() = this
    .background(
        color = DesignComponent.colors.secondary,
        shape = DesignComponent.shape.default
    )
    .clip(shape = DesignComponent.shape.default)
//    .padding(DesignComponent.size.space)