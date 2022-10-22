package components.items

import DesignComponent
import LineChart
import PointLine
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import controls.TextFieldBody2
import controls.secondaryBackground

@Composable
fun LineChartItem(
    modifier: Modifier = Modifier,
    lines: List<PointLine>,
    onClick: (PointLine, Int) -> Unit
) = LineChartBox(
    modifier = modifier
        .secondaryBackground()
        .padding(DesignComponent.size.space),
    lines = lines,
    onClick = onClick
)

@Composable
private fun LineChartBox(
    modifier: Modifier = Modifier,
    lines: List<PointLine>,
    onClick: (PointLine, Int) -> Unit
) {

    val minY = lines.minOfOrNull { it.yValue.min() }?.toInt() ?: 0
    val maxY = lines.maxOfOrNull { it.yValue.max() }?.toInt() ?: 0
    val middleY = ((minY + maxY) / 2)
    val threeQuartersY = ((maxY + middleY) / 2)
    val quarterY = ((minY + middleY) / 2)
    val maxCount = lines.maxOfOrNull { it.yValue.lastIndex } ?: 0

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(DesignComponent.size.space)
    ) {

        NameLabels(
            lines = lines
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(DesignComponent.size.space)
        ) {
            YLabels(
                modifier = Modifier.fillMaxHeight(),
                maxY = maxY,
                threeQuartersY = threeQuartersY,
                middleY = middleY,
                quarterY = quarterY,
                minY = minY
            )

            Column {
                LineChart(
                    modifier = Modifier.weight(1f).fillMaxWidth(),
                    lines = lines,
                    onClick = onClick
                )

                XLabels(
                    modifier = Modifier.fillMaxWidth(),
                    maxCount = maxCount
                )
            }
        }
    }
}

@Composable
private fun NameLabels(
    modifier: Modifier = Modifier,
    lines: List<PointLine>
) = LazyRow(
    modifier = modifier,
    horizontalArrangement = Arrangement.spacedBy(DesignComponent.size.space),
    content = { itemsIndexed(lines, key = { index, _ -> index }) { _, item -> Label(label = item.label, color = item.lineColor) } }
)

@Composable
private fun XLabels(
    modifier: Modifier = Modifier,
    maxCount: Int
) = Row(
    modifier = modifier.height(24.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.Bottom
) {
    for (index in 0..maxCount step 1) {
        TextFieldBody2(text = (index + 1).toString())
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
) = Column(
    modifier = modifier,
    verticalArrangement = Arrangement.SpaceBetween
) {

    TextFieldBody2(
        text = maxY.toString(),
        textAlign = TextAlign.End
    )

    TextFieldBody2(
        text = threeQuartersY.toString(),
        textAlign = TextAlign.End
    )

    TextFieldBody2(
        text = middleY.toString(),
        textAlign = TextAlign.End
    )

    TextFieldBody2(
        text = quarterY.toString(),
        textAlign = TextAlign.End
    )

    TextFieldBody2(
        text = minY.toString(),
        textAlign = TextAlign.End
    )

    Spacer(modifier = Modifier.size(20.dp))
}

@Composable
private fun Label(
    modifier: Modifier = Modifier,
    label: String,
    color: Color,
) = Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.spacedBy(DesignComponent.size.space),
    verticalAlignment = Alignment.CenterVertically
) {
    Spacer(Modifier.size(14.dp).background(color))
    TextFieldBody2(text = label, color = DesignComponent.colors.caption)
}