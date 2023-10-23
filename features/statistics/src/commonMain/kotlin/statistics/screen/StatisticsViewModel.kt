package statistics.screen

import ExercisesBundleRepository
import TrainingRepository
import ViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toImmutableMap
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import models.ExerciseDate
import org.koin.core.component.inject
import statistics.mapping.toExerciseState
import statistics.state.Info
import statistics.state.State

internal class StatisticsViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state

    private val trainingsApi by inject<TrainingRepository>()
    private val exercisesApi by inject<ExercisesBundleRepository>()

    init {
        debounceGetExercises("")
        getExerciseNameOptions()
    }

    fun setQuery(query: String) {
        _state.update { it.copy(query = query) }
        debounceGetExercises(query)
    }

    @OptIn(FlowPreview::class)
    private fun debounceGetExercises(query: String) {
        flowOf(query)
            .debounce(500)
            .distinctUntilChanged()
            .flatMapConcat { trainingsApi.getExercises(query = query) }
            .onStart {
                _state.update { it.copy(loading = false) }
            }.onEach { response ->
                _state.update {
                    it.copy(
                        loading = false,
                        exercises = response.processingExercises(),
                    )
                }
            }.catch { t ->
                _state.update { it.copy(loading = false, error = t.message) }
            }.launchIn(this)
    }

    private fun getExerciseNameOptions() {
        exercisesApi
            .getExerciseNameOptions()
            .onEach { r ->
                _state.update {
                    it.copy(exerciseNameOptions = r.toPersistentList())
                }
            }.catch { t ->
                _state.update { it.copy(error = t.message) }
            }.launchIn(this)
    }

    fun removeExerciseNameOption(value: String) {
        exercisesApi
            .removeExerciseNameOption(value)
            .onEach { removedValue ->
                _state.update {
                    it.copy(
                        exerciseNameOptions = state
                            .value
                            .exerciseNameOptions
                            .filterNot { f -> f == removedValue }
                            .toPersistentList()
                    )
                }
            }.catch { t ->
                _state.update { it.copy(error = t.message) }
            }.launchIn(this)
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }

    private fun List<ExerciseDate>.processingExercises() = this.groupBy(
        { Info(trainingId = it.trainingId, date = it.date) },
        { it.exercise.toExerciseState() }
    ).mapValues { it.value.toImmutableList() }
        .toImmutableMap()

}