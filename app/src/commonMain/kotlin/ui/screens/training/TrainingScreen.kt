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
import co.touchlab.kermit.Logger
import ui.designsystem.controls.BODY1EditText

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
        BODY1EditText(
            text = state.value.name,
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
        BODY1EditText(
            text = state.value.weight.toString(),
            onValueChange = {},
            textAlign = TextAlign.Center
        )
        BODY1EditText(
            text = state.value.count.toString(),
            onValueChange = {},
            textAlign = TextAlign.Center
        )
    }
}