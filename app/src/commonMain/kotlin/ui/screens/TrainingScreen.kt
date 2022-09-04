package ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import models.Exercise
import models.Training
import ui.designsystem.controls.ButtonPrimary
import ui.designsystem.controls.InputFieldBody1
import ui.designsystem.controls.InputFieldBody2
import ui.designsystem.controls.TextFieldBody2

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
        val spanCount = 5 // count of grid rows

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

        InputFieldBody1(
            modifier = Modifier.padding(12.dp),
            value = exercise.name,
            placeholder = "Name of exercise",
            maxLines = 1,
            onValueChange = {
                update.invoke(exercise.copy(name = it))
            }
        )
    }

    item(span = { GridItemSpan(currentLineSpan = 1) }) {

        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            TextFieldBody2(
                modifier = Modifier.padding(8.dp),
                text = "Weight",
            )
            TextFieldBody2(
                modifier = Modifier.padding(8.dp),
                text = "Count",
            )
        }
    }

    itemsIndexed(items = exercise.iterations) { index, item ->

        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {

            InputFieldBody2(
                modifier = Modifier.padding(8.dp),
                value = item.first,
                textAlign = TextAlign.Center,
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                placeholder = "0.0",
                onValueChange = { value ->
                    var newIteration = exercise
                        .iterations
                        .mapIndexed { i, old -> if (i == index) value to old.second else old }
                        .filter { item -> item != "" to "" }

                    if (newIteration.lastOrNull()?.first != "" || newIteration.lastOrNull()?.second != "")
                        newIteration = newIteration + ("" to "")

                    update.invoke(exercise.copy(iterations = newIteration))
                }
            )

            InputFieldBody2(
                modifier = Modifier.padding(8.dp),
                value = item.second.takeIf { (it.toIntOrNull() ?: 0) > 0 }?.toString() ?: "",
                textAlign = TextAlign.Center,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                maxLines = 1,
                placeholder = "0",
                onValueChange = { value ->
                    var newIteration = exercise
                        .iterations
                        .mapIndexed { i, old -> if (i == index) old.first to value else old }
                        .filter { item -> item != "" to "" }

                    if (newIteration.lastOrNull()?.first != "" || newIteration.lastOrNull()?.second != "")
                        newIteration = newIteration + ("" to "")

                    update.invoke(exercise.copy(iterations = newIteration))
                }
            )
        }
    }
}