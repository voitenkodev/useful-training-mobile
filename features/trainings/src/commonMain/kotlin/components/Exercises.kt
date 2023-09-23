package components

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
import controls.tertiaryBackground
import recomposeHighlighter
import training.Training

@Composable
internal fun Exercises(
    modifier: Modifier = Modifier,
    training: Training
) {

    val exes = rememberUpdatedState(training.exercises)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .tertiaryBackground()
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

        Spacer(
            modifier = Modifier.size(Design.dp.paddingM)
        )
    }
}