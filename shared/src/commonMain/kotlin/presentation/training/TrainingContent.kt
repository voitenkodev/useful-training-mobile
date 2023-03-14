package presentation.training

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import design.Design
import design.components.Error
import design.components.Header
import design.components.Loading
import design.components.Popup
import design.components.items.EditExerciseItem
import design.controls.TextFieldH2
import design.controls.dashedBorder


@Composable
internal fun TrainingContent(vm: TrainingViewModel) {

    val state by vm.state

    Column(
        modifier = Modifier.padding(Design.dp.padding),
        verticalArrangement = Arrangement.spacedBy(Design.dp.padding)
    ) {
        Header(
            title = "Exercises!",
            back = vm::openExitScreenPopup,
            save = {
                vm.processingTraining()
                vm.saveTraining(state.training)
            },
        )
//        val list = vm.list.collectAsState()
//        val uiList = remember { mutableStateListOf<Int>() }
//        uiList.swapList(list.value)

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(Design.dp.padding),
            content = {

                itemsIndexed(state.training.exercises, key = { _, exercise -> exercise.id }) { index, exercise ->
                    EditExerciseItem(
                        modifier = Modifier.animateItemPlacement(),
                        number = index + 1,
                        exercise = exercise,
                        updateName = vm::updateName,
                        removeExercise = vm::openRemoveExercisePopup,
                        updateWeight = vm::updateWeight,
                        updateRepeat = vm::updateRepeat
                    )
                }
                item(key = "new_exercise") {
                    NewExercise(
                        modifier = Modifier.animateItemPlacement(), onClick = vm::addExercise
                    )
                }
            })
    }

    Error(message = state.error, close = vm::clearError)

    Loading(state.loading)

    Popup(
        visibility = state.exitWarningVisibility,
        title = "Warning",
        message = "Are you sure to exit from training?",
        button = "Back",
        click = vm::back,
        back = vm::closeExitScreenPopup
    )
    Popup(
        visibility = state.removeExerciseId != null,
        title = "Warning",
        message = "Are you sure to remove exercise?",
        button = "Yes",
        click = {
            vm.removeExercise(state.removeExerciseId)
            vm.closeRemoveExercisePopup()
        },
        back = vm::closeRemoveExercisePopup
    )
//    BackHandler(action = {
//        if (state.removeExerciseId != null) {
//            vm.closeRemoveExercisePopup()
//            return@BackHandler
//        }
//        if (state.exitWarningVisibility.not()) {
//            vm.openExitScreenPopup()
//            return@BackHandler
//        }
//        if (state.exitWarningVisibility) {
//            vm.closeExitScreenPopup()
//            return@BackHandler
//        }
//    })
}

@Composable
private fun NewExercise(
    modifier: Modifier = Modifier, onClick: () -> Unit
) = Box(
    modifier = modifier
        .fillMaxWidth()
        .height(128.dp)
        .dashedBorder(
            width = 2.dp, color = Design.colors.accent_secondary.copy(alpha = 0.5f),
            shape = Design.shape.default,
            on = 8.dp,
            off = 8.dp
        ).clickable(onClick = onClick),
    content = {
        TextFieldH2(
            modifier = Modifier.align(Alignment.Center),
            text = "Add Exercise",
            color = Design.colors.accent_secondary
        )
    })