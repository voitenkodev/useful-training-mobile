package configurations.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import components.Error
import components.Loading
import components.roots.Root

@Composable
internal fun StatisticsContent(
    vm: ConfigurationsViewModel,
) {

    val state by vm.state.collectAsState()

    Content(
        loading = { state.loading },
        error = { state.error },
        clearError = vm::clearError,

        )
}

@Composable
private fun Content(
    loading: () -> Boolean,
    error: () -> String?,
    clearError: () -> Unit
) {

    Root(
        loading = { Loading(loading) },
        error = { Error(message = error, close = clearError) },
    ) {

    }
}