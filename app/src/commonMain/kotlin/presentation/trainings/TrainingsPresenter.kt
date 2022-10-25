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


}