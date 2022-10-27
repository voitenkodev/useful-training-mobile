package presentation.training

import Graph
import NavigatorCore
import ViewModel
import androidx.compose.runtime.Composable
import data.mapping.toTraining
import data.mapping.toTrainingState
import data.repository.TrainingRepository
import globalKoin
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import presentation.review.ReviewAction

class TrainingViewModel(
    private val dispatcher: (Any) -> Any,
    private val navigator: NavigatorCore,
) : ViewModel() {

    private val api = globalKoin().get<TrainingRepository>()

    @Composable
    fun state(){

    }

    fun saveTraining(training: Training) = viewModelScope.launch {
        api.setTraining(training = training.toTraining())
            .onStart {
                dispatcher(TrainingAction.Loading(true))
            }.onEach {
                dispatcher(TrainingAction.Loading(false))
                dispatcher(ReviewAction.FetchTrainings(selected = it.toTrainingState()))
                navigator.navigate(Graph.Review.link, popToInclusive = true)
            }.catch {
                dispatcher(TrainingAction.Error(it.message))
                dispatcher(TrainingAction.Loading(false))
            }
            .launchIn(this)
    }

    fun processingTraining() {
        dispatcher(TrainingAction.ValidateExercises)
        dispatcher(TrainingAction.CalculateDuration)
        dispatcher(TrainingAction.CalculateValues)
    }

    fun clearError() {
        dispatcher(TrainingAction.Error(null))
    }

    fun openRemoveExercisePopup(exerciseId: String) {
        dispatcher(TrainingAction.AskRemoveExercise(exerciseId = exerciseId))
    }

    fun openExitScreenPopup() {
        dispatcher(TrainingAction.AskExitFromTraining(true))
    }

    fun closeExitScreenPopup() {
        dispatcher(TrainingAction.AskExitFromTraining(false))
    }

    fun back() {
        closeExitScreenPopup()
        navigator.back()
    }

    fun closeRemoveExercisePopup() {
        dispatcher(TrainingAction.AskRemoveExercise(null))
    }

    fun removeExercise(exerciseId: String?) {
        exerciseId?.let {
            dispatcher(TrainingAction.RemoveExerciseAction(exerciseId = it))
        }
    }

    fun updateName(exerciseId: String, name: String) {
        dispatcher(TrainingAction.SetNameExerciseAction(exerciseId = exerciseId, value = name))
    }

    fun updateWeight(exerciseId: String, number: Int, weight: String) {
        dispatcher(TrainingAction.SetWeightExerciseIterationAction(exerciseId = exerciseId, number = number, value = weight))
        dispatcher(TrainingAction.ProvideEmptyIteration(exerciseId = exerciseId))
    }

    fun updateRepeat(exerciseId: String, number: Int, repeat: String) {
        dispatcher(TrainingAction.SetRepeatExerciseIterationAction(exerciseId = exerciseId, number = number, value = repeat))
        dispatcher(TrainingAction.ProvideEmptyIteration(exerciseId = exerciseId))
    }

    fun addExercise() {
        dispatcher(TrainingAction.AddExerciseAction)
    }
}