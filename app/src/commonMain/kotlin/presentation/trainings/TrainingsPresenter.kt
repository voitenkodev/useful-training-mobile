package presentation.trainings

import ComposeCoroutineContext
import data.mapping.toTrainingStateList
import data.repository.TrainingRepository
import globalKoin
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart

class TrainingsPresenter(val dispatcher: (Any) -> Any) : ComposeCoroutineContext() {

    private val api = globalKoin().get<TrainingRepository>()

    fun fetchTrainings() = call {
        api.getTrainings().onStart {
                dispatcher(TrainingsAction.Loading(true))
            }.map {
                it.toTrainingStateList()
            }.onEach {
                dispatcher(TrainingsAction.Loading(false))
                dispatcher(TrainingsAction.Error(null))
                dispatcher(TrainingsAction.FetchTrainings(it))
            }.catch {
                dispatcher(TrainingsAction.Loading(false))
                dispatcher(TrainingsAction.Error(it.message))
            }.launchIn(this)
    }
}