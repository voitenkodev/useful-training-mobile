package trainingbuilder.builder.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import components.inputs.InputExerciseName
import molecule.PaddingM
import trainingbuilder.builder.state.Iteration

@Composable
internal fun EditExercise(
    modifier: Modifier = Modifier,
    number: () -> Int,
    iterations: () -> List<Iteration>,
    name: () -> String,
    updateName: (String) -> Unit,
    updateWeight: (Int, String) -> Unit,
    updateRepeat: (Int, String) -> Unit
) {
    Column(modifier = modifier) {

        PaddingM()

        InputExerciseName(
            provideNumber = number,
            provideName = name,
            update = updateName,
        )

        WeightRepeatSection(
            iterations = iterations,
            updateWeight = updateWeight,
            updateRepeat = updateRepeat
        )
    }
}