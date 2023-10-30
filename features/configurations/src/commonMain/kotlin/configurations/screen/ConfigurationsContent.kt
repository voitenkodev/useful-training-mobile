package configurations.screen

import Design
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import components.Error
import components.Loading
import components.chips.Chip
import components.chips.ChipState
import components.roots.Root
import configurations.components.Header
import configurations.state.ExerciseExample
import configurations.state.Muscle
import kotlinx.collections.immutable.ImmutableList
import molecular.TextH2

@Composable
internal fun ConfigurationsContent(
    vm: ConfigurationsViewModel,
    toExerciseExampleBuilder: (id: String?) -> Unit
) {

    val state by vm.state.collectAsState()

    Content(
        loading = { state.loading },
        error = { state.error },
        clearError = vm::clearError,
        exerciseExamples = state.exerciseExamples,
        muscles = state.muscles,
        toExerciseExample = toExerciseExampleBuilder,
        toMuscle = { }
    )
}

@Composable
private fun Content(
    loading: () -> Boolean,
    error: () -> String?,
    clearError: () -> Unit,

    exerciseExamples: ImmutableList<ExerciseExample>,
    muscles: ImmutableList<Muscle>,

    toExerciseExample: (exerciseExampleId: String?) -> Unit,
    toMuscle: (muscleId: String?) -> Unit,
) {

    Root(
        loading = { Loading(loading) },
        error = { Error(message = error, close = clearError) },
    ) {

        Column(modifier = Modifier.fillMaxSize()) {

            Header()

            LazyColumn(
                modifier = Modifier
                    .animateContentSize()
                    .weight(1f),
                contentPadding = PaddingValues(Design.dp.paddingM),
                verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
            ) {

                item {
                    TextH2(
                        provideText = { "Exercise examples" }
                    )
                }

                item {
                    Chip(
                        chipState = ChipState.Highlighted(),
                        text = "ADD NEW",
                        onClick = { toExerciseExample(null) }
                    )
                }

                items(exerciseExamples, key = { it.id }) { muscleExercise ->
                    Chip(
                        chipState = ChipState.Default(),
                        text = muscleExercise.name,
                        onClick = { toExerciseExample(muscleExercise.id) }
                    )
                }

                item {
                    TextH2(
                        provideText = { "Muscles" }
                    )
                }

                items(muscles, key = { it.id }) { muscle ->
                    Chip(
                        chipState = ChipState.Default(),
                        text = muscle.name,
                        onClick = { toMuscle.invoke(muscle.id) }
                    )
                }
            }
        }
    }
}