package presentation.summary

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import design.components.Error
import design.components.Header
import design.components.Loading
import design.components.inputs.InputSearch
import design.components.items.ExerciseItem
import design.components.roots.ScrollableRoot

@Composable
internal fun SummaryContent(vm: SummaryViewModel) {

    val state by vm.state

    LaunchedEffect(Unit) {
//        vm.getTraining(trainingId)
//        vm.getTrainings()
    }

    ScrollableRoot(
        modifier = Modifier.fillMaxSize(),
        loading = { Loading(state.loading) },
        error = { Error(message = state.error, close = vm::clearError) },
        back = {},
        popups = {},
        header = {
            Header(
                title = "Summary!",
                exit = vm::back
            )
        },
        content = {
            item(key = "search_input") {
                InputSearch(
                    value = state.query,
                    onValueChange = {}
                )
            }

            item(key = "exercises") {
                state.exercises.forEachIndexed { index, item ->
                    ExerciseItem(
                        number = index + 1,
                        exercise = item
                    )
                }
            }
        }
    )
}