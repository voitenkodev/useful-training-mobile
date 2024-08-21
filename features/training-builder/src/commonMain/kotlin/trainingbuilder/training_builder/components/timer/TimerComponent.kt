package trainingbuilder.training_builder.components.timer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable

@Composable
internal fun TimerComponent(
    initialMillis: Long,
    content: @Composable (time: String) -> Unit
) {

    val scope = rememberCoroutineScope()
    val timerStateHolder = remember(initialMillis) { Timer(scope, initialMillis) }
    val initial = rememberSaveable { mutableLongStateOf(0) }

    val hours = remember(initial.longValue) {
        if (initialMillis == 0L) 0 else timerStateHolder.leftHours(initial.longValue)
    }
    val minutes = remember(initial.longValue) {
        if (initialMillis == 0L) 0 else timerStateHolder.leftMinutes(initial.longValue)
    }
    val seconds = remember(initial.longValue) {
        if (initialMillis == 0L) 0 else timerStateHolder.leftSeconds(initial.longValue)
    }

    LaunchedEffect(Unit) { timerStateHolder.startTimer { initial.longValue = it } }
    DisposableEffect(Unit) { onDispose { timerStateHolder.stopTimer() } }

    content.invoke("$hours:$minutes:$seconds")
}