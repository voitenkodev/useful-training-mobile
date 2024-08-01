package weighthistory.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import components.EmptyData
import components.Error
import components.ShadowFooter
import components.ShadowFooterSpace
import components.ShadowHeader
import components.ShadowHeaderSpace
import components.cards.WeightCard
import components.roots.ScreenRoot
import kg
import kotlinx.collections.immutable.ImmutableList
import molecule.PaddingM
import molecule.PaddingS
import molecule.PaddingXXL
import molecule.PopupSheet
import molecule.TextH4
import resources.Icons
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
        ) {

            item("shadow_top_space") {
                ShadowHeaderSpace()
            }

            item("chart") {
                if (reversedList.size > 1) {
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
                } else {
                    EmptyData(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = Design.dp.paddingXL)
                            .height(130.dp),
                        title = "Chart is unavailable",
                        description = "Provide mode data"
                    )
                }
            }

            item {
                PaddingXXL()
                PaddingM()
            }

            item {
                TextH4(
                    modifier = Modifier.padding(horizontal = Design.dp.paddingL),
                    provideText = { "History" },
                    color = Design.colors.caption
                )
            }

            item { PaddingS() }

            itemsIndexed(weightHistory, key = { _, item -> item.id }) { index, item ->

                val previousWeight = weightHistory.getOrNull(index + 1)?.weight ?: 0.0

                val color = if (item.weight > previousWeight) Design.colors.toxic
                else Design.colors.orange

                val img = if (item.weight > previousWeight) Icons.arrowUp
                else Icons.arrowDown

                WeightCard(
                    modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                    title = item.weight.kg(true),
                    description = "At: ${item.createdAt}",
                    startIcon = img to color
                )

                if (index != weightHistory.lastIndex) {
                    PaddingM()
                }
            }

            item("shadow_bottom_space") {
                ShadowFooterSpace()
            }
        }

        ShadowHeader(
            title = "Weight History"
        )

        ShadowFooter(
            modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),
            close = close,
            primary = Triple("Update", true, update)
        )
    }
}