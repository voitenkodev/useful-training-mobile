package design.components.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import design.controls.DividerPrimary
import design.controls.secondaryBackground
import presentation.training.Iteration

@Composable
fun EditExerciseItem(
    modifier: Modifier = Modifier,
    number: () -> Int,
    iterations: () -> List<Iteration>,
    name: () -> String,
    updateName: (String) -> Unit,
    updateWeight: (Int, String) -> Unit,
    updateRepeat: (Int, String) -> Unit,
    remove: () -> Unit,
) {
    Column(
        modifier = modifier.secondaryBackground()
    ) {

        InputNameItem(
            modifier = Modifier.padding(start = 8.dp),
            provideNumber = number,
            provideName = name,
            update = updateName,
            remove = remove
        )

        DividerPrimary(modifier = Modifier.padding(horizontal = 12.dp))

        WeightRepeatSection(
            iterations = iterations,
            updateWeight = updateWeight,
            updateRepeat = updateRepeat
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun WeightRepeatSection(
    iterations: () -> List<Iteration>,
    updateWeight: (Int, String) -> Unit,
    updateRepeat: (Int, String) -> Unit
) {
    FlowRow(
        modifier = Modifier.padding(top = 4.dp, bottom = 8.dp, start = 4.dp, end = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {

        IterationCaptionItem()

        iterations().forEachIndexed { index, iteration ->

            val indexProvider by rememberUpdatedState(index)
            val weightProvider by rememberUpdatedState(iteration.weight)
            val repeatProvider by rememberUpdatedState(iteration.repeat)

            IterationInputItem(
                modifier = Modifier,
                provideWeight = { weightProvider },
                provideRepeat = { repeatProvider },
                updateWeight = { updateWeight.invoke(indexProvider, it) },
                updateRepeat = { updateRepeat.invoke(indexProvider, it) }
            )
        }
    }
}