package weighthistory.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import components.BottomButtons
import components.Error
import components.ShadowFooterSpace
import components.roots.ScreenRoot
import kg
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonPrimary
import molecule.Label
import molecule.PaddingM
import molecule.PopupSheet
import resources.Icons
import user.component.WeightCard
import user.component.WeightCardIcon
import weighthistory.main.components.Header
import weighthistory.main.models.WeightHistory
import weighthistory.main.popups.WeightPickerPopup

@Composable
internal fun WeightHistoryContent(
    vm: WeightHistoryViewModel,
    close: () -> Unit
) {

    val state by vm.state.collectAsState()

    state.weightPickerPopupVisibleWithLastWeight?.let { lastWeight ->
        PopupSheet(
            onDismiss = vm::closeWeightPickerPopup,
            cancelable = true,
            content = { hideLambda ->
                WeightPickerPopup(
                    initialWeight = lastWeight,
                    close = hideLambda,
                    apply = vm::updateWeight
                )
            }
        )
    }

    Content(
        close = close,
        error = { state.error },
        clearError = vm::clearError,
        weightHistory = state.weightHistory,
        update = vm::openWeightPickerPopup,
        remove = vm::removeWeight
    )
}

@Composable
private fun Content(
    error: () -> String?,
    clearError: () -> Unit,
    weightHistory: ImmutableList<WeightHistory>,
    update: () -> Unit,
    close: () -> Unit,
    remove: (id: String) -> Unit,
) {

    ScreenRoot(error = { Error(message = { error() }, close = clearError) }) {

        Column(modifier = Modifier.fillMaxSize()) {

            Header(
                close = close,
                weightHistory = weightHistory
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentPadding = PaddingValues(vertical = Design.dp.paddingM),
            ) {

                item {
                    Label(
                        modifier = Modifier.padding(horizontal = Design.dp.paddingL),
                        provideText = { "History" },
                    )
                }

                item { PaddingM() }

                itemsIndexed(weightHistory, key = { _, item -> item.id }) { index, item ->

                    val previousWeight = weightHistory.getOrNull(index + 1)?.weight ?: 0.0

                    val color = if (item.weight > previousWeight) Design.colors.green
                    else Design.colors.orange

                    val img = if (item.weight > previousWeight) Icons.arrowUp
                    else Icons.arrowDown

                    val removeProvider = remember {
                        {
                            remove.invoke(item.id)
                        }
                    }

                    WeightCard(
                        modifier = Modifier
                            .animateItemPlacement()
                            .padding(horizontal = Design.dp.paddingM),
                        title = item.weight.kg(true),
                        description = "At ${item.createdAt}",
                        startIcon = img to color,
                        endIcon = if (weightHistory.size > 1) WeightCardIcon(
                            icon = Icons.close,
                            action = removeProvider
                        ) else null
                    )

                    if (index != weightHistory.lastIndex) {
                        PaddingM()
                    }
                }

                item("shadow_bottom_space") {
                    ShadowFooterSpace()
                }
            }
        }

        BottomButtons(
            modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),
            first = {},
            second = {
                ButtonPrimary(
                    modifier = Modifier.weight(1f),
                    text = "Update weight",
                    onClick = update,
                )
            }
        )
    }
}