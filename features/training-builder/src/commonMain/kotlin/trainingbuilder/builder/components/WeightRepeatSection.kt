package trainingbuilder.builder.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.items.IterationCaptionItem
import components.items.IterationInputItem
import trainingbuilder.builder.state.Iteration

@Composable
internal fun WeightRepeatSection(
    iterations: () -> List<Iteration>,
    updateWeight: (Int, String) -> Unit,
    updateRepeat: (Int, String) -> Unit
) {
    FlowRow(
        modifier = Modifier.padding(top = 4.dp, bottom = 8.dp, start = 12.dp, end = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
    ) {

        IterationCaptionItem()

        iterations().forEachIndexed { index, iteration ->

            val indexProvider by rememberUpdatedState(index)
            val weightProvider by rememberUpdatedState(iteration.weight)
            val repetitionsProvider by rememberUpdatedState(iteration.repetitions)

            IterationInputItem(
                provideWeight = { weightProvider },
                provideRepeat = { repetitionsProvider },
                updateWeight = { updateWeight.invoke(indexProvider, it) },
                updateRepeat = { updateRepeat.invoke(indexProvider, it) }
            )
        }
    }
}