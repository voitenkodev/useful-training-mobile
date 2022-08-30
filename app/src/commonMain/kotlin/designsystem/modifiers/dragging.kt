package designsystem.modifiers

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.round

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
fun Modifier.dragging(): Modifier = composed {
    val offset = remember { mutableStateOf(Offset.Zero) }
    Modifier
        .absoluteOffset(
            offset = { offset.value.round() }
        )
        .pointerInput(Unit) {
            detectDragGesturesAfterLongPress { _, dragAmount ->
                offset.value = offset.value + dragAmount
            }
        }
}