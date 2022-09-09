package ui.screens.training

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import co.touchlab.kermit.Logger
import ui.designsystem.common.DesignComponent
import ui.designsystem.components.InputName
import ui.designsystem.components.InputRepeat
import ui.designsystem.components.InputWeight
import ui.designsystem.controls.ChipPrimary
import ui.designsystem.controls.IconPrimary
import ui.designsystem.controls.TextFieldBody2Bold

@Composable
fun TrainingScreen(
    training: TrainingState,
    save: (TrainingState) -> Unit,
//    help: List<String>,
//    query: (String) -> Unit,
) = Column(modifier = Modifier.fillMaxSize().padding(bottom = 12.dp)) {

    val state = remember { mutableStateOf(training) }

    ExerciseGrid(
        modifier = Modifier.weight(1f),
        exercises = state.value.exercises,
        update = { updated -> state.value = state.value.updateExercise(updated) },
        remove = { removed -> state.value = state.value.removeExercise(removed) }
    )

    IconPrimary(
        imageVector = Icons.Default.Send,
        modifier = Modifier.align(Alignment.End).padding(end = 12.dp).background(DesignComponent.colors.primaryInverse, CircleShape),
        color = DesignComponent.colors.primary,
        onClick = { save.invoke(state.value) }
    )

    IconPrimary(
        imageVector = Icons.Default.Add,
        modifier = Modifier.align(Alignment.End).padding(end = 12.dp).background(DesignComponent.colors.primaryInverse, CircleShape),
        color = DesignComponent.colors.primary,
        onClick = { state.value = state.value.addExercise() }
    )
}


@Composable
fun ExerciseGrid(
    modifier: Modifier = Modifier,

    exercises: List<TrainingState.Exercise>,
    update: (TrainingState.Exercise) -> Unit,
    remove: (TrainingState.Exercise) -> Unit,
) {
    val spanCount = 5
    Logger.i { "Exercises -> $exercises" }

    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(spanCount),
        contentPadding = PaddingValues(start = 12.dp, end = 12.dp, top = 12.dp, bottom = 56.dp),
    ) {

        exercises.forEach { exercise ->

            item(key = exercise.id, span = { GridItemSpan(currentLineSpan = maxLineSpan) }) {

                val help = remember { mutableStateOf(false) }

                val focusManager = LocalFocusManager.current

                Column {

                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .background(DesignComponent.colors.special2, RoundedCornerShape(8.dp)),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        InputName(
                            modifier = Modifier
                                .onFocusChanged { help.value = it.hasFocus }
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

                    val list = listOf("bench press", "weight lift", "test", "some big exercise name")

                    HelpInputNameRow(
                        visibility = help.value && list.isNotEmpty(),
                        list = list,
                        onClick = {
                            focusManager.moveFocus(FocusDirection.Down)
                            update.invoke(exercise.copy(name = it))
                        }
                    )
                }
            }

            exercise.iterations.forEachIndexed { index, item ->

                val isFirstItemInList = (index == 0)
                val isLastItemInList = index == exercise.iterations.lastIndex
                val isFirstItemInLine = index % (spanCount - 1) == 0
                val isLastItemInLine = (index + 1) % (spanCount - 1) == 0

                if (isFirstItemInLine) {

                    item(span = { GridItemSpan(currentLineSpan = 1) }) {

                        val textColor = if (isFirstItemInList.not()) DesignComponent.colors.primaryInverse.copy(alpha = 0.2f)
                        else DesignComponent.colors.primaryInverse

                        Column(
                            modifier = Modifier.padding(vertical = 4.dp),
                            verticalArrangement = Arrangement.spacedBy(4.dp),
                        ) {

                            TextFieldBody2Bold(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                        color = DesignComponent.colors.special2.copy(alpha = 0.1f),
                                        shape = RoundedCornerShape(8.dp, 0.dp, 0.dp, 8.dp)
                                    ),
                                text = "• Weight",
                                textAlign = TextAlign.Center,
                                maxLines = 1,
                                color = textColor
                            )

                            TextFieldBody2Bold(
                                modifier = Modifier.fillMaxSize(),
                                text = "• Repeat",
                                textAlign = TextAlign.Center,
                                maxLines = 1,
                                color = textColor,
                            )
                        }
                    }
                }

                item {

                    val weightShape =
                        if (isLastItemInLine || isLastItemInList) RoundedCornerShape(0.dp, 8.dp, 8.dp, 0.dp)
                        else RoundedCornerShape(0.dp)

                    Column(
                        modifier = Modifier.padding(vertical = 4.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {

                        InputWeight(
                            modifier = Modifier.background(DesignComponent.colors.special2.copy(alpha = 0.1f), weightShape),
                            value = item.weight,
                            onValueChange = { value ->
                                exercise
                                    .iterations
                                    .changeIterationByIndex(weight = value, index = index)
                                    .addEmptyIteration()
                                    .run { update.invoke(exercise.copy(iterations = this)) }
                            }
                        )
                        InputRepeat(
                            value = item.repeat,
                            onValueChange = { value ->
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
        }
    }
}

@Composable
fun HelpInputNameRow(
    visibility: Boolean,
    list: List<String>,
    onClick: (String) -> Unit
) = AnimatedVisibility(visibility) {
    LazyRow(
        modifier = Modifier.padding(top = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) { items(list) { ChipPrimary(text = it, onClick = onClick) } }
}