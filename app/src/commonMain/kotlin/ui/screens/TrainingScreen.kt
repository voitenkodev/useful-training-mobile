package ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.*
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import models.*
import ui.designsystem.common.DesignComponent
import ui.designsystem.components.InputName
import ui.designsystem.components.InputRepeat
import ui.designsystem.components.InputWeight
import ui.designsystem.controls.ChipPrimary
import ui.designsystem.controls.IconPrimary
import ui.designsystem.controls.TextFieldBody2Bold

@Composable
fun TrainingScreen(
    training: Training,
    createId: () -> String,
    save: (Training) -> Unit,
    help: (String) -> Unit
) = Column(modifier = Modifier.fillMaxSize().padding(bottom = 12.dp)) {

    val state = remember { mutableStateOf(training) }
    val spanCount = 5

    LazyVerticalGrid(
        modifier = Modifier.weight(1f),
        columns = GridCells.Fixed(spanCount),
        contentPadding = PaddingValues(start = 12.dp, end = 12.dp, top = 12.dp, bottom = 56.dp),
    ) {

        state.value.exercises.forEach {
            exercise(
                exercise = it,
                spanCount = spanCount,
                update = { updated -> state.value = state.value.updateExercise(updated) },
                remove = { removed -> state.value = state.value.removeExercise(removed) }
            )
        }
    }

    IconPrimary(
        imageVector = Icons.Default.Add,
        modifier = Modifier.align(Alignment.End).padding(end = 12.dp).background(DesignComponent.colors.primaryInverse, CircleShape),
        color = DesignComponent.colors.primary,
        onClick = { state.value = state.value.addExercise(createId.invoke()) }
    )
}

fun LazyGridScope.exercise(
    spanCount: Int,
    exercise: Training.Exercise,
    update: (Training.Exercise) -> Unit,
    remove: (Training.Exercise) -> Unit,
) {

    item(key = exercise.id, span = { GridItemSpan(currentLineSpan = maxLineSpan) }) {

        val help = remember { mutableStateOf(false) }
        val focusManager = LocalFocusManager.current

        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {

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
                    onValueChange = { update.invoke(exercise.copy(name = it)) }
                )

                IconPrimary(
                    modifier = Modifier.height(20.dp).width(50.dp),
                    imageVector = Icons.Filled.Delete,
                    color = DesignComponent.colors.primary,
                    onClick = { remove.invoke(exercise) },
                )
            }

            AnimatedVisibility(help.value) {

                LazyRow(horizontalArrangement = Arrangement.spacedBy(4.dp)) {

                    items(listOf("bench press", "weight lift", "test", "some big exercise name")) {
                        ChipPrimary(
                            text = it,
                            onDelete = {},
                            onClick = {
                                focusManager.moveFocus(FocusDirection.Down)
                                update.invoke(exercise.copy(name = it))
                            },
                        )
                    }
                }
            }
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
                            .background(DesignComponent.colors.special2.copy(alpha = 0.1f), RoundedCornerShape(8.dp, 0.dp, 0.dp, 8.dp)),
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

            val weightShape = if (isLastItemInLine || isLastItemInList) RoundedCornerShape(0.dp, 8.dp, 8.dp, 0.dp)
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