package ui.auth

import androidx.lifecycle.ViewModel
import datasource.AuthSource
import training.TrainingState

class AuthViewModel(
    private val authSource: AuthSource
) : ViewModel() {

    fun save(trainingState: TrainingState) {
//        todo
    }

}