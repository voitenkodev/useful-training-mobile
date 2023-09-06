package components

import Design
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import controls.TextFieldBody1
import presentation.training.Exercise
import recomposeHighlighter

@Composable
internal fun ExerciseItem(
    modifier: Modifier = Modifier,
    provideNumber: () -> Int,
    exercise: () -> Exercise
) {

    Row(
        modifier = modifier
            .padding(top = 8.dp, start = 4.dp, end = 4.dp)
            .recomposeHighlighter(),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {

        TextFieldBody1(
            modifier = Modifier.recomposeHighlighter(),
            provideText = { "${provideNumber()}." },
            fontWeight = FontWeight.Bold
        )

        InternalExercise(
            exercise = exercise
        )
    }
}

@Composable
private fun InternalExercise(
    exercise: () -> Exercise
) {

    Column(
        modifier = Modifier.recomposeHighlighter(),
    ) {

        TextFieldBody1(
            modifier = Modifier.recomposeHighlighter(),
            provideText = { exercise().name },
            fontWeight = FontWeight.Bold
        )

        FlowRow(
            modifier = Modifier
                .padding(top = 6.dp, bottom = 4.dp)
                .recomposeHighlighter(),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            exercise().iterations.forEach {
                TextFieldBody1(
                    modifier = Modifier.padding(end = 4.dp).recomposeHighlighter(),
                    provideText = { it.weight + "x" + it.repeat },
                    color = Design.colors.caption
                )
            }
        }
    }
}