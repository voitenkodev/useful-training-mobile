package ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
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
import ui.designsystem.common.DesignComponent
import ui.designsystem.controls.*

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
                    },
                    remove = { removed ->
                        val newList = state.value.exercises.mapNotNull { old -> if (old.id == removed.id) null else old }
                        state.value = state.value.copy(exercises = newList)
                    }
                )
            }
        }

        ButtonPrimary(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
            text = "Add Exercise",
            onClick = {
                val newExercises = state.value.exercises + Exercise.empty(createId.invoke())
                state.value = state.value.copy(exercises = newExercises)
            }
        )

        Spacer(Modifier.height(12.dp))
    }
}

fun LazyGridScope.exercise(
    spanCount: Int,
    exercise: Exercise,
    update: (Exercise) -> Unit,
    remove: (Exercise) -> Unit,
) {

    item(key = exercise.id, span = { GridItemSpan(currentLineSpan = spanCount) }) {

        Row(
            modifier = Modifier.background(DesignComponent.colors.special2, RoundedCornerShape(8.dp)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            InputFieldBody1(
                modifier = Modifier
                    .background(DesignComponent.colors.primary, RoundedCornerShape(8.dp))
                    .border(BorderStroke(2.dp, DesignComponent.colors.special2), RoundedCornerShape(8.dp))
                    .weight(1f)
                    .padding(12.dp),
                value = exercise.name,
                placeholder = "Name of exercise",
                maxLines = 1,
                onValueChange = {
                    update.invoke(exercise.copy(name = it))
                }
            )

            IconButton(
                modifier = Modifier.height(20.dp).width(50.dp),
                onClick = { remove.invoke(exercise) }
            ) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    tint = DesignComponent.colors.primary,
                    contentDescription = ""
                )
            }
        }
    }

    item(span = { GridItemSpan(currentLineSpan = 1) }) {

        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {

            TextFieldBody2Bold(
                modifier = Modifier.fillMaxSize().padding(8.dp),
                text = "• Weight",
                textAlign = TextAlign.Center,
            )
            TextFieldBody2Bold(
                modifier = Modifier.fillMaxSize().padding(8.dp),
                text = "• Count",
                textAlign = TextAlign.Center,
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