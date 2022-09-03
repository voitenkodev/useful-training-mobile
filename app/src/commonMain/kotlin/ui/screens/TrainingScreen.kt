package ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import models.Exercise
import models.Training
import ui.designsystem.controls.ButtonPrimary
import ui.designsystem.controls.InputFieldPrimary
import ui.designsystem.controls.InputFieldSecondary

@Composable
fun TrainingScreen(
    training: Training,
    createId: () -> String,
    save: (Training) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        val state = remember { mutableStateOf(training) }

        val spanCount = 5

        LazyVerticalGrid(
            modifier = Modifier.weight(1f),
            columns = GridCells.Fixed(spanCount),
            contentPadding = PaddingValues(5.dp),
            state = rememberLazyGridState(),
        ) {

            state.value.exercises.forEach {
                exercise(
                    spanCount = spanCount,
                    exercise = it,
                    update = { updated ->
                        val newList = state.value.exercises.map { old -> if (old.id == updated.id) updated else old }
                        state.value = state.value.copy(exercises = newList)
                    }
                )
            }
        }

        ButtonPrimary(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
            text = "Add Exercise",
            onClick = {
                val new = state.value.copy(exercises = state.value.exercises + Exercise.empty(createId.invoke()))
                state.value = new
            }
        )

        Spacer(Modifier.height(12.dp))
    }
}

fun LazyGridScope.exercise(
    spanCount: Int,
    exercise: Exercise,
    update: (Exercise) -> Unit
) {

    item(key = exercise.id, span = { GridItemSpan(currentLineSpan = spanCount) }) {

        InputFieldPrimary(
            value = exercise.name,
            placeholder = "Name of exercise",
            maxLines = 1,
            onValueChange = {
                // Update name of exercise
                update.invoke(exercise.copy(name = it))
            },
        )
    }

    itemsIndexed(items = exercise.iterations /*key = { index, _ -> index }*/) { index, item ->

        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {

            InputFieldSecondary(value = item.first.takeIf { it != 0.0 }?.toString() ?: "",
                textAlign = TextAlign.Center,
                maxLines = 1,
                placeholder = "0.0",
                onValueChange = {
                    // weight name of exercise
                    val newIteration =
                        exercise.iterations.mapIndexed { i, old -> if (i == index) (it.toDoubleOrNull() ?: 0.0) to old.second else old }
                    update.invoke(exercise.copy(iterations = newIteration))
                })

            InputFieldSecondary(
                value = item.second.takeIf { it != 0 }?.toString() ?: "",
                textAlign = TextAlign.Center,
                maxLines = 1,
                placeholder = "0.0",
                onValueChange = {
                    // count name of exercise
                    val newIteration =
                        exercise.iterations.mapIndexed { i, old -> if (i == index) old.first to (it.toIntOrNull() ?: 0) else old }
                    update.invoke(exercise.copy(iterations = newIteration))
                },
            )
        }
    }

    item(span = { GridItemSpan(currentLineSpan = spanCount) }) {

        Row {

            Spacer(modifier = Modifier.weight(1f))

            ButtonPrimary(
                modifier = Modifier.wrapContentSize(),
                text = "more",
                onClick = {
                    // Add 5 empty iterations for exercise
                    val newIteration = exercise.iterations + listOf(0.0 to 0, 0.0 to 0, 0.0 to 0, 0.0 to 0, 0.0 to 0)
                    update.invoke(exercise.copy(iterations = newIteration))
                }
            )
        }
    }
}