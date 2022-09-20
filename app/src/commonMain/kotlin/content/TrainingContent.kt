package content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import designsystem.common.DesignComponent
import designsystem.components.AccentLabel
import designsystem.components.InputName
import designsystem.components.InputRepeat
import designsystem.components.InputWeight
import designsystem.controls.*
import state.*

@Composable
fun TrainingContent(
    modifier: Modifier = Modifier,
    state: TrainingState,
    update: (TrainingState) -> Unit,
    save: (TrainingState) -> Unit,
) = Column(
    modifier = modifier
        .fillMaxSize()
        .padding(bottom = DesignComponent.size.rootSpace),
) {
    ExerciseList(
        state = state,
        update = update,
        save = save
    )
    SaveTrainingItem(onClick = { save.invoke(state) })
}

@Composable
private fun ColumnScope.ExerciseList(
    state: TrainingState,
    update: (TrainingState) -> Unit,
    save: (TrainingState) -> Unit,
) = LazyColumn(
    modifier = Modifier.weight(1f),
    contentPadding = PaddingValues(DesignComponent.size.rootSpace),
    verticalArrangement = Arrangement.spacedBy(DesignComponent.size.itemSpace),
) {

    itemsIndexed(state.exercises, key = { index, exercise -> exercise.id }) { index, exercise ->
        Column(
            modifier = Modifier
                .animateItemPlacement()
                .background(
                    color = DesignComponent.colors.secondary,
                    shape = DesignComponent.shape.maxShape
                )
        ) {
            InputNameItem(
                number = index + 1,
                showHelp = mutableStateOf(value = false),
                exercise = exercise,
                update = { update.invoke(state.updateExercise(it)) },
                remove = { update.invoke(state.removeExercise(it)) })

            DividerPrimary(modifier = Modifier.padding(horizontal = 12.dp))

            IterationVerticalGrid(
                modifier = Modifier.padding(top = 4.dp, bottom = 8.dp, start = 4.dp, end = 4.dp),
                spacing = 4.dp
            ) {

                IterationCaptionItem()

                exercise.iterations.forEachIndexed { index, iteration ->
                    IterationInputItem(
                        iteration = iteration,
                        updateWeight = { value ->
                            exercise
                                .iterations
                                .changeIterationByIndex(weight = value, index = index)
                                .addEmptyIteration()
                                .run { update.invoke(state.updateExercise(exercise = exercise.copy(iterations = this))) }
                        },
                        updateRepeat = { value ->
                            exercise
                                .iterations
                                .changeIterationByIndex(repeat = value, index = index)
                                .addEmptyIteration()
                                .run { update.invoke(state.updateExercise(exercise = exercise.copy(iterations = this))) }
                        }
                    )
                }
            }
        }
    }
    item(key = "newExercise") {
        NewExerciseItem(onClick = { update.invoke(state.addExercise()) })
    }
    item(key = "saveTraining") {

    }
}

@Composable
private fun InputNameItem(
    number: Int,
    showHelp: MutableState<Boolean>,
    exercise: TrainingState.Exercise,
    update: (TrainingState.Exercise) -> Unit,
    remove: (TrainingState.Exercise) -> Unit
) = Row(
    modifier = Modifier.padding(start = 8.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(4.dp)
) {

    AccentLabel(
        modifier = Modifier.padding(bottom = 8.dp, top = 8.dp, end = 4.dp),
        text = "$number",
    )

    InputName(
        modifier = Modifier.onFocusChanged { showHelp.value = it.hasFocus }.weight(1f),
        value = exercise.name,
        onValueChange = { update.invoke(exercise.copy(name = it)) },
    )

    IconPrimary(
        modifier = Modifier.height(20.dp).width(50.dp),
        imageVector = Icons.Filled.Delete,
        color = DesignComponent.colors.accent_secondary,
        onClick = { remove.invoke(exercise) },
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
private fun LazyItemScope.IterationInputItem(
    modifier: Modifier = Modifier,
    iteration: TrainingState.Exercise.Iteration,
    updateWeight: (value: String) -> Unit,
    updateRepeat: (value: String) -> Unit
) = Column(modifier = modifier.width(60.dp).animateItemPlacement().padding(vertical = 4.dp)) {

    InputWeight(
        value = iteration.weight,
        onValueChange = updateWeight
    )

    DividerPrimary(modifier = Modifier.padding(horizontal = 8.dp))

    InputRepeat(
        value = iteration.repeat,
        onValueChange = updateRepeat
    )
}

@Composable
private fun LazyItemScope.NewExerciseItem(
    onClick: () -> Unit
) = ButtonPrimary(
    modifier = Modifier.fillMaxWidth().animateItemPlacement(),
    text = "Add Exercise",
    onClick = { onClick.invoke() }
)

@Composable
private fun SaveTrainingItem(
    onClick: () -> Unit
) = Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterHorizontally),
    verticalAlignment = Alignment.CenterVertically
) {

    TextFieldBody2(
        text = "Do you finish the training?",
        color = DesignComponent.colors.caption
    )

    ButtonSecondary(
        text = "Save It!",
        onClick = { onClick.invoke() }
    )
}

@Composable
private fun IterationVerticalGrid(
    modifier: Modifier = Modifier,
    spacing: Dp,
    content: @Composable () -> Unit
) = Layout(
    content = content, modifier = modifier
) { measurables, constraints ->
    var currentRow = 0
    var currentOrigin = IntOffset.Zero
    val spacingValue = spacing.toPx().toInt()
    val placeables = measurables.map { measurable ->
        val placeable = measurable.measure(constraints)

        if (currentOrigin.x > 0f && currentOrigin.x + placeable.width > constraints.maxWidth) {
            currentRow += 1
            currentOrigin = currentOrigin.copy(x = 0, y = currentOrigin.y + placeable.height + spacingValue)
        }

        placeable to currentOrigin.also { currentOrigin = it.copy(x = it.x + placeable.width + spacingValue) }
    }

    layout(width = constraints.maxWidth, height = placeables.lastOrNull()?.run { first.height + second.y } ?: 0) {
        placeables.forEach {
            val (placeable, origin) = it
            placeable.place(origin.x, origin.y)
        }
    }
}