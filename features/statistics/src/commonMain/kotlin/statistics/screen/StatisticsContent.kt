package statistics.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import components.Error
import components.Loading
import components.roots.Root
import kotlinx.collections.immutable.ImmutableList
import statistics.components.Exercises
import statistics.components.Search
import statistics.state.Exercise
import statistics.state.Info

@Composable
internal fun StatisticsContent(
    vm: StatisticsViewModel,
) {

    val state by vm.state.collectAsState()

    Content(
        loading = { state.loading },
        error = { state.error },
        clearError = vm::clearError,
        removeNameOption = vm::removeExerciseNameOption,
        nameOptions = state.exerciseNameOptions,
        query = { state.query },
        search = vm::setQuery,
        exercises = state.exercises
    )
}

@Composable
private fun Content(
    loading: () -> Boolean,
    error: () -> String?,
    clearError: () -> Unit,

    query: () -> String,
    search: (String) -> Unit,
    removeNameOption: (String) -> Unit,

    nameOptions: ImmutableList<String>,
    exercises: Map<Info, List<Exercise>>
) {

    Root(
        loading = { Loading(loading) },
        error = { Error(message = error, close = clearError) },
    ) {

        Column {

            Search(
                query = query,
                search = search,
                removeNameOption = removeNameOption,
                nameOptions = nameOptions
            )

            Exercises(
                modifier = Modifier.weight(1f),
                exercises = exercises
            )
        }
    }
}