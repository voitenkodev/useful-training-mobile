package profile.screen

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
import atom.Design
import components.Error
import components.Loading
import components.chips.Chip
import components.chips.ChipState
import components.roots.Root
import icons.Dumbbell
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonIconPrimary
import molecule.IconPrimary
import molecule.TextH3
import profile.components.Header
import profile.components.ProfileCart
import profile.state.ExerciseExample
import profile.state.Muscle

@Composable
internal fun ProfileContent(
    vm: ProfileViewModel,
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
        toMuscle = { },
        logout = vm::logout
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
    logout: () -> Unit
) {

    Root(
        loading = { Loading(loading) },
        error = { Error(message = error, close = clearError) },
    ) {

        Column(modifier = Modifier.fillMaxSize()) {

            Header()

            ButtonIconPrimary(
                imageVector = Dumbbell,
                onClick = logout
            )

            LazyColumn(
                modifier = Modifier
                    .animateContentSize()
                    .weight(1f),
                contentPadding = PaddingValues(Design.dp.paddingM),
                verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
            ) {

                item {
                    ProfileCart(
                        visibility = true,
                        onClose = {}
                    )
                }

                item {
                    TextH3(
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
                    TextH3(
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