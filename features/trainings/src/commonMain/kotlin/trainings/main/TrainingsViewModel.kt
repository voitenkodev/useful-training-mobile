package trainings.main

import DateTimeKtx
import DateTimeKtx.addEarlyCalendarChunk
import TrainingsRepository
import ViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import org.koin.core.component.inject
import trainings.main.mapping.toState
import trainings.main.models.SelectableCalendar
import trainings.main.models.Training

internal class TrainingsViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state.asStateFlow()

    private val trainingApi by inject<TrainingsRepository>()

    companion object {
        private const val DAY_PAGE_CHUNK = 40
    }

    init {
        addCalendarChunk()
        selectCalendarDay(DateTimeKtx.currentDateTime())

        _state.mapNotNull {
            val first = it.calendar.firstOrNull()?.dateTimeIso ?: return@mapNotNull null
            val last = it.calendar.lastOrNull()?.dateTimeIso ?: return@mapNotNull null
            first to last
        }.distinctUntilChanged()
            .flatMapLatest {
                trainingApi
                    .observeTrainings(startDate = it.first, endDate = it.second)
                    .map { t -> t.toState() }
                    .onEach { t ->
                        _state.update { st ->

                            val selectedDates = st.calendar
                                .filter { c -> c.isSelected }
                                .map { c -> c.dateTimeIso }

                            st.copy(
                                trainings = t,
                                displayedTrainings = t.getTrainingsByDate(selectedDates).toPersistentList(),
                                calendar = st.calendar.syncWithTrainings(t).toPersistentList(),
                            )
                        }
                    }
            }.launchIn(this)
    }

    private fun syncTrainings(fromIso: String, toIso: String) {
        trainingApi
            .syncTrainings(startDate = fromIso, endDate = toIso)
            .catch { t -> _state.update { it.copy(error = t.message) } }
            .launchIn(this)
    }

    fun addCalendarChunk() {
        _state.update {
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
                    repetitions = 0
                )
            }.syncWithTrainings(it.trainings)

            val first = newChunk.firstOrNull()
            val last = newChunk.lastOrNull()

            if (first != null && last != null) syncTrainings(fromIso = last.dateTimeIso, toIso = first.dateTimeIso)

            it.copy(calendar = (it.calendar + newChunk).toPersistentList())
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
            it.copy(calendar = newList, displayedTrainings = it.trainings.getTrainingsByDate(selectedList).toPersistentList())
        }
    }

    private fun List<Training>.getTrainingsByDate(dateTimeIsoList: List<String>): List<Training> {
        if (dateTimeIsoList.isEmpty()) return emptyList()

        return this
            .filter { training -> DateTimeKtx.isOneOfDates(training.dateIso, dateTimeIsoList) }
            .toImmutableList()
    }

    private fun List<SelectableCalendar>.syncWithTrainings(trainings: List<Training>) = map { item ->
        val count = trainings.count { DateTimeKtx.isTheSameDate(item.dateTimeIso, it.dateIso) }
        item.copy(repetitions = count)
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}