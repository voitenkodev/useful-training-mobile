package components.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import DesignComponent
import controls.IterationVerticalGrid
import controls.TextFieldBody1
import models.ExerciseComponent

@Composable
fun ExerciseItem(
    modifier: Modifier = Modifier,
    number: Int,
    exercise: ExerciseComponent
) = Row(
    modifier = modifier.padding(top = 8.dp),
    horizontalArrangement = Arrangement.spacedBy(4.dp)
) {
    Row(
        modifier = Modifier.padding(top = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {

        TextFieldBody1(text = "${number}.", fontWeight = FontWeight.Bold)

        Column {

            TextFieldBody1(text = exercise.name, fontWeight = FontWeight.Bold)

            IterationVerticalGrid(
                modifier = Modifier.padding(top = 6.dp, bottom = 4.dp),
                spacing = 4.dp,
            ) {
                exercise.iterations.forEach {
                    TextFieldBody1(
                        modifier = Modifier.padding(end = 4.dp),
                        text = it.weight + "x" + it.repeat,
                        color = DesignComponent.colors.caption
                    )
                }
            }
        }
    }
}