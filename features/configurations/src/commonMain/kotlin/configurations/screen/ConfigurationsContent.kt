package configurations.screen

import Design
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import atomic.icons.Add
import components.Error
import components.Loading
import components.chips.Chip
import components.chips.ChipStatus
import components.roots.Root
import configurations.components.Header
import configurations.state.ExerciseExample
import configurations.state.Muscle
import kotlinx.collections.immutable.ImmutableList
import molecular.PaddingL
import molecular.PaddingM
import molecular.PaddingS
import molecular.TextH2

@Composable
internal fun ConfigurationsContent(
    vm: ConfigurationsViewModel,
) {

    val state by vm.state.collectAsState()

    Content(
        loading = { state.loading },
        error = { state.error },
        clearError = vm::clearError,

        exerciseExamples = state.exerciseExamples,
        muscles = state.muscles,

        addExerciseExample = vm::addExerciseExample,
        selectExerciseExample = vm::selectExerciseExample,
        addMuscle = vm::addMuscle,
        selectMuscle = vm::selectMuscle
    )
}

@Composable
private fun Content(
    loading: () -> Boolean,
    error: () -> String?,
    clearError: () -> Unit,

    exerciseExamples: ImmutableList<ExerciseExample>,
    muscles: ImmutableList<Muscle>,

    addExerciseExample: () -> Unit,
    selectExerciseExample: (id: String) -> Unit,
    addMuscle: () -> Unit,
    selectMuscle: (id: String) -> Unit,
) {

    Root(
        loading = { Loading(loading) },
        error = { Error(message = error, close = clearError) },
    ) {

        Column {

            Header()

            PaddingM()

            TextH2(
                modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                provideText = { "Exercises" }
            )

            PaddingS()

            FlowRow(
                modifier = Modifier
                    .padding(horizontal = Design.dp.paddingM)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
            ) {

                Chip(
                    chipStatus = ChipStatus.HIGHLIGHTED,
                    text = "Add new",
                    icon = Add,
                    onClick = addExerciseExample
                )

                exerciseExamples.forEach { exerciseExample ->
                    Chip(
                        chipStatus = ChipStatus.DEFAULT,
                        text = exerciseExample.name,
                        onClick = {}
                    )
                }
            }

            PaddingL()

            TextH2(
                modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                provideText = { "Muscles" }
            )

            PaddingS()

            FlowRow(
                modifier = Modifier
                    .padding(horizontal = Design.dp.paddingM)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
            ) {

                Chip(
                    chipStatus = ChipStatus.HIGHLIGHTED,
                    text = "Add new",
                    icon = Add,
                    onClick = addMuscle
                )

                muscles.forEach { muscle ->
                    Chip(
                        chipStatus = ChipStatus.DEFAULT,
                        text = muscle.name,
                        onClick = {}
                    )
                }
            }
        }
    }
}