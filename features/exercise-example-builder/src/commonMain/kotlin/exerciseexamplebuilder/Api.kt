package exerciseexamplebuilder

import NavStringParam
import androidx.compose.runtime.Composable
import exerciseexamplebuilder.screen.ExerciseExampleBuilderContent
import exerciseexamplebuilder.screen.ExerciseExampleBuilderViewModel
import io.github.xxfast.decompose.router.rememberOnRoute

@Composable
public fun ExerciseExampleBuilderFeature(
    exerciseExampleId: String?,
    back: () -> Unit
) {

    val vm = rememberOnRoute(
        ExerciseExampleBuilderViewModel::class,
        key = NavStringParam(exerciseExampleId)
    ) { saveState ->
        ExerciseExampleBuilderViewModel(saveState)
    }

    ExerciseExampleBuilderContent(
        vm = vm,
        back = back
    )
}