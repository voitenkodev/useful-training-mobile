package searchexercise.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
internal fun SearchExerciseContent(
    vm: SearchExerciseViewModel
) {

    val state by vm.state.collectAsState()

    Content(
        error = { state.error },
        clearError = vm::clearError
    )
}

@Composable
private fun Content(
    error: () -> String?,
    clearError: () -> Unit
) {

}
