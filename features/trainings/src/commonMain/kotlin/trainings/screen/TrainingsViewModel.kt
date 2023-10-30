package trainings.screen

import DateTimeKtx
import DateTimeKtx.addEarlyCalendarChunk
import TrainingsRepository
import ViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import org.koin.core.component.inject
import trainings.mapping.toState
import trainings.state.SelectableCalendar
import trainings.state.State
import trainings.state.Training

internal class TrainingsViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state

    private val trainingApi by inject<TrainingsRepository>()

    companion object {
        private const val DAY_PAGE_CHUNK = 40
    }

    init {
        addCalendarChunk()
        selectCalendarDay(DateTimeKtx.currentDateTime())
        getTrainings()
    }

    private fun getTrainings() {
        trainingApi.getTrainings(
            startDate = "2022-10-29T19:39:37.988Z",
            endDate = "2024-10-29T19:39:37.989Z"
        )
            .onStart {
                _state.update { it.copy(loading = true) }
            }.onEach { t ->

                val trainings = t.toState()

                _state.update {
                    val selectedDates = it.calendar
                        .filter { c -> c.isSelected }
                        .map { c -> c.dateTimeIso }

                    it.copy(
                        trainings = trainings,
                        displayedTrainings = trainings.getTrainingsByDate(selectedDates).toPersistentList(),
                        calendar = it.calendar.syncWithTrainings(trainings).toPersistentList(),
                        loading = false
                    )
                }
            }.catch { t ->
                _state.update { it.copy(loading = false, error = t.message) }
            }.launchIn(this)
    }

    fun addCalendarChunk() {
        _state.update {
            val newList = buildList {
                val newChunk = addEarlyCalendarChunk(
                    count = DAY_PAGE_CHUNK,
                    previousList = it.calendar.map { it.dateTimeIso }
                ).map { item ->
                    SelectableCalendar(
                        isSelected = false,
                        isToday = DateTimeKtx.isCurrentDate(item),
                        dateTimeIso = item,
                        day = DateTimeKtx.formattedDate(item) ?: "-",
                        weekDay = DateTimeKtx.formattedDayOfWeek(item) ?: "-",
                        countOfTrainings = 0
                    )
                }
                    .syncWithTrainings(it.trainings)
                    .toPersistentList()

                addAll(it.calendar)
                addAll(newChunk)

            }.toPersistentList()

            it.copy(calendar = newList)
        }
    }

    fun selectCalendarDay(dateTimeIso: String) {
        val newList = state.value.calendar.map {
            val isSelected = DateTimeKtx.isTheSameDate(it.dateTimeIso, dateTimeIso)
            it.copy(isSelected = isSelected)
        }.toPersistentList()

        val selectedList = newList
            .filter { it.isSelected }
            .map { it.dateTimeIso }

        _state.update {
            it.copy(
                calendar = newList,
                displayedTrainings = it.trainings.getTrainingsByDate(selectedList).toPersistentList()
            )
        }
    }

    private fun List<Training>.getTrainingsByDate(dateTimeIsoList: List<String>): List<Training> {
        if (dateTimeIsoList.isEmpty())
            return emptyList()

        return filter { training ->
            DateTimeKtx.isOneOfDates(training.dateIso, dateTimeIsoList)
        }.toImmutableList()
    }

    private fun List<SelectableCalendar>.syncWithTrainings(trainings: List<Training>) = map { item ->
        val count = trainings.count { DateTimeKtx.isTheSameDate(item.dateTimeIso, it.dateIso) }
        item.copy(countOfTrainings = count)
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}