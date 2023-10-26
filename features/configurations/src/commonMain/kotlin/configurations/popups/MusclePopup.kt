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
import components.inputs.InputMuscleName
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

internal sealed class MusclePopupState {
    data class CREATE(
        val allExerciseExamples: ImmutableList<ExerciseExample>,
    ) : MusclePopupState()

    data class UPDATE(
        val muscle: Muscle,
        val appliedExerciseExamples: ImmutableList<ExerciseExample>,
        val allExerciseExamples: ImmutableList<ExerciseExample>,
    ) : MusclePopupState()
}

@Composable
internal fun MusclePopup(
    state: MusclePopupState,
    confirm: (muscle: Muscle, appliedExerciseExamples: ImmutableList<ExerciseExample>) -> Unit,
    delete: (muscleId: String) -> Unit
) {

    val muscle = remember(state) {
        val item = when (state) {
            is MusclePopupState.CREATE -> Muscle()
            is MusclePopupState.UPDATE -> state.muscle
        }
        mutableStateOf(item)
    }

    val appliedExerciseExamples = remember(state) {
        val list = when (state) {
            is MusclePopupState.CREATE -> persistentListOf()
            is MusclePopupState.UPDATE -> state.appliedExerciseExamples
        }
        mutableStateOf(list)
    }

    val availableExerciseExamples = remember(state, appliedExerciseExamples) {
        val list = when (state) {
            is MusclePopupState.CREATE -> state.allExerciseExamples
            is MusclePopupState.UPDATE -> state.allExerciseExamples
        }
            .filterNot { appliedExerciseExamples.value.contains(it) }
            .toPersistentList()
        mutableStateOf(list)
    }

    TextH2(
        provideText = { "Muscle" }
    )

    PaddingM()

    when (state) {
        is MusclePopupState.CREATE -> {
            InputMuscleName(
                value = { muscle.value.name },
                onValueChange = { muscle.value = muscle.value.copy(name = it) }
            )
        }

        is MusclePopupState.UPDATE -> {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Chip(
                    chipState = ChipState.Highlighted(enabled = false),
                    text = state.muscle.name
                )

                ButtonIconSecondary(
                    modifier = Modifier.size(24.dp),
                    imageVector = Delete,
                    color = Design.colors.accentPrimary,
                    onClick = { delete.invoke(muscle.value.id) }
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
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
    ) {

        if (appliedExerciseExamples.value.isEmpty()) {
            Chip(
                chipState = ChipState.HalfTransparent(enabled = false),
                text = "Empty",
            )
        } else {
            appliedExerciseExamples.value.forEach { muscle ->
                Chip(
                    chipState = ChipState.Selected(),
                    text = muscle.name,
                    onClick = {
                        appliedExerciseExamples.value = buildList {
                            addAll(appliedExerciseExamples.value)
                            remove(muscle)
                        }.toPersistentList()

                        availableExerciseExamples.value = buildList {
                            addAll(availableExerciseExamples.value)
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
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
    ) {

        if (availableExerciseExamples.value.isEmpty()) {
            Chip(
                chipState = ChipState.HalfTransparent(enabled = false),
                text = "Empty",
            )
        } else {
            availableExerciseExamples.value.forEach { muscle ->
                Chip(
                    chipState = ChipState.Default(),
                    text = muscle.name,
                    onClick = {
                        appliedExerciseExamples.value = buildList {
                            addAll(appliedExerciseExamples.value)
                            add(muscle)
                        }.toPersistentList()

                        availableExerciseExamples.value = buildList {
                            addAll(availableExerciseExamples.value)
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
        onClick = { confirm.invoke(muscle.value, appliedExerciseExamples.value) },
        enabled = muscle.value.name.isNotBlank()
    )
}