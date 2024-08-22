package trainingbuilder.muscle

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import atom.Design
import components.BottomButtons
import components.Error
import components.roots.ScreenRoot
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import molecule.ButtonPrimary
import molecule.ButtonSecondary
import molecule.PaddingL
import muscles.MuscleEnum
import muscles.MuscleGroup
import muscles.MuscleLoadEnum
import muscles.component.MuscleGroup
import trainingbuilder.muscle.components.Header

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

            LazyColumn(
                modifier = Modifier.fillMaxWidth().weight(1f),
                contentPadding = PaddingValues(vertical = Design.dp.paddingXL),
                verticalArrangement = Arrangement.spacedBy(Design.dp.paddingXL)
            ) {

                itemsIndexed(list, key = { _, item -> item.id }) { index, item ->

                    MuscleGroup(
                        item = item,
                        selectMuscle = selectMuscle
                    )
                }
            }

            PaddingL()

            BottomButtons(
                modifier = Modifier.fillMaxWidth(),
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
}