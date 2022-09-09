package ui.training

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import training.TrainingState

class TrainingViewModel() : ViewModel() {

    val trainingState = MutableStateFlow(TrainingState.empty(0.0))

    fun save(trainingState: TrainingState) {
//        todo
    }

}