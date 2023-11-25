package exerciseexamples

import androidx.compose.runtime.Composable
import exerciseexamples.screen.ExerciseExamplesContent
import exerciseexamples.screen.ExerciseExamplesViewModel
import io.github.xxfast.decompose.router.rememberOnRoute

@Composable
public fun ExerciseExamplesFeature(
    toAddExercise: () -> Unit
) {

    val vm = rememberOnRoute(ExerciseExamplesViewModel::class) {
        ExerciseExamplesViewModel()
    }

    ExerciseExamplesContent(
        vm = vm,
        toAddExercise = toAddExercise
    )
}