package platform

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import atomic.DesignComponent
import kotlin.math.min

@Composable
actual fun BackHandler(action: () -> Unit) {
    val triggerBackPressDragDistance = 40f
    val dragDistance = remember { mutableStateOf(0f) }
    val state = rememberDraggableState { dragDistance.value = min(dragDistance.value + it, triggerBackPressDragDistance * 2) }

    Box(
        modifier = Modifier.fillMaxHeight().widthIn(min = 20.dp)
            .draggable(state = state, orientation = Orientation.Horizontal, onDragStopped = {
                if (dragDistance.value > triggerBackPressDragDistance) {
                    action.invoke()
                    dragDistance.value = 0f
                }
            }), contentAlignment = Alignment.CenterStart
    ) {

        AnimatedVisibility(visible = dragDistance.value > triggerBackPressDragDistance,
            enter = slideInHorizontally(initialOffsetX = { -it }, animationSpec = tween(durationMillis = 100)),
            exit = slideOutHorizontally(targetOffsetX = { -it }),
            content = {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp),
                    tint = DesignComponent.colors.content,
                )
            }
        )
    }
}