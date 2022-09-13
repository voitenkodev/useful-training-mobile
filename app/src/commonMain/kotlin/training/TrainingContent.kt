package training

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import designsystem.common.DesignComponent
import designsystem.components.InputName
import designsystem.components.InputRepeat
import designsystem.components.InputWeight
import designsystem.controls.ChipPrimary
import designsystem.controls.IconPrimary
import designsystem.controls.TextFieldBody2
import designsystem.controls.TextFieldH1

@Composable
fun TrainingContent(
    state: TrainingState,
    update: (TrainingState) -> Unit,
    save: (TrainingState) -> Unit,
    help: List<String>,
) = Column(modifier = Modifier.fillMaxSize()) {

    ExerciseGrid(
        modifier = Modifier.weight(1f),
        exercises = state.exercises,
        help = help,
        update = { updated -> update(state.updateExercise(updated)) },
        remove = { removed -> update(state.removeExercise(removed)) },
        add = { update(state.addExercise()) },
    )

    IconPrimary(
        imageVector = Icons.Default.Send,
        modifier = Modifier
            .align(Alignment.End)
            .background(DesignComponent.colors.primaryInverse, CircleShape),
        color = DesignComponent.colors.primary,
        onClick = { save.invoke(state) }
    )
}

@Composable
fun ExerciseGrid(
    modifier: Modifier = Modifier,
    exercises: List<TrainingState.Exercise>,
    help: List<String>,
    update: (TrainingState.Exercise) -> Unit,
    remove: (TrainingState.Exercise) -> Unit,
    add: () -> Unit,
) {
    val spanCount = 5
    val showHelp = remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(spanCount),
        contentPadding = PaddingValues(DesignComponent.size.rootSpace),
    ) {

        exercises.forEach { exercise ->

            item(
                key = exercise.id,
                span = { GridItemSpan(currentLineSpan = maxLineSpan) }
            ) {
                InputNameItem(showHelp, exercise, update, remove)
            }

//            if (showHelp.value && help.isNotEmpty()) {
//                item(
//                    key = exercise.id + "help",
//                    span = { GridItemSpan(currentLineSpan = maxLineSpan) }
//                ) {
//                    HelpItem(
//                        list = help,
//                        onClick = {
//                            focusManager.moveFocus(FocusDirection.Down)
//                            update.invoke(exercise.copy(name = it))
//                        }
//                    )
//                }
//            }

            exercise.iterations.forEachIndexed { index, item ->

                val isFirstItemInList = (index == 0)
                val isLastItemInList = index == exercise.iterations.lastIndex
                val isFirstItemInLine = index % (spanCount - 1) == 0
                val isLastItemInLine = (index + 1) % (spanCount - 1) == 0

                if (isFirstItemInLine) {
                    item(
                        key = exercise.id + index + "caption",
                        span = { GridItemSpan(currentLineSpan = 1) }
                    ) {
                        val textColor = if (isFirstItemInList.not()) DesignComponent.colors.primaryInverse.copy(alpha = 0.2f)
                        else DesignComponent.colors.primaryInverse
                        IterationCaptionItem(textColor = textColor)
                    }
                }

                item(
                    key = exercise.id + index + "iteration",
                    span = { GridItemSpan(currentLineSpan = 1) }
                ) {
                    val weightShape =
                        if (isLastItemInLine || isLastItemInList) RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp)
                        else RoundedCornerShape(0.dp)

                    IterationInputItem(
                        weightShape = weightShape,
                        iteration = item,
                        updateWeight = { value ->
                            exercise
                                .iterations
                                .changeIterationByIndex(weight = value, index = index)
                                .addEmptyIteration()
                                .run { update.invoke(exercise.copy(iterations = this)) }
                        },
                        updateRepeat = { value ->
                            exercise
                                .iterations
                                .changeIterationByIndex(repeat = value, index = index)
                                .addEmptyIteration()
                                .run { update.invoke(exercise.copy(iterations = this)) }
                        }
                    )
                }
            }
        }
        item(
            key = "newExercise",
            span = { GridItemSpan(currentLineSpan = maxLineSpan) }) {
            NewExerciseItem(onClick = add)
        }
    }
}

