package weighthistory.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import atom.Design
import basic.LineChart
import basic.LineChartDotsStyle
import basic.LineChartLabelStyle
import basic.LineChartStyle
import components.Error
import components.ShadowFooter
import components.ShadowFooterSpace
import components.cards.HorizontalValueCard
import components.roots.ScreenRoot
import kg
import kotlinx.collections.immutable.ImmutableList
import molecule.PopupSheet
import resources.Icons
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
            cancelable = false,
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
        update = vm::openWeightPickerPopup
    )
}

@Composable
private fun Content(
    error: () -> String?,
    clearError: () -> Unit,
    weightHistory: ImmutableList<WeightHistory>,
    update: () -> Unit,
    close: () -> Unit
) {

    val reversedList = remember(weightHistory) {
        weightHistory.reversed().takeLast(5)
    }

    ScreenRoot(error = { Error(message = { error() }, close = clearError) }) {

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = Design.dp.paddingM),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {

            item("shadow_top_space") {
                Spacer(modifier = Modifier.statusBarsPadding().height(Design.dp.componentL))
            }

            item("chart") {
                LineChart(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = Design.dp.paddingXL)
                        .height(130.dp),
                    values = reversedList.map { it.weight.toFloat() },
                    chartStyle = LineChartStyle(
                        lineColor = Design.colors.content,
                        labelStyle = LineChartLabelStyle(
                            backgroundColor = Design.colors.toxic.copy(alpha = 0.2f),
                            borderColor = Design.colors.toxic,
                            paddings = Design.dp.paddingXS,
                            textColor = Design.colors.content,
                            spaceTillLine = 26.dp,
                            borderWidth = 1.dp
                        ),
                        dotsStyle = LineChartDotsStyle(
                            backgroundColor = Design.colors.orange,
                            width = 6.dp,
                            type = LineChartDotsStyle.DotsType.START_END
                        )
                    )
                )
            }

            itemsIndexed(weightHistory, key = { _, item -> item.id }) { index, item ->

                val previousWeight = weightHistory.getOrNull(index + 1)?.weight ?: 0.0

                val color = if (item.weight > previousWeight) Design.colors.toxic.copy(alpha = 0.5f)
                else Design.colors.orange.copy(alpha = 0.5f)

                val img = if (item.weight > previousWeight) Icons.arrowUp
                else Icons.arrowDown

                HorizontalValueCard(
                    modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                    title = item.weight.kg(true),
                    description = "At: ${item.createdAt}",
                    startIcon = img to color
                )
            }

            item("shadow_bottom_space") {
                ShadowFooterSpace()
            }
        }

        Header()

        ShadowFooter(
            modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),
            close = close,
            primary = "update" to update
        )
    }
}