package trainingbuilder.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.inputs.InputExerciseName
import trainingbuilder.state.Iteration

@Composable
internal fun EditExercise(
    modifier: Modifier = Modifier,
    number: () -> Int,
    iterations: () -> List<Iteration>,
    name: () -> String,
    updateName: (String) -> Unit,
    updateWeight: (Int, String) -> Unit,
    updateRepeat: (Int, String) -> Unit,
    remove: () -> Unit,
) {
    Column(modifier = modifier) {

        InputExerciseName(
            modifier = Modifier.padding(start = 8.dp),
            provideNumber = number,
            provideName = name,
            update = updateName,
            remove = remove
        )

        WeightRepeatSection(
            iterations = iterations,
            updateWeight = updateWeight,
            updateRepeat = updateRepeat
        )
    }
}