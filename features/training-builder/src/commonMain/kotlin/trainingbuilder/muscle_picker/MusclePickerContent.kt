package trainingbuilder.muscle_picker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import components.Error
import components.roots.ScreenRoot
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import molecule.Shadow
import molecule.primaryBackground
import trainingbuilder.muscle_picker.components.Footer
import trainingbuilder.muscle_picker.components.Header
import trainingbuilder.muscle_picker.components.MuscleGroup
import trainingbuilder.muscle_picker.components.MusclePack
import trainingbuilder.muscle_picker.models.MuscleType

@Composable
internal fun MusclePickerContent(
    vm: MusclePickerViewModel,
    apply: (List<String>) -> Unit,
    close: () -> Unit
) {

    val state by vm.state.collectAsState()

    Content(
        error = state.error,
        list = state.muscleTypes,
        clearError = vm::clearError,
        selectMuscleType = vm::selectMuscleType,
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
    list: ImmutableList<MuscleType>,
    selectMuscleType: (id: String) -> Unit,
    selectMuscle: (id: String) -> Unit,
    selectFullBody: () -> Unit,
    selectUpperBody: () -> Unit,
    selectLowerBody: () -> Unit,
    apply: (List<String>) -> Unit,
    close: () -> Unit
) {

    ScreenRoot(error = { Error(message = { error }, close = clearError) }) {

        Column(modifier = Modifier.fillMaxWidth().primaryBackground()) {

            Header(close = close)

            LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f)) {

                item(key = "packs") {

                    MusclePack(
                        list = list,
                        selectFullBody = selectFullBody,
                        selectUpperBody = selectUpperBody,
                        selectLowerBody = selectLowerBody
                    )
                }

                itemsIndexed(list, key = { _, item -> item.id }) { index, item ->

                    MuscleGroup(
                        item = item,
                        selectMuscleType = selectMuscleType,
                        selectMuscle = selectMuscle
                    )

                    if (index < list.lastIndex) Shadow()
                }
            }

            Footer(
                list = list,
                skip = { apply.invoke(persistentListOf()) },
                apply = {
                    val selectedMuscles = list
                        .flatMap { it.muscles }
                        .filter { it.isSelected }
                        .map { it.id }
                    apply.invoke(selectedMuscles)
                }
            )
        }
    }
}