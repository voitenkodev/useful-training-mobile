package exerciseexample.main

import ExerciseExamplesRepository
import ViewModel
import exerciseexample.main.factories.createFrontBackImages
import exerciseexample.main.mapping.toState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.inject

internal class ExerciseExampleViewModel(id: String) : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state

    private val api by inject<ExerciseExamplesRepository>()

    init {
        launch {
            val result = api
                .observeExerciseExample(id)
                .catch { t -> _state.update { it.copy(error = t.message) } }
                .firstOrNull()
                ?.toState() ?: return@launch

            _state.update {
                val images = result.createFrontBackImages()
                it.copy(exerciseExample = result, fullFrontImageVector = images.first, fullBackImageVector = images.second)
            }
        }

        api.syncExerciseExampleById(id)
            .onStart { _state.update { it.copy(loading = true) } }
            .catch { t -> _state.update { it.copy(loading = false, error = t.message) } }
            .onEach { _state.update { it.copy(loading = false) } }
            .launchIn(this)
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}