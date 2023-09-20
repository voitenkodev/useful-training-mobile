package components

import Design
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import controls.secondaryBackground
import recomposeHighlighter
import training.Training

@Composable
internal fun Exercises(training: Training) {

    val exes = rememberUpdatedState(training.exercises)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .secondaryBackground()
            .padding(Design.dp.paddingS)
    ) {

        exes.value.forEachIndexed { index, item ->

            val number by rememberUpdatedState(index + 1)

            Exercise(
                modifier = Modifier.recomposeHighlighter(),
                provideNumber = { number },
                exercise = { item }
            )
        }
    }
}