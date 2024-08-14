package weighthistory.main.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
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
import kotlinx.collections.immutable.ImmutableList
import molecule.PaddingM
import molecule.PaddingS
import molecule.Shadow
import molecule.Toolbar
import resources.Icons
import weighthistory.main.models.WeightHistory

@Composable
internal fun Header(
    modifier: Modifier = Modifier,
    weightHistory: ImmutableList<WeightHistory>,
    close: () -> Unit
) {

    val reversedList = remember(weightHistory) {
        weightHistory.reversed().takeLast(5)
    }

    Column(modifier = modifier.statusBarsPadding()) {

        PaddingS()

        Toolbar(title = "Weight History", icon = Icons.close to close)

        PaddingM()

        Column(
            modifier = modifier
                .padding(horizontal = Design.dp.paddingL)
                .align(Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (reversedList.size > 1) {
                LineChart(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(130.dp),
                    values = reversedList.map { it.weight.toFloat() },
                    chartStyle = LineChartStyle(
                        lineColor = Design.colors.content,
                        labelStyle = LineChartLabelStyle(
                            backgroundColor = Design.colors.green.copy(alpha = 0.2f),
                            borderColor = Design.colors.green,
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
                    modifier = Modifier.border(
                        width = 1.dp,
                        color = Design.colors.white10,
                        shape = Design.shape.default
                    ).height(130.dp),
                    title = "Chart is unavailable",
                    description = "Provide mode data"
                )
            }
        }

        PaddingM()

        Shadow()
    }
}