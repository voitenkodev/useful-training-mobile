package design.components.items

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import design.controls.DividerPrimary
import design.controls.IterationVerticalGrid
import design.controls.secondaryBackground
import presentation.training.Exercise

@Composable
internal fun EditExerciseItem(
    modifier: Modifier = Modifier,
    number: Int,
    exercise: Exercise,
    updateName: (id: String, value: String) -> Unit,
    removeExercise: (id: String) -> Unit,
    updateWeight: (id: String, num: Int, value: String) -> Unit,
    updateRepeat: (id: String, num: Int, value: String) -> Unit
) = Column(
    modifier = modifier.secondaryBackground()
) {
    InputNameItem(
        number = number,
        showHelp = {},
        isHelpShowed = false,
        name = exercise.name,
        update = { updateName.invoke(exercise.id, it) },
        remove = { removeExercise.invoke(exercise.id) }
    )

    DividerPrimary(modifier = Modifier.padding(horizontal = 12.dp))

    IterationVerticalGrid(
        modifier = Modifier.padding(top = 4.dp, bottom = 8.dp, start = 4.dp, end = 4.dp),
        spacing = 4.dp
    ) {

        IterationCaptionItem()

        exercise.iterations.forEachIndexed { index, iteration ->
            IterationInputItem(
                provideWeight = { iteration.weight },
                provideRepeat = { iteration.repeat },
                updateWeight = { updateWeight.invoke(exercise.id, index, it) },
                updateRepeat = { updateRepeat.invoke(exercise.id, index, it) }
            )
        }
    }
}