package summary

import TrainingRepository
import ViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import mapping.toExerciseState
import mapping.toTrainingStateList
import models.ExerciseDate
import org.koin.core.component.inject
import training.Exercise
import training.Training

internal class SummaryViewModel : ViewModel() {

    private val _state = MutableStateFlow(SummaryState())
    val state: StateFlow<SummaryState> = _state

    private val api by inject<TrainingRepository>()

    private var searchJob: Job? = null

    private fun debounceGetExercises(query: String) {
        searchJob?.cancel()
        searchJob = launch {
            if (query.isBlank()) {
                _state.value = state.value.copy(
                    exercises = emptyMap(),
                    currentMonthTrainings = calculateMonthTrainings(
                        month = state.value.selectedMonth,
                        year = state.value.selectedYear,
                        exercises = emptyMap(),
                        trainings = state.value.trainings
                    )
                )
                return@launch
            }
            delay(500)
            getExercisesBy(query)
        }
    }

    fun getExerciseNameOptions() = launch {
        api
            .getExerciseNameOptions()
            .onStart {
                _state.value = state.value.copy(loading = true)
            }.onEach {
                _state.value = state.value.copy(exerciseNameOptions = it)
            }.catch {
                _state.value = state.value.copy(loading = false, error = it.message)
            }.launchIn(this)
    }

    fun removeExerciseNameOption(value: String) = launch {
        api
            .removeExerciseNameOption(value)
            .onEach { removedValue ->
                _state.value = state.value.copy(
                    exerciseNameOptions = state.value.exerciseNameOptions.filterNot { it == removedValue }
                )
            }.catch {
                _state.value = state.value.copy(error = it.message)
            }.launchIn(this)
    }

    fun getTrainings() = launch {
        api.getTrainings()
            .onStart {
                _state.value = state.value.copy(loading = true)
            }.map {
                it.toTrainingStateList()
            }.onEach { trainings ->
                _state.value = state.value.copy(
                    trainings = trainings,
                    error = null,
                    loading = false,
                    currentMonthTrainings = calculateMonthTrainings(
                        month = state.value.selectedMonth,
                        year = state.value.selectedYear,
                        exercises = state.value.exercises,
                        trainings = trainings
                    )
                )
            }.catch {
                _state.value = state.value.copy(loading = false, error = it.message)
            }.launchIn(this)
    }

    private fun getExercisesBy(query: String) = launch {
        api.getExercises(query = query)
            .onStart {
                _state.value = state.value.copy(loading = false)
            }.onEach {
                val exercises = it.processingExercises()

                _state.value = state.value.copy(
                    loading = false,
                    error = null,
                    exercises = exercises,
                    listOfTonnage = calculateListOfTonnage(exercises),
                    listOfIntensity = calculateListOfIntensity(exercises),
                    currentMonthTrainings = calculateMonthTrainings(
                        month = state.value.selectedMonth,
                        year = state.value.selectedYear,
                        exercises = exercises,
                        trainings = state.value.trainings
                    )
                )
            }.catch {
                _state.value = state.value.copy(loading = false, error = it.message)
            }.launchIn(this)
    }

    fun setQuery(query: String) {
        _state.value = state.value.copy(query = query)

        debounceGetExercises(query)
    }

    fun clearError() {
        _state.value = state.value.copy(error = null)
    }

    fun findIndexOfTraining(day: Int, month: Int) {
        val index = state.value.trainings
            .indexOfFirst { it.day == day && it.month == month }

        _state.value = state.value.copy(autoScrollIndex = index)
    }

    fun clearAutoScrollIndex() {
        _state.value = state.value.copy(autoScrollIndex = -1)
    }

    fun decreaseMonth() {
        val isPreviousYear = state.value.selectedMonth == 1
        val newMonth = if (isPreviousYear) 12
        else state.value.selectedMonth - 1
        val newYear = if (isPreviousYear) state.value.selectedYear - 1
        else state.value.selectedYear

        _state.value = state.value.copy(
            selectedYear = newYear,
            selectedMonth = newMonth,
            currentMonthTrainings = calculateMonthTrainings(
                month = newMonth,
                year = newYear,
                exercises = state.value.exercises,
                trainings = state.value.trainings
            )
        )
    }

    fun increaseMonth() {
        val isNextYear = state.value.selectedMonth == 12
        val newMonth = if (isNextYear) 1
        else state.value.selectedMonth + 1
        val newYear = if (isNextYear) state.value.selectedYear + 1
        else state.value.selectedYear

        _state.value = state.value.copy(
            selectedYear = newYear,
            selectedMonth = newMonth,
            currentMonthTrainings = calculateMonthTrainings(
                month = newMonth,
                year = newYear,
                exercises = state.value.exercises,
                trainings = state.value.trainings
            )
        )
    }

    private fun calculateMonthTrainings(
        month: Int,
        year: Int,
        exercises: Map<ExerciseInfo, List<Exercise>>,
        trainings: List<Training>
    ): List<Int> {
        return exercises
            .flatMap { flat -> flat.value.map { flat.key to flat.value } }
            .filter { it.first.month == month && it.first.year == year }
            .map { it.first.day }
            .takeIf { exercises.isNotEmpty() }
            ?: trainings
                .filter { it.month == month && it.year == year }
                .map { it.day }
                .takeIf { state.value.query.isEmpty() }
            ?: emptyList()
    }

    private fun calculateListOfTonnage(exercises: Map<ExerciseInfo, List<Exercise>>): List<Float> {
        return exercises
            .flatMap { it.value }
            .map { it.tonnage.toFloat() }
            .takeIf { it.isNotEmpty() } ?: state.value.trainings
            .mapNotNull { it.tonnage?.toFloat() }
    }

    private fun calculateListOfIntensity(exercises: Map<ExerciseInfo, List<Exercise>>): List<Float> {
        return exercises
            .flatMap { it.value }
            .map { it.intensity.toFloat() }
            .takeIf { it.isNotEmpty() } ?: state.value.trainings
            .mapNotNull { it.intensity?.toFloat() }
    }

//    override fun onCleared() {
//        super.onCleared()
//        searchJob?.cancel()
//        searchJob = null
//    }

    private fun List<ExerciseDate>.processingExercises() = this
        .groupBy(
            { ExerciseInfo(trainingId = it.trainingId, date = it.date) },
            { it.exercise.toExerciseState() }
        )
}