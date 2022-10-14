package presentation.trainings

import ComposeCoroutineContext
import Direction
import NavigatorAction
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
        api
            .getTrainings()
            .map { it.toTrainingStateList() }
            .onEach { dispatcher(TrainingsAction.GetTrainings(it)) }
            .launchIn(this)
    }
}