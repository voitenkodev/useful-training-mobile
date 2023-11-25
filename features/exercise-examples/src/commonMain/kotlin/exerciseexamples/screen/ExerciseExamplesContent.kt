package exerciseexamples.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import exerciseexamples.components.Footer
import exerciseexamples.components.Header
import exerciseexamples.state.ExerciseExample
import kotlinx.collections.immutable.ImmutableList
import molecule.primaryBackground

@Composable
internal fun ExerciseExamplesContent(
    vm: ExerciseExamplesViewModel,
    toAddExercise: () -> Unit
) {

    val state by vm.state.collectAsState()

    Content(
        loading = { state.loading },
        error = { state.error },
        clearError = vm::clearError,
        exerciseExamples = state.exerciseExamples,
        addNewClick = toAddExercise
    )
}

@Composable
private fun Content(
    loading: () -> Boolean,
    error: () -> String?,
    clearError: () -> Unit,
    exerciseExamples: ImmutableList<ExerciseExample>,
    addNewClick: () -> Unit
) {

    ScreenRoot(error = { Error(message = error, close = clearError) }) {

        Column(modifier = Modifier.fillMaxWidth().primaryBackground()) {

            Header()

            LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f)) {

                items(exerciseExamples, key = { it.id }) {
                    ExerciseCard(
                        modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                        name = it.name,
                        btn = "1?" to {},
                        btn2 = "2?" to {}
                    )
                }
            }

            Footer(addNewClick = addNewClick)
        }
    }
}