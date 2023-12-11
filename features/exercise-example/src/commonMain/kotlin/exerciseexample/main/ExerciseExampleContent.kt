package exerciseexample.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import components.Error
import components.roots.ScreenRoot
import exerciseexample.main.state.ExerciseExample
import kotlinx.collections.immutable.ImmutableList

@Composable
internal fun ExerciseExampleContent(
    vm: ExerciseExampleViewModel,
    close: () -> Unit
) {

    val state by vm.state.collectAsState()

    Content(
        error = { state.error },
        loading = state.loading,
        clearError = vm::clearError,
        query = state.query,
        setQuery = vm::setQuery,
        exerciseExamples = state.exerciseExamples,
        close = close
    )
}

@Composable
private fun Content(
    error: () -> String?,
    loading: Boolean,
    clearError: () -> Unit,
    query: String,
    setQuery: (String) -> Unit,
    exerciseExamples: ImmutableList<ExerciseExample>,
    close: () -> Unit
) {

    ScreenRoot(error = { Error(message = error, close = clearError) }) {


    }
}