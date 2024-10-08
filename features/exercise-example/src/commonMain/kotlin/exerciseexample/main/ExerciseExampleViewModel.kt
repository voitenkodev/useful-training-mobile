package exerciseexample.main

import ExerciseExamplesRepository
import NativeIntentApi
import StatisticsRepository
import ViewModel
import exercise.Tutorial
import exercise.factories.createFrontBackImages
import exercise.mapping.toState
import exerciseexample.main.mapping.toState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.inject

internal class ExerciseExampleViewModel(id: String) : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state.asStateFlow()

    private val exerciseExampleApi by inject<ExerciseExamplesRepository>()
    private val statisticsApi by inject<StatisticsRepository>()

    private val intentApi by inject<NativeIntentApi>()

    init {
        launch {
            val result = exerciseExampleApi
                .observeExerciseExample(id)
                .catch { t -> _state.update { it.copy(error = t.message) } }
                .firstOrNull()
                ?.toState() ?: return@launch

            _state.update {
                val images = result.createFrontBackImages()
                it.copy(
                    exerciseExample = result,
                    fullFrontImageVector = images.first,
                    fullBackImageVector = images.second
                )
            }
        }

        val exerciseJob = exerciseExampleApi.syncExerciseExampleById(id)

        val statisticsJob = statisticsApi.getExerciseExampleAchievements(id, 5)
            .onEach { r -> _state.update { it.copy(achievements = r.toState()) } }

        merge(exerciseJob, statisticsJob)
            .onStart { _state.update { it.copy(loading = true) } }
            .catch { t -> _state.update { it.copy(loading = false, error = t.message) } }
            .onEach { _state.update { it.copy(loading = false) } }
            .launchIn(this)
    }

    fun selectTutorial(value: Tutorial) {
        intentApi.openBrowser(value.value)
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}