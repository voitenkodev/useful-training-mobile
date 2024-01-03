package statistics.screen

import ExerciseExamplesRepository
import MusclesRepository
import ViewModel
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import org.koin.core.component.inject
import statistics.mapping.toState
import statistics.state.IntervalType
import statistics.state.State

internal class StatisticsViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state

    private val exerciseExamplesApi by inject<ExerciseExamplesRepository>()
    private val musclesApi by inject<MusclesRepository>()

    init {
        exerciseExamplesApi
            .observeExerciseExamples()
            .onEach { r -> _state.update { it.copy(exerciseExamples = r.toState()) } }
            .launchIn(this)

        exerciseExamplesApi
            .syncExerciseExamples()
            .catch { t -> _state.update { it.copy(error = t.message) } }
            .launchIn(this)

        musclesApi
            .syncUserMuscleTypes()
            .catch { t -> _state.update { it.copy(error = t.message) } }
            .launchIn(this)
    }

    fun setMuscleFilter(id: String) {
        _state.update {
            it.copy(
                muscles = it.muscles.map { item ->
                    if (item.id == id) {
                        item.copy(isSelected = item.isSelected.not())
                    } else item
                }.toPersistentList()
            )
        }
    }

    fun setExerciseExampleFilter(id: String) {
        _state.update {
            it.copy(
                exerciseExamples = it.exerciseExamples.map { item ->
                    if (item.id == id) {
                        item.copy(isSelected = item.isSelected.not())
                    } else item
                }.toPersistentList()
            )
        }
    }

    fun setIntervalFilter(intervalType: IntervalType) {
        _state.update {
            it.copy(
                intervals = it.intervals.map { item ->
                    item.copy(isSelected = item.type == intervalType)
                }.toPersistentList()
            )
        }
    }

    fun openFilters() {
        _state.update { it.copy(filterPopupIsVisible = true) }
    }

    fun setQuery(query: String) {
        _state.update { it.copy(query = query) }
        debounceGetExercises(query)
    }

    private fun debounceGetExercises(query: String) {
//        flowOf(query)
//            .debounce(500)
//            .distinctUntilChanged()
//            .flatMapConcat { trainingsApi.getExercises(query = query) }
//            .onStart {
//                _state.update { it.copy(loading = false) }
//            }.onEach { response ->
//                _state.update {
//                    it.copy(
//                        exercises = response.processingExercises(),
//                        loading = false
//                    )
//                }
//            }.catch { t ->
//                _state.update { it.copy(loading = false, error = t.message) }
//            }.launchIn(this)
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }

    fun closePopups() {
//        _state.update { it.copy(filterPopupIsShowed = false) }
    }
}