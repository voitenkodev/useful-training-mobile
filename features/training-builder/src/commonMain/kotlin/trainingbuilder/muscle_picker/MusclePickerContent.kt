package trainingbuilder.muscle_picker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import components.Error
import components.ShadowBottomButtons
import components.ShadowFooterSpace
import components.roots.ScreenRoot
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import molecule.ButtonPrimary
import molecule.ButtonSecondary
import molecule.Shadow
import muscles.MuscleEnum
import muscles.MuscleGroup
import muscles.MuscleLoadEnum
import trainingbuilder.muscle_picker.components.Header
import trainingbuilder.muscle_picker.components.MuscleGroup

@Composable
internal fun MusclePickerContent(
    vm: MusclePickerViewModel,
    apply: (List<String>) -> Unit,
    close: () -> Unit
) {

    val state by vm.state.collectAsState()

    Content(
        error = state.error,
        list = state.muscleGroups,
        includedMuscleStatuses = state.includedMuscleStatuses,
        upperBodyPackEnums = state.upperBodyList,
        lowerBodyPackEnums = state.lowerBodyList,
        clearError = vm::clearError,
        selectMuscleGroup = vm::selectMuscleGroup,
        selectMuscle = vm::selectMuscle,
        selectFullBody = vm::selectFullBody,
        selectUpperBody = vm::selectUpperBody,
        selectLowerBody = vm::selectLowerBody,
        apply = apply,
        close = close
    )
}

@Composable
private fun Content(
    error: String?,
    clearError: () -> Unit,
    list: ImmutableList<MuscleGroup>,
    upperBodyPackEnums: ImmutableList<MuscleEnum>,
    lowerBodyPackEnums: ImmutableList<MuscleEnum>,
    includedMuscleStatuses: ImmutableList<MuscleLoadEnum>,
    selectMuscleGroup: (id: String) -> Unit,
    selectMuscle: (id: String) -> Unit,
    selectFullBody: () -> Unit,
    selectUpperBody: () -> Unit,
    selectLowerBody: () -> Unit,
    apply: (List<String>) -> Unit,
    close: () -> Unit
) {

    val selectedSum = remember(list) { list.sumOf { it.muscles.count { c -> c.isSelected } } }

    ScreenRoot(error = { Error(message = { error }, close = clearError) }) {

        Column(modifier = Modifier.fillMaxSize()) {

            Header(
                close = close,
                list = list,
                includedMuscleStatuses = includedMuscleStatuses,
                lowerBodyPackEnums = lowerBodyPackEnums,
                upperBodyPackEnums = upperBodyPackEnums,
                selectFullBody = selectFullBody,
                selectUpperBody = selectUpperBody,
                selectLowerBody = selectLowerBody
            )

            LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f)) {

                itemsIndexed(list, key = { _, item -> item.id }) { index, item ->

                    MuscleGroup(
                        item = item,
                        includedMuscleStatuses = includedMuscleStatuses,
                        selectMuscleGroup = selectMuscleGroup,
                        selectMuscle = selectMuscle
                    )

                    if (index < list.lastIndex) Shadow()
                }

                item {
                    ShadowFooterSpace()
                }
            }
        }

        ShadowBottomButtons(
            modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),
            first = {
                ButtonSecondary(
                    modifier = Modifier.weight(1f),
                    text = "Skip",
                    onClick = { apply.invoke(persistentListOf()) }
                )
            },
            second = {
                ButtonPrimary(
                    modifier = Modifier.weight(1f),
                    text = buildString {
                        append("Select")
                        selectedSum.takeIf { it > 0 }?.let { append(" $it") }
                    },
                    enabled = selectedSum > 0,
                    onClick = {
                        val selectedMuscles = list
                            .flatMap { it.muscles }
                            .filter { it.isSelected }
                            .map { it.id }
                        apply.invoke(selectedMuscles)
                    }
                )
            }
        )
    }
}