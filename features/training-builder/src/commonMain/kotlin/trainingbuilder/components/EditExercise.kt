package trainingbuilder.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import components.inputs.InputExerciseName
import components.items.HelpExerciseNameItem
import controls.DividerPrimary
import controls.quaternaryBackground
import recomposeHighlighter
import trainingbuilder.state.Iteration

@Composable
internal fun EditExercise(
    modifier: Modifier = Modifier,
    number: () -> Int,
    iterations: () -> List<Iteration>,
    nameOptions: () -> List<String>,
    name: () -> String,
    removeNameOption: (String) -> Unit,
    updateName: (String) -> Unit,
    updateWeight: (Int, String) -> Unit,
    updateRepeat: (Int, String) -> Unit,
    remove: () -> Unit,
) {
    Column(
        modifier = modifier.quaternaryBackground()
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
            remove = removeNameOption,
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