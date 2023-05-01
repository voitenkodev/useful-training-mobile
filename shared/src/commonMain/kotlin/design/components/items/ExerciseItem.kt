package design.components.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import design.Design
import design.controls.IterationVerticalGrid
import design.controls.TextFieldBody1
import presentation.training.Exercise

@Composable
internal fun ExerciseItem(
    modifier: Modifier = Modifier,
    number: Int,
    exercise: Exercise
) = Row(
    modifier = modifier.padding(horizontal = 4.dp),
    horizontalArrangement = Arrangement.spacedBy(4.dp)
) {
    Row(
        modifier = Modifier.padding(top = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {

        TextFieldBody1(provideText = { "${number}." }, fontWeight = FontWeight.Bold)

        Column {

            TextFieldBody1(provideText = { exercise.name }, fontWeight = FontWeight.Bold)

            IterationVerticalGrid(
                modifier = Modifier.padding(top = 6.dp, bottom = 4.dp),
                spacing = 4.dp,
            ) {
                exercise.iterations.forEach {
                    TextFieldBody1(
                        modifier = Modifier.padding(end = 4.dp),
                        provideText = { it.weight + "x" + it.repeat },
                        color = Design.colors.caption
                    )
                }
            }
        }
    }
}