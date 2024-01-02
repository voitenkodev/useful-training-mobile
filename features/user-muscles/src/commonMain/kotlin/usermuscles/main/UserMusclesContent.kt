package usermuscles.main

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
import usermuscles.main.components.Footer
import usermuscles.main.components.Header
import usermuscles.main.components.MuscleGroup
import usermuscles.main.models.MuscleType

@Composable
internal fun UserMusclesContent(
    vm: UserMusclesViewModel,
    close: () -> Unit
) {

    val state by vm.state.collectAsState()

    Content(
        error = state.error,
        list = state.muscleTypes,
        clearError = vm::clearError,
        selectMuscle = vm::selectMuscle,
        apply = {},
        close = close
    )
}

@Composable
private fun Content(
    error: String?,
    clearError: () -> Unit,
    list: ImmutableList<MuscleType>,
    selectMuscle: (id: String) -> Unit,
    apply: (List<String>) -> Unit,
    close: () -> Unit
) {

    ScreenRoot(error = { Error(message = { error }, close = clearError) }) {

        Column(modifier = Modifier.fillMaxWidth().primaryBackground()) {

            Header(close = close)

            LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f)) {

                itemsIndexed(list, key = { _, item -> item.id }) { index, item ->

                    MuscleGroup(
                        item = item,
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