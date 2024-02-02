package exerciseexample

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

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
    private var _exerciseExampleId: String? = null,
) {

    val exerciseExampleId: String? get() = _exerciseExampleId

    public fun primaryActionClick(id: String) {
        _exerciseExampleId = id
    }
}

private val LocalExerciseExampleController =
    staticCompositionLocalOf<ExerciseExampleApi> { error("No ExerciseExampleComponent provided") }
