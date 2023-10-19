package statistic.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import controls.TextFieldH3

@Composable
internal fun StatisticContent(
    vm: StatisticViewModel,
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
    // BASE
    loading: () -> Boolean,
    error: () -> String?,
    clearError: () -> Unit,
) {

    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        TextFieldH3(
            provideText = { "Work in progress" }
        )
    }
}