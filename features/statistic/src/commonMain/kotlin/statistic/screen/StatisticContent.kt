package statistic.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import components.Error
import components.Loading
import components.roots.Root
import platformTopInset
import statistic.components.Exercises
import statistic.components.Search
import statistic.state.Exercise
import statistic.state.Info

@Composable
internal fun StatisticContent(
    vm: StatisticViewModel,
) {

    val state by vm.state.collectAsState()

    Content(
        loading = { state.loading },
        error = { state.error },
        clearError = vm::clearError,
        removeNameOption = {},
        nameOptions = { state.exerciseNameOptions },
        query = { state.query },
        search = vm::setQuery,
        exercises = state.exercises
    )
}

@Composable
private fun Content(
    // BASE
    loading: () -> Boolean,
    error: () -> String?,
    clearError: () -> Unit,

    // Search
    query: () -> String,
    search: (String) -> Unit,
    removeNameOption: (String) -> Unit,
    nameOptions: () -> List<String>,

    exercises: Map<Info, List<Exercise>>
) {

    Root(
        loading = { Loading(loading) },
        error = { Error(message = error, close = clearError) },
    ) {

        Column(
            modifier = Modifier
                .platformTopInset(),
        ) {
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