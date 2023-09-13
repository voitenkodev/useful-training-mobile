package components.items

import Design
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import chart.LineChart
import chart.PointLine
import controls.TextFieldBody2
import controls.secondaryBackground
import recomposeHighlighter

@Composable
fun LineChartItem(
    modifier: Modifier = Modifier,
    lines: () -> List<PointLine>,
) {
    LineChartBox(
        modifier = modifier
            .secondaryBackground()
            .padding(Design.dp.paddingM),
        lines = lines,
    )
}

@Composable
private fun LineChartBox(
    modifier: Modifier = Modifier,
    lines: () -> List<PointLine>,
) {

    val minY = remember(lines()) { lines().minOfOrNull { it.yValue.min() }?.toInt() ?: 0 }
    val maxY = remember(lines()) { lines().maxOfOrNull { it.yValue.max() }?.toInt() ?: 0 }
    val middleY = remember(lines()) { ((minY + maxY) / 2) }
    val threeQuartersY = remember(lines()) { ((maxY + middleY) / 2) }
    val quarterY = remember(lines()) { ((minY + middleY) / 2) }
    val maxCount = remember(lines()) { lines().maxOfOrNull { it.yValue.lastIndex } ?: 0 }

    Column(
        modifier = modifier.recomposeHighlighter(),
        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
    ) {

        NameLabels(
            lines = lines
        )

        Row(
            modifier = Modifier.recomposeHighlighter(),
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {
            YLabels(
                modifier = Modifier
                    .fillMaxHeight()
                    .recomposeHighlighter(),
                maxY = maxY,
                threeQuartersY = threeQuartersY,
                middleY = middleY,
                quarterY = quarterY,
                minY = minY
            )

            Column {
                LineChart(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .recomposeHighlighter(),
                    lines = lines,
                )

                XLabels(
                    modifier = Modifier
                        .fillMaxWidth()
                        .recomposeHighlighter(),
                    maxCount = maxCount
                )
            }
        }
    }
}

@Composable
private fun NameLabels(
    modifier: Modifier = Modifier,
    lines: () -> List<PointLine>
) {
    LazyRow(
        modifier = modifier.recomposeHighlighter(),
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
        content = {
            itemsIndexed(lines(), key = { index, _ -> index }) { _, item ->
                Label(label = item.label, color = item.lineColor)
            }
        }
    )
}

@Composable
private fun XLabels(
    modifier: Modifier = Modifier,
    maxCount: Int
) = Row(
    modifier = modifier
        .height(24.dp)
        .recomposeHighlighter(),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.Bottom
) {
    val texts = remember(maxCount) {
        List(maxCount) { index -> (index + 1).toString() }
    }

    texts.forEach {
        TextFieldBody2(
            modifier = Modifier.recomposeHighlighter(),
            provideText = { it })
    }
}

@Composable
private fun YLabels(
    modifier: Modifier = Modifier,
    maxY: Int,
    threeQuartersY: Int,
    middleY: Int,
    quarterY: Int,
    minY: Int
) {
    val max = remember(maxY) { maxY.toString() }
    val min = remember(maxY) { minY.toString() }
    val middle = remember(maxY) { middleY.toString() }
    val quarter = remember(maxY) { quarterY.toString() }
    val threeQuarters = remember(maxY) { threeQuartersY.toString() }

    Column(
        modifier = modifier.recomposeHighlighter(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        TextFieldBody2(
            modifier = Modifier.recomposeHighlighter(),
            provideText = { max },
            textAlign = TextAlign.End
        )

        TextFieldBody2(
            modifier = Modifier.recomposeHighlighter(),
            provideText = { threeQuarters },
            textAlign = TextAlign.End
        )

        TextFieldBody2(
            modifier = Modifier.recomposeHighlighter(),
            provideText = { middle },
            textAlign = TextAlign.End
        )

        TextFieldBody2(
            modifier = Modifier.recomposeHighlighter(),
            provideText = { quarter },
            textAlign = TextAlign.End
        )

        TextFieldBody2(
            modifier = Modifier.recomposeHighlighter(),
            provideText = { min },
            textAlign = TextAlign.End
        )

        Spacer(
            modifier = Modifier
                .size(20.dp)
                .recomposeHighlighter(),
        )
    }
}

@Composable
private fun Label(
    modifier: Modifier = Modifier,
    label: String,
    color: Color,
) = Row(
    modifier = modifier.recomposeHighlighter(),
    horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
    verticalAlignment = Alignment.CenterVertically
) {
    Spacer(
        Modifier
            .size(14.dp)
            .background(
                color = color,
                shape = CircleShape
            ).recomposeHighlighter(),
    )

    TextFieldBody2(
        modifier = Modifier.recomposeHighlighter(),
        provideText = { label },
        color = Design.colors.caption
    )
}