@Composable
private fun LazyGridItemScope.InputNameItem(
    showHelp: MutableState<Boolean>,
    exercise: TrainingState.Exercise,
    update: (TrainingState.Exercise) -> Unit,
    remove: (TrainingState.Exercise) -> Unit
) = Row(
    modifier = Modifier
        .animateItemPlacement()
        .padding(top = 8.dp, bottom = 4.dp)
        .background(DesignComponent.colors.special, RoundedCornerShape(8.dp)),
    verticalAlignment = Alignment.CenterVertically
) {

    InputName(
        modifier = Modifier
            .onFocusChanged { showHelp.value = it.hasFocus }
            .weight(1f),
        value = exercise.name,
        onValueChange = { update.invoke(exercise.copy(name = it)) },
    )

    IconPrimary(
        modifier = Modifier.height(20.dp).width(50.dp),
        imageVector = Icons.Filled.Delete,
        color = DesignComponent.colors.primary,
        onClick = { remove.invoke(exercise) },
    )
}

@Composable
private fun LazyGridItemScope.HelpItem(
    list: List<String>,
    onClick: (String) -> Unit,
) = LazyRow(
    modifier = Modifier.animateItemPlacement().padding(top = 4.dp, bottom = 4.dp),
    horizontalArrangement = Arrangement.spacedBy(4.dp)
) {
    items(list) {
        ChipPrimary(
            text = it,
            onClick = { onClick.invoke(it) }
        )
    }
}

@Composable
private fun LazyGridItemScope.IterationCaptionItem(
    textColor: Color
) = Column(
    modifier = Modifier.animateItemPlacement().padding(vertical = 4.dp),
    verticalArrangement = Arrangement.spacedBy(4.dp),
) {
    TextFieldBody2(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = DesignComponent.colors.special.copy(alpha = 0.1f),
                shape = RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp)
            ).padding(8.dp),
        text = "• Weight",
        textAlign = TextAlign.Center,
        maxLines = 1,
        color = textColor,
        fontWeight = FontWeight.Bold
    )

    TextFieldBody2(
        modifier = Modifier.padding(8.dp).fillMaxSize(),
        text = "• Repeat",
        textAlign = TextAlign.Center,
        maxLines = 1,
        color = textColor,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun LazyGridItemScope.IterationInputItem(
    weightShape: Shape,
    iteration: TrainingState.Exercise.Iteration,
    updateWeight: (value: String) -> Unit,
    updateRepeat: (value: String) -> Unit
) = Column(
    modifier = Modifier.animateItemPlacement().padding(vertical = 4.dp),
    verticalArrangement = Arrangement.spacedBy(4.dp)
) {
    InputWeight(
        modifier = Modifier
            .background(DesignComponent.colors.special.copy(alpha = 0.1f), weightShape),
        value = iteration.weight,
        onValueChange = updateWeight
    )
    InputRepeat(
        value = iteration.repeat,
        onValueChange = updateRepeat
    )
}

@Composable
fun LazyGridItemScope.NewExerciseItem(
    onClick: () -> Unit
) = TextFieldH1(
    modifier = Modifier
        .animateItemPlacement()
        .fillMaxWidth()
        .background(
            color = DesignComponent.colors.special.copy(alpha = DesignComponent.colors.alphaPrimary),
            shape = RoundedCornerShape(8.dp)
        ).clip(
            shape = RoundedCornerShape(8.dp)
        ).clickable {
            onClick.invoke()
        }.padding(vertical = 8.dp),
    text = "+",
    color = DesignComponent.colors.primary,
    textAlign = TextAlign.Center
)
