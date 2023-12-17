package exerciseexample.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import atom.Design
import basic.LineChart
import basic.LineChartDotsStyle
import basic.LineChartLabelStyle
import basic.LineChartStyle
import molecule.ButtonIconTransparent
import molecule.IconSecondary
import molecule.TextBody3
import molecule.TextH4
import molecule.TextLabel
import molecule.coloredDefaultBackgroundNoBorder
import molecule.secondaryDefaultBackground
import resources.Icons

@Composable
internal fun ResentVolume() {

    val list = listOf(
        1000f to "14.11.2023",
        6900f to "18.11.2023",
        2000f to "20.11.2023",
        3000f to "22.11.2023",
        5000f to "24.11.2023"
    ) // TODO ADD REQUEST

    val reversed = remember(list) { list.reversed() }

    Column(
        modifier = Modifier.padding(horizontal = Design.dp.paddingM),
        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
    ) {

        TextLabel(provideText = { "Recent volume results" })

        LineChart(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .padding(start = Design.dp.paddingM, end = Design.dp.paddingM, top = Design.dp.paddingS, bottom = Design.dp.paddingS),
            values = list.map { it.first },
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

        repeat(reversed.size) {

            val item = reversed.getOrNull(it) ?: return
            val previousItem = reversed.getOrNull(it + 1)?.first ?: 0f

            val color = if (item.first > previousItem) Design.colors.toxic.copy(alpha = 0.5f)
            else Design.colors.orange.copy(alpha = 0.5f)

            val img = if (item.first > previousItem) Icons.arrowUp
            else Icons.arrowDown

            VolumeItem(
                modifier = Modifier
                    .secondaryDefaultBackground()
                    .padding(Design.dp.paddingS),
                title = item.first.toString(),
                subTitle = item.second,
                icon = img,
                color = color,
                onClick = {}
            )
        }
    }
}

@Composable
private fun VolumeItem(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String,
    icon: ImageVector,
    color: Color,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconSecondary(
            modifier = Modifier
                .size(Design.dp.componentS)
                .coloredDefaultBackgroundNoBorder(color)
                .padding(Design.dp.paddingS),
            color = Design.colors.content,
            imageVector = icon
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {

            TextH4(
                provideText = { title }
            )

            TextBody3(
                provideText = { subTitle },
                color = Design.colors.caption
            )
        }

        ButtonIconTransparent(
            imageVector = Icons.arrowRight,
            onClick = onClick
        )
    }
}