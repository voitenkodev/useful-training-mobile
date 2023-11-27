package exerciseexamples.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import atom.Design
import components.Error
import components.brand.ExerciseCard
import components.roots.ScreenRoot
import exerciseexamples.list.components.Footer
import exerciseexamples.list.components.Header
import exerciseexamples.list.state.ExerciseExample
import kotlinx.collections.immutable.ImmutableList
import molecule.primaryBackground

@Composable
internal fun ExerciseExamplesContent(
    vm: ExerciseExamplesViewModel,
    toExerciseExampleBuilder: (id: String?) -> Unit
) {

    val state by vm.state.collectAsState()

    Content(
        error = { state.error },
        clearError = vm::clearError,
        exerciseExamples = state.exerciseExamples,
        addNewClick = { toExerciseExampleBuilder.invoke(null) },
        selectExerciseExample = toExerciseExampleBuilder
    )
}

@Composable
private fun Content(
    error: () -> String?,
    clearError: () -> Unit,
    exerciseExamples: ImmutableList<ExerciseExample>,
    addNewClick: () -> Unit,
    selectExerciseExample: (id: String) -> Unit
) {

    ScreenRoot(error = { Error(message = error, close = clearError) }) {

        Column(modifier = Modifier.fillMaxWidth().primaryBackground()) {

            Header()

            LazyColumn(
                modifier = Modifier.fillMaxWidth().weight(1f),
                contentPadding = PaddingValues(Design.dp.paddingM),
                verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
            ) {

                items(exerciseExamples, key = { it.id }) {
                    ExerciseCard(
                        name = it.name,
                        imageUrl = it.imageUrl,
                        btn = "Update" to { selectExerciseExample.invoke(it.id) },
                        musclesWithPercent = it.muscleExerciseBundles.map { b ->
                            b.muscle.name to b.percentage.toFloat()
                        }
                    )
                }
            }

            Footer(addNewClick = addNewClick)
        }
    }
}