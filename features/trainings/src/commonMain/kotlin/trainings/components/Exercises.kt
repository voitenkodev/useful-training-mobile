package trainings.components

import Design
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import recomposeHighlighter
import trainings.state.Training

@Composable
internal fun Exercises(
    modifier: Modifier = Modifier,
    training: Training
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(Design.dp.paddingS)
    ) {

        training.exercises.forEachIndexed { index, item ->

            val number by rememberUpdatedState(index + 1)

            Exercise(
                modifier = Modifier.recomposeHighlighter(),
                number = { number },
                exercise = item
            )
        }

        Spacer(
            modifier = Modifier.size(Design.dp.paddingM)
        )
    }
}