package searchexercise

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

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
    private var _exerciseExampleId: String? = null
) {

    val exerciseExampleId: String? get() = _exerciseExampleId

    public fun itemClick(id: String) {
        _exerciseExampleId = id
    }
}

private val LocalSearchExerciseController =
    staticCompositionLocalOf<SearchExerciseApi> { error("No SearchExerciseComponent provided") }
