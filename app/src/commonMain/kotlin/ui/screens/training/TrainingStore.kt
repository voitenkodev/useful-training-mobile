package ui.screens.training

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import models.Exercise

class TrainingStore(id: String) {

    private val _state = mutableStateOf(Exercise.MOCK)
    var state: State<Exercise> = _state

    init {

    }

}