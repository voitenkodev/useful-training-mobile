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
import configurations.state.Muscle
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import molecular.ButtonIconSecondary
import molecular.ButtonPrimary
import molecular.PaddingM
import molecular.PaddingS
import molecular.TextH2
import molecular.TextH4

internal sealed class ExerciseExampleState {
    data class CREATE(
        val allMuscles: ImmutableList<Muscle>,
    ) : ExerciseExampleState()

    data class UPDATE(
        val exerciseExample: ExerciseExample,
        val appliedMuscles: ImmutableList<Muscle>,
        val allMuscles: ImmutableList<Muscle>,
    ) : ExerciseExampleState()
}

@Composable
internal fun ExerciseExamplePopup(
    state: ExerciseExampleState,
    confirm: (exerciseExample: ExerciseExample, muscles: ImmutableList<Muscle>) -> Unit,
    delete: (exerciseExampleId: String) -> Unit
) {

    val exerciseExample = remember(state) {
        val item = when (state) {
            is ExerciseExampleState.CREATE -> ExerciseExample()
            is ExerciseExampleState.UPDATE -> state.exerciseExample
        }
        mutableStateOf(item)
    }

    val appliedMuscles = remember(state) {
        val list = when (state) {
            is ExerciseExampleState.CREATE -> persistentListOf()
            is ExerciseExampleState.UPDATE -> state.appliedMuscles
        }
        mutableStateOf(list)
    }

    val availableMuscles = remember(state, appliedMuscles) {
        val list = when (state) {
            is ExerciseExampleState.CREATE -> state.allMuscles
            is ExerciseExampleState.UPDATE -> state.allMuscles
        }.filterNot { appliedMuscles.value.contains(it) }
            .toPersistentList()
        mutableStateOf(list)
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
            appliedMuscles.value.forEach { muscle ->
                Chip(
                    chipState = ChipState.Selected(),
                    text = muscle.name,
                    onClick = {
                        appliedMuscles.value = buildList {
                            addAll(appliedMuscles.value)
                            remove(muscle)
                        }.toPersistentList()

                        availableMuscles.value = buildList {
                            addAll(availableMuscles.value)
                            add(muscle)
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
                        appliedMuscles.value = buildList {
                            addAll(appliedMuscles.value)
                            add(muscle)
                        }.toPersistentList()

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
        onClick = { confirm.invoke(exerciseExample.value, appliedMuscles.value) },
        enabled = exerciseExample.value.name.isNotBlank()
    )
}