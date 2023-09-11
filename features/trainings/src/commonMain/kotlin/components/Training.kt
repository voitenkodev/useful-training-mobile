package components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.overlay.shadowBottomFrame
import recomposeHighlighter
import training.Training

@Composable
internal fun ColumnScope.TrainingComponent(
    modifier: Modifier = Modifier,
    training: Training,
) {

    val exes = rememberUpdatedState(training.exercises)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
    ) {

        Column(
            modifier = modifier
                .fillMaxSize()
                .recomposeHighlighter()
        ) {

            exes.value.forEachIndexed { index, item ->

                val number by rememberUpdatedState(index + 1)

                ExerciseItem(
                    modifier = Modifier.recomposeHighlighter(),
                    provideNumber = { number },
                    exercise = { item }
                )
            }
        }

        Spacer(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(220.dp)
                .shadowBottomFrame()
        )
    }
}