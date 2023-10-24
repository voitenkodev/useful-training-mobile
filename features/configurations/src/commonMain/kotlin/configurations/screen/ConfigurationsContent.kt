package configurations.screen

import Design
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import components.Error
import components.Loading
import components.chips.Chip
import components.roots.Root
import configurations.components.Header
import molecular.PaddingM
import molecular.TextH2
import kotlin.random.Random

@Composable
internal fun ConfigurationsContent(
    vm: ConfigurationsViewModel,
) {

    val state by vm.state.collectAsState()

    Content(
        loading = { state.loading },
        error = { state.error },
        clearError = vm::clearError
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

        Column {

            Header()

            PaddingM()

            TextH2(
                provideText = { "Muscles" }
            )

            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
            ) {
                repeat(5) {
                    Chip(
                        isSelected = Random.nextBoolean(),
                        onClick = {}
                    )
                }
            }
        }
    }
}