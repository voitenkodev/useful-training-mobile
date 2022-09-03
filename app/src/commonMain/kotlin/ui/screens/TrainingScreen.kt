package ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
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

    val training = remember { mutableStateOf(training) }

    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                items = training.value.exercises,
                key = { training.value.id },
                itemContent = {
                    Exercise(
                        exercise = it,
                        update = {}
                    )
                }
            )
        }

        ButtonPrimary(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
            text = "Add Exercise",
            onClick = {
                val new = training.value.copy(exercises = training.value.exercises + Exercise.empty(createId.invoke()))
                training.value = new
            }
        )

        Spacer(Modifier.height(12.dp))
    }
}

@Composable
private fun Exercise(exercise: Exercise, update: (Exercise) -> Unit) {
    val state = remember { mutableStateOf(exercise) }
    Card(
        modifier = Modifier.padding(4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            InputFieldPrimary(
                value = state.value.name,
                onValueChange = { state.value = state.value.copy(name = it) },
                placeholder = "Name of exercise",
                maxLines = 1
            )

            Column {
                state.value.iterations.chunked(5).forEach {
                    Row {
                        it.forEachIndexed { index, item ->
                            Iteration(
                                modifier = Modifier.weight(1f),
                                iteration = item,
                                update = { iteration ->
                                    update.invoke(state.value.copy(iterations = state.value.iterations.updated(index, iteration)))
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

fun <E> Iterable<E>.updated(index: Int, elem: E) = mapIndexed { i, existing -> if (i == index) elem else existing }

@Composable
private fun Iteration(
    modifier: Modifier = Modifier,
    iteration: Pair<Double, Int>,
    update: (Pair<Double, Int>) -> Unit
) {

    val weight = rememberSaveable { mutableStateOf(iteration.first.takeIf { it != 0.0 }?.toString() ?: "") }
    val count = rememberSaveable { mutableStateOf(iteration.second.takeIf { it != 0 }?.toString() ?: "") }

    Column(modifier = modifier) {

        Spacer(modifier = Modifier.size(4.dp))

        InputFieldSecondary(
            value = weight.value,
            onValueChange = { weight.value = it },
            textAlign = TextAlign.Center,
            maxLines = 1,
            placeholder = "0.0"
        )

        Spacer(modifier = Modifier.size(4.dp))

        InputFieldSecondary(
            value = count.value,
            onValueChange = { count.value = it },
            textAlign = TextAlign.Center,
            maxLines = 1,
            placeholder = "0"
        )

        Spacer(modifier = Modifier.size(4.dp))
    }
}