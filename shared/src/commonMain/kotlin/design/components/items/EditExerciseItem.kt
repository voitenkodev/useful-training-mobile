package design.components.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import design.components.inputs.InputExerciseName
import design.controls.DividerPrimary
import design.controls.secondaryBackground
import presentation.training.Iteration
import utils.recomposeHighlighter

@Composable
fun EditExerciseItem(
    modifier: Modifier = Modifier,
    number: () -> Int,
    iterations: () -> List<Iteration>,
    nameOptions: () -> List<String>,
    name: () -> String,
    updateName: (String) -> Unit,
    updateWeight: (Int, String) -> Unit,
    updateRepeat: (Int, String) -> Unit,
    remove: () -> Unit,
) {
    Column(
        modifier = modifier.secondaryBackground()
    ) {

        val focusManager = LocalFocusManager.current

        val helpVisible = remember { mutableStateOf(false) }

        InputExerciseName(
            modifier = Modifier
                .padding(start = 8.dp)
                .onFocusChanged { helpVisible.value = it.hasFocus }
                .recomposeHighlighter(),
            provideNumber = number,
            provideName = name,
            update = updateName,
            remove = remove
        )

        HelpExerciseNameItem(
            querySort = name,
            visibility = { helpVisible.value },
            select = {
                updateName.invoke(it)
                focusManager.clearFocus()
            },
            options = nameOptions
        )

        DividerPrimary(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .recomposeHighlighter()
        )

        WeightRepeatSection(
            iterations = iterations,
            updateWeight = updateWeight,
            updateRepeat = updateRepeat
        )
    }
}

@Composable
private fun WeightRepeatSection(
    iterations: () -> List<Iteration>,
    updateWeight: (Int, String) -> Unit,
    updateRepeat: (Int, String) -> Unit
) {
    FlowRow(
        modifier = Modifier
            .padding(top = 4.dp, bottom = 8.dp, start = 12.dp, end = 12.dp)
            .recomposeHighlighter(),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
    ) {

        IterationCaptionItem()

        iterations().forEachIndexed { index, iteration ->

            val indexProvider by rememberUpdatedState(index)
            val weightProvider by rememberUpdatedState(iteration.weight)
            val repeatProvider by rememberUpdatedState(iteration.repeat)

            IterationInputItem(
                modifier = Modifier.recomposeHighlighter(),
                provideWeight = { weightProvider },
                provideRepeat = { repeatProvider },
                updateWeight = { updateWeight.invoke(indexProvider, it) },
                updateRepeat = { updateRepeat.invoke(indexProvider, it) }
            )
        }
    }
}