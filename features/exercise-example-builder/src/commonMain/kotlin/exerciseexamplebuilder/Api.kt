package exerciseexamplebuilder

import androidx.compose.runtime.Composable
import exerciseexamplebuilder.screen.ExerciseExampleBuilderContent
import exerciseexamplebuilder.screen.ExerciseExampleBuilderViewModel
import io.github.xxfast.decompose.router.rememberOnRoute

@Composable
public fun ExerciseExampleBuilderFeature(
    exerciseExampleId: String?,
    back: () -> Unit
) {
    val vm = rememberOnRoute(ExerciseExampleBuilderViewModel::class) {
        ExerciseExampleBuilderViewModel(exerciseExampleId)
    }

    ExerciseExampleBuilderContent(
        vm = vm,
        back = back
    )
}