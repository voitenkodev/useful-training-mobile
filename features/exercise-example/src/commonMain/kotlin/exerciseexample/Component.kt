package exerciseexample

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

@Composable
public fun ExerciseExampleComponent(content: @Composable () -> Unit): Unit = CompositionLocalProvider(
    LocalExerciseExampleController provides ExerciseExampleApi(),
    content = content
)

public object ExerciseExampleController {
    public val api: ExerciseExampleApi
        @Composable
        get() = LocalExerciseExampleController.current
}

public data class ExerciseExampleApi(
    private val _exerciseExampleId: Channel<String> = Channel(Channel.BUFFERED),
    val exerciseExampleId: Flow<String> = _exerciseExampleId.receiveAsFlow(),
) {

    public fun primaryActionClick(id: String) {
        _exerciseExampleId.trySend(id)
    }
}

private val LocalExerciseExampleController =
    staticCompositionLocalOf<ExerciseExampleApi> { error("No ExerciseExampleComponent provided") }
