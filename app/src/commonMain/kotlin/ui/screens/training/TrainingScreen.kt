package ui.screens.training

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import models.Exercise
import ui.designsystem.controls.InputFieldPrimary

@Composable
fun TrainingScreen() {
    val store = rememberSaveable{ TrainingStore("") }

    Column {
        Exercise(store.state.value) {

        }
        Exercise(store.state.value) {

        }
        Exercise(store.state.value) {

        }
    }
}

@Composable
private fun Exercise(exercise: Exercise, update: (Exercise) -> Unit) {
    val state = rememberSaveable { mutableStateOf(exercise) }
    Column {
        InputFieldPrimary(
            value = state.value.name,
            onValueChange = { state.value = state.value.copy(name = it) }
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            state.value.iterations.forEachIndexed { index, item ->
                Iteration(
                    modifier = Modifier.weight(1f),
                    iteration = item
                )
            }
        }
    }
}

@Composable
private fun Iteration(modifier: Modifier = Modifier, iteration: Exercise.Iteration) {
    val state = rememberSaveable { mutableStateOf(iteration) }
    Column(modifier = modifier) {
        InputFieldPrimary(
            value = state.value.weight.toString(),
            onValueChange = {},
            textAlign = TextAlign.Center
        )
        InputFieldPrimary(
            value = state.value.count.toString(),
            onValueChange = {},
            textAlign = TextAlign.Center
        )
    }
}