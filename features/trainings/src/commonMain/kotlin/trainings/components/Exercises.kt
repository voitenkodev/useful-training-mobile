package trainings.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import components.ExerciseItem
import controls.TextFieldH2
import recomposeHighlighter
import training.Training

@Composable
internal fun Exercises(
    training: Training,
) {

    val exes = rememberUpdatedState(training.exercises)

    TextFieldH2(
        provideText = { "EXERCISES" }
    )

    exes.value.forEachIndexed { index, item ->

        val number by rememberUpdatedState(index + 1)

        ExerciseItem(
            modifier = Modifier.recomposeHighlighter(),
            provideNumber = { number },
            exercise = { item }
        )
    }
}