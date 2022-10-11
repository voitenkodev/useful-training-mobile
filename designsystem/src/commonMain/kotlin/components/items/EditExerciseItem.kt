package components.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import DesignComponent
import components.inputs.InputExerciseName
import components.inputs.InputRepeat
import components.inputs.InputWeight
import components.labels.AccentLabel
import controls.DividerPrimary
import controls.IconPrimary
import controls.IterationVerticalGrid
import controls.TextFieldBody2
import controls.secondaryBackground
import models.ExerciseComponent

@Composable
fun EditExerciseItem(
    modifier: Modifier = Modifier,
    number: Int,
    exercise: ExerciseComponent,
    updateName: (String) -> Unit,
    removeExercise: () -> Unit,
    updateWeight: (Int, String) -> Unit,
    updateRepeat: (Int, String) -> Unit
) = Column(
    modifier = modifier.secondaryBackground()
) {
    InputNameItem(
        number = number,
        showHelp = mutableStateOf(value = false),
        name = exercise.name,
        update = updateName,
        remove = removeExercise
    )

    DividerPrimary(modifier = Modifier.padding(horizontal = 12.dp))

    IterationVerticalGrid(
        modifier = Modifier.padding(top = 4.dp, bottom = 8.dp, start = 4.dp, end = 4.dp),
        spacing = 4.dp
    ) {

        IterationCaptionItem()

        exercise.iterations.forEachIndexed { index, iteration ->
            IterationInputItem(
                weight = iteration.weight,
                repeat = iteration.repeat,
                updateWeight = { updateWeight.invoke(index, it) },
                updateRepeat = { updateRepeat.invoke(index, it) }
            )
        }
    }
}

@Composable
private fun InputNameItem(
    number: Int,
    showHelp: MutableState<Boolean>,
    name: String,
    update: (String) -> Unit,
    remove: () -> Unit
) = Row(
    modifier = Modifier.padding(start = 8.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(4.dp)
) {

    AccentLabel(
        modifier = Modifier.padding(bottom = 8.dp, top = 8.dp, end = 4.dp),
        text = "$number",
    )

    InputExerciseName(
        modifier = Modifier.onFocusChanged { showHelp.value = it.hasFocus }.weight(1f),
        value = name,
        onValueChange = { update.invoke(it) },
    )

    IconPrimary(
        modifier = Modifier.height(20.dp).width(50.dp),
        imageVector = Icons.Filled.Delete,
        color = DesignComponent.colors.caption,
        onClick = { remove.invoke() },
    )
}

@Composable
private fun IterationCaptionItem() = Column(modifier = Modifier.padding(vertical = 4.dp)) {
    TextFieldBody2(
        modifier = Modifier
            .fillMaxHeight()
            .wrapContentWidth()
            .padding(top = 8.dp, start = 8.dp, end = 8.dp, bottom = 10.dp),
        text = "• Weight",
        textAlign = TextAlign.Center,
        color = DesignComponent.colors.caption,
        maxLines = 1,
        fontWeight = FontWeight.Bold
    )

    TextFieldBody2(
        modifier = Modifier
            .fillMaxHeight()
            .wrapContentWidth()
            .padding(top = 10.dp, start = 8.dp, end = 8.dp, bottom = 8.dp),
        text = "• Repeat",
        color = DesignComponent.colors.caption,
        textAlign = TextAlign.Center,
        maxLines = 1,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun IterationInputItem(
    modifier: Modifier = Modifier,
    weight: String,
    repeat: String,
    updateWeight: (value: String) -> Unit,
    updateRepeat: (value: String) -> Unit
) = Column(modifier = modifier.width(60.dp).padding(vertical = 4.dp)) {

    InputWeight(
        value = weight,
        onValueChange = updateWeight
    )

    DividerPrimary(
        modifier = Modifier.padding(horizontal = 8.dp)
    )

    InputRepeat(
        value = repeat,
        onValueChange = updateRepeat
    )
}
