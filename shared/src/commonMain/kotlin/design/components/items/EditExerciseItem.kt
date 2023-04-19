package design.components.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import design.controls.DividerPrimary
import design.controls.secondaryBackground
import presentation.training.Iteration
import utils.recomposeHighlighter

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun EditExerciseItem(
    modifier: Modifier = Modifier,
    provideNumber: () -> Int,
    provideIterations: () -> List<Iteration>,
    provideName: () -> String,
    updateName: (String) -> Unit,
    updateWeight: (Int, String) -> Unit,
    updateRepeat: (Int, String) -> Unit,
    remove: () -> Unit,
) {
    Column(
        modifier = modifier.secondaryBackground().recomposeHighlighter()
    ) {
        InputNameItem(
            modifier = Modifier.padding(start = 8.dp).recomposeHighlighter(),
            provideNumber = provideNumber,
            provideName = provideName,
            update = updateName,
            remove = remove
        )

        DividerPrimary(modifier = Modifier.padding(horizontal = 12.dp))

        FlowRow(
            modifier = Modifier.padding(top = 4.dp, bottom = 8.dp, start = 4.dp, end = 4.dp).recomposeHighlighter(),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {

            IterationCaptionItem()

            provideIterations().forEachIndexed { index, iteration ->
                IterationInputItem(
                    modifier = Modifier.recomposeHighlighter(),
                    provideWeight = { iteration.weight },
                    provideRepeat = { iteration.repeat },
                    updateWeight = { updateWeight.invoke(index, it) },
                    updateRepeat = { updateRepeat.invoke(index, it) }
                )
            }
        }
    }
}