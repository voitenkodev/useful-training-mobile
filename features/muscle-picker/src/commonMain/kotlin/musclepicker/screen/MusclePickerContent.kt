package musclepicker.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import components.Error
import components.chips.Chip
import components.chips.ChipState
import components.roots.Root
import kotlinx.collections.immutable.ImmutableList
import molecule.TextH3
import musclepicker.state.MuscleType
import platformInsets

@Composable
internal fun MusclePickerContent(
    vm: MusclePickerViewModel
) {

    val state by vm.state.collectAsState()

    Content(
        error = state.error,
        clearError = vm::clearError,
        muscleTypes = state.muscleTypes,
        muscleClick = vm::selectMuscle
    )
}

@Composable
private fun Content(
    error: String?,
    clearError: () -> Unit,
    muscleTypes: ImmutableList<MuscleType>,
    muscleClick: (muscleId: String) -> Unit
) {
    Root(error = { Error(message = { error }, close = clearError) }) {

        LazyColumn(
            modifier = Modifier.fillMaxSize().platformInsets(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            items(muscleTypes, key = { it.id }) {

                TextH3(
                    provideText = { it.name }
                )

                FlowRow(
                    modifier =Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
                    verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
                ) {
                    Chip(
                        chipState = if (it.isSelected) ChipState.Selected() else ChipState.Default(),
                        onClick = { muscleClick.invoke(it.id) },
                        text = it.name
                    )
                }
            }
        }
    }
}