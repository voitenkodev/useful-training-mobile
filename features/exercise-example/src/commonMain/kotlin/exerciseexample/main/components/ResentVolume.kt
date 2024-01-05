package exerciseexample.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import atom.Design
import basic.LineChart
import basic.LineChartDotsStyle
import basic.LineChartLabelStyle
import basic.LineChartStyle
import components.cards.HorizontalValueCard
import exerciseexample.main.models.ExerciseVolume
import kg
import kotlinx.collections.immutable.ImmutableList
import molecule.Shadow
import molecule.TextLabel
import resources.Icons

@Composable
internal fun ResentVolume(volumes: ImmutableList<ExerciseVolume>) {


    val reversed = remember(volumes) { volumes.reversed() }

    Column(
        modifier = Modifier.background(Design.colors.black10),
        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
    ) {

        Shadow()

        TextLabel(
            modifier = Modifier.padding(top = Design.dp.paddingS).padding(horizontal = Design.dp.paddingM),
            provideText = { "Recent volume results" }
        )

        LineChart(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Design.dp.paddingXL)
                .height(130.dp),
            values = volumes.map { it.volume.toFloat() },
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
            val previousItem = reversed.getOrNull(it + 1)?.volume ?: 0.0

            val color = if (item.volume > previousItem) Design.colors.toxic.copy(alpha = 0.5f)
            else Design.colors.orange.copy(alpha = 0.5f)

            val img = if (item.volume > previousItem) Icons.arrowUp
            else Icons.arrowDown

            HorizontalValueCard(
                modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                title = item.volume.kg(true),
                description = "At: ${item.createdAt}",
                startIcon = img to color,
                actionEndIcon = Icons.arrowRight to {}
            )
        }

        Shadow()
    }
}