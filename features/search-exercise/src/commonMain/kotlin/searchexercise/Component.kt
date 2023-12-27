package searchexercise

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

@Composable
public fun SearchExerciseComponent(content: @Composable () -> Unit): Unit = CompositionLocalProvider(
    LocalSearchExerciseController provides SearchExerciseApi(),
    content = content
)

public object SearchExerciseController {
    public val api: SearchExerciseApi
        @Composable
        get() = LocalSearchExerciseController.current
}

public data class SearchExerciseApi(
    private val _exerciseExampleId: Channel<String> = Channel(Channel.BUFFERED),
    val exerciseExampleId: Flow<String> = _exerciseExampleId.receiveAsFlow(),
) {

    public fun itemClick(id: String) {
        _exerciseExampleId.trySend(id)
    }
}

private val LocalSearchExerciseController =
    staticCompositionLocalOf<SearchExerciseApi> { error("No SearchExerciseComponent provided") }
