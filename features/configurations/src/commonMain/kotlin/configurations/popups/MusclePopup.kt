package configurations.popups

import Design
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atomic.icons.Delete
import components.chips.Chip
import components.chips.ChipStatus
import components.inputs.InputSearch
import configurations.state.ExerciseExample
import configurations.state.Muscle
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import molecular.ButtonIconSecondary
import molecular.ButtonPrimary
import molecular.PaddingM
import molecular.PaddingS
import molecular.TextBody2
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
    confirm: (muscle: Muscle, appliedExerciseExamples: ImmutableList<ExerciseExample>) -> Unit
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
            InputSearch(
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
                TextBody2(
                    provideText = { state.muscle.name }
                )

                ButtonIconSecondary(
                    imageVector = Delete,
                    color = Design.colors.accentPrimary,
                    onClick = {}
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
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
    ) {

        appliedExerciseExamples.value.forEach { muscle ->
            Chip(
                chipStatus = ChipStatus.DEFAULT,
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

        availableExerciseExamples.value.forEach { muscle ->
            Chip(
                chipStatus = ChipStatus.DEFAULT,
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

    PaddingM()

    ButtonPrimary(
        modifier = Modifier.fillMaxWidth(),
        text = "Confirm",
        onClick = { confirm.invoke(muscle.value, appliedExerciseExamples.value) }
    )
}