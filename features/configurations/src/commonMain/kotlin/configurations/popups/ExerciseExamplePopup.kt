package configurations.popups

import Design
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import atomic.icons.Delete
import components.chips.Chip
import components.chips.ChipState
import components.inputs.InputExerciseExampleName
import configurations.state.ExerciseExample
import kotlinx.collections.immutable.toPersistentList
import molecular.ButtonIconSecondary
import molecular.ButtonPrimary
import molecular.PaddingM
import molecular.PaddingS
import molecular.RangeSlider
import molecular.TextH2
import molecular.TextH4
import molecular.ThumbRangeStateState

@Composable
internal fun ExerciseExamplePopup(
    state: ExerciseExampleState,
    confirm: (exerciseExample: ExerciseExample) -> Unit,
    delete: (exerciseExampleId: String?) -> Unit
) {

    val exerciseExample = remember(state) {
        mutableStateOf(state.exerciseExample)
    }

    val appliedMuscles = remember(state) {
        mutableStateOf(state.exerciseExample.muscleBundles)
    }

    val availableMuscles = remember(state, appliedMuscles.value) {
        val list = state.allMuscles
            .filterNot { appliedMuscles.value.map { it.muscle.id }.contains(it.id) }
            .toPersistentList()
        mutableStateOf(list)
    }

    val thumbs = remember(appliedMuscles.value) {
        appliedMuscles.value.map {
            ThumbRangeStateState(id = it.muscle.id, positionInRange = it.value, color = it.color)
        }
    }

    TextH2(
        provideText = { "Exercise Example" }
    )

    PaddingM()

    when (state) {
        is ExerciseExampleState.CREATE -> {
            InputExerciseExampleName(
                value = { exerciseExample.value.name },
                onValueChange = { exerciseExample.value = exerciseExample.value.copy(name = it) }
            )
        }

        is ExerciseExampleState.UPDATE -> {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Chip(
                    chipState = ChipState.Highlighted(enabled = false),
                    text = state.exerciseExample.name
                )

                ButtonIconSecondary(
                    modifier = Modifier.size(24.dp),
                    imageVector = Delete,
                    color = Design.colors.accentPrimary,
                    onClick = { delete.invoke(state.exerciseExample.id) }
                )
            }
        }
    }

    PaddingM()

    if (thumbs.isNotEmpty()) {
        RangeSlider(
            range = SLIDER_RANGE,
            minimalRange = MINIMAL_RANGE,
            thumbs = thumbs,
            lineColor = Design.colors.caption,
            onValueChange = { updatedThumbs ->
                val newList = appliedMuscles.value.map {
                    val newValue = updatedThumbs
                        .find { th -> it.muscle.id == th.id }
                        ?.positionInRange ?: it.value
                    it.copy(value = newValue)
                }.toPersistentList()

                appliedMuscles.value = newList
            }
        )
    }

    PaddingM()

    TextH4(
        provideText = { "Applied" }
    )

    PaddingS()

    FlowRow(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
    ) {

        if (appliedMuscles.value.isEmpty()) {
            Chip(
                chipState = ChipState.HalfTransparent(enabled = false),
                text = "Empty",
            )
        } else {
            appliedMuscles.value.forEach { muscleExerciseBundle ->
                Chip(
                    chipState = ChipState.Selected(),
                    text = muscleExerciseBundle.muscle.name,
                    onClick = {
                        appliedMuscles.value = appliedMuscles.value
                            .removeMuscleBundle(
                                muscleExerciseBundle = muscleExerciseBundle,
                                maximalRange = SLIDER_RANGE.last
                            )

                        availableMuscles.value = buildList {
                            addAll(availableMuscles.value)
                            add(muscleExerciseBundle.muscle)
                        }.toPersistentList()
                    }
                )
            }
        }
    }

    PaddingM()

    TextH4(
        provideText = { "Apply" }
    )

    PaddingS()

    FlowRow(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
    ) {
        if (availableMuscles.value.isEmpty()) {
            Chip(
                chipState = ChipState.HalfTransparent(enabled = false),
                text = "Empty",
            )
        } else {
            availableMuscles.value.forEach { muscle ->
                Chip(
                    chipState = ChipState.Default(),
                    text = muscle.name,
                    onClick = {
                        appliedMuscles.value = appliedMuscles.value
                            .addMuscle(
                                muscle = muscle,
                                minimalRange = MINIMAL_RANGE,
                                maximalRange = SLIDER_RANGE.last
                            )

                        availableMuscles.value = buildList {
                            addAll(availableMuscles.value)
                            remove(muscle)
                        }.toPersistentList()
                    }
                )
            }
        }
    }

    PaddingM()

    ButtonPrimary(
        modifier = Modifier.fillMaxWidth(),
        text = "Confirm",
        onClick = { confirm.invoke(exerciseExample.value.copy(muscleBundles = appliedMuscles.value)) },
        enabled = exerciseExample.value.name.isNotBlank()
    )
}
