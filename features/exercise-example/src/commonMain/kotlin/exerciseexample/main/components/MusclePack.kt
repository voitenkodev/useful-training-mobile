package exerciseexample.main.components

import ColorUtils
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import components.chips.Chip
import components.chips.ChipState
import exerciseexample.main.models.ExerciseExample
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import molecule.TextLabel
import percents
import pie.PieChart
import pie.PieChartData

@Composable
internal fun MusclePack(exerciseExample: ExerciseExample?) {

    val pieData = remember(exerciseExample) {
        exerciseExample?.exerciseExampleBundles
            ?.map { PieChartData(value = it.percentage, color = ColorUtils.randomColor(), title = it.muscle.name) }
            ?.sortedByDescending { it.value }
            ?.toPersistentList()
            ?: persistentListOf()
    }

    Column(
        modifier = Modifier.padding(horizontal = Design.dp.paddingM),
        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
    ) {

        TextLabel(provideText = { "Muscle Pack" })

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {

            Column(
                modifier = Modifier.weight(0.6f),
                verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
            ) {
                repeat(pieData.size) {

                    val item = pieData.getOrNull(it) ?: return@repeat

                    Chip(
                        chipState = ChipState.Colored(
                            backgroundColor = item.color.copy(alpha = 0.2f),
                            borderColor = item.color,
                            contentColor = Design.colors.content
                        ),
                        text = buildString {
                            append(item.title)
                            append(" ")
                            append(item.value.percents())
                        }
                    )
                }
            }

            PieChart(
                modifier = Modifier.padding(Design.dp.paddingM).weight(0.4f).aspectRatio(1f),
                data = pieData
            )
        }
    }
}