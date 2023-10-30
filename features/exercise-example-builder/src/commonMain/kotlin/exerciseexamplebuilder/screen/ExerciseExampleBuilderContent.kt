package exerciseexamplebuilder.screen

import Design
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import atomic.icons.Delete
import components.Error
import components.Loading
import components.chips.Chip
import components.chips.ChipState
import components.inputs.InputExerciseExampleName
import components.roots.Root
import exerciseexamplebuilder.components.Footer
import exerciseexamplebuilder.components.Header
import exerciseexamplebuilder.state.ExerciseExample
import exerciseexamplebuilder.state.Muscle
import exerciseexamplebuilder.state.MuscleExerciseBundle
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import molecular.ButtonIconSecondary
import molecular.PaddingM
import molecular.RangeSlider
import molecular.TextH4
import molecular.ThumbRangeStateState

@Composable
internal fun ExerciseExampleBuilderContent(
    vm: ExerciseExampleBuilderViewModel,
    back: () -> Unit
) {

    val state by vm.state.collectAsState()

    Content(
        loading = { state.loading },
        error = { state.error },
        clearError = vm::clearError,

        exerciseExample = state.exerciseExample,
        availableMuscles = state.availableMuscles,
        minimalRange = state.minimalRange,
        sliderRange = state.sliderRange,

        setExerciseExampleName = vm::setExerciseExampleName,

        addMuscle = vm::addMuscle,
        removeMuscleBundle = vm::removeMuscleBundle,
        deleteExercise = {},
        onMuscleBundleChange = vm::onMuscleBundleChange,
        confirm = { vm.setExerciseExample(success = back) }
    )
}

@Composable
private fun Content(
    loading: () -> Boolean,
    error: () -> String?,
    clearError: () -> Unit,

    exerciseExample: ExerciseExample?,
    availableMuscles: ImmutableList<Muscle>,

    minimalRange: Int,
    sliderRange: ClosedRange<Int>,

    addMuscle: (muscle: Muscle) -> Unit,
    removeMuscleBundle: (muscleBundle: MuscleExerciseBundle) -> Unit,

    setExerciseExampleName: (String) -> Unit,
    onMuscleBundleChange: (ImmutableList<MuscleExerciseBundle>) -> Unit,
    deleteExercise: () -> Unit,
    confirm: () -> Unit,
) {

    Root(
        loading = { Loading(loading) },
        error = { Error(message = error, close = clearError) },
    ) {


        val thumbs = remember(exerciseExample?.muscleExerciseBundles) {
            exerciseExample?.muscleExerciseBundles?.map {
                ThumbRangeStateState(
                    id = it.muscle.id,
                    positionInRange = it.value,
                    color = it.color
                )
            } ?: persistentListOf()
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .animateContentSize()
        ) {

            Header()

            PaddingM()


            if (exerciseExample != null && exerciseExample.id == null) {
                InputExerciseExampleName(
                    modifier = Modifier
                        .padding(horizontal = Design.dp.paddingM),
                    value = { exerciseExample.name },
                    onValueChange = setExerciseExampleName
                )
            } else if (exerciseExample != null) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = Design.dp.paddingM)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Chip(
                        chipState = ChipState.Highlighted(enabled = false),
                        text = exerciseExample.name
                    )

                    ButtonIconSecondary(
                        modifier = Modifier.size(24.dp),
                        imageVector = Delete,
                        color = Design.colors.accentPrimary,
                        onClick = deleteExercise
                    )
                }
            }

            PaddingM()

            if (exerciseExample != null && thumbs.isNotEmpty()) {
                RangeSlider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = Design.dp.paddingM)
                        .height(20.dp),
                    range = sliderRange,
                    minimalRange = minimalRange,
                    thumbs = thumbs,
                    lineColor = Design.colors.caption,
                    onValueChange = { updatedThumbs ->
                        val newList = exerciseExample.muscleExerciseBundles.map {
                            val newValue = updatedThumbs
                                .find { th -> it.muscle.id == th.id }
                                ?.positionInRange ?: it.value
                            it.copy(value = newValue)
                        }.toPersistentList()

                        onMuscleBundleChange(newList)
                    }
                )
            }

            LazyColumn(
                modifier = Modifier
                    .animateContentSize()
                    .weight(1f),
                contentPadding = PaddingValues(Design.dp.paddingM),
                verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
            ) {

                item {
                    TextH4(
                        provideText = { "Applied" }
                    )
                }

                if (exerciseExample != null && exerciseExample.muscleExerciseBundles.isEmpty()) {
                    item {
                        Chip(
                            chipState = ChipState.HalfTransparent(enabled = false),
                            text = "Empty",
                        )
                    }
                } else if (exerciseExample != null) {
                    items(exerciseExample.muscleExerciseBundles, key = { it.muscle.id }) { muscleExerciseBundle ->
                        Chip(
                            chipState = ChipState.Colored(muscleExerciseBundle.color),
                            text = buildString {
                                append(muscleExerciseBundle.muscle.name)
                                append(" ")
                                append(muscleExerciseBundle.value)
                                append("%")
                            },
                            onClick = { removeMuscleBundle(muscleExerciseBundle) }
                        )
                    }
                }

                item {
                    TextH4(
                        provideText = { "Apply" }
                    )
                }

                if (exerciseExample != null && availableMuscles.isEmpty()) {
                    item {
                        Chip(
                            chipState = ChipState.HalfTransparent(enabled = false),
                            text = "Empty",
                        )
                    }
                } else if (exerciseExample != null) {
                    items(availableMuscles, key = { it.id }) { muscle ->
                        Chip(
                            chipState = ChipState.Default(),
                            text = muscle.name,
                            onClick = { addMuscle.invoke(muscle) }
                        )
                    }
                }
            }

            Footer(
                modifier = Modifier.fillMaxWidth(),
                confirmEnabled = exerciseExample?.name?.isNotBlank() == true,
                confirmClick = confirm
            )
        }
    }
}