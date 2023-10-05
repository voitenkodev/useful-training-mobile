package trainings

import DateTimeKtx
import DateTimeKtx.addEarlyCalendarChunk
import ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import mapping.toTrainingStateList
import org.koin.core.component.inject
import repository.AuthRepository
import repository.TrainingRepository
import training.Training

class TrainingsViewModel : ViewModel() {

    private val _state = MutableStateFlow(TrainingsState())
    val state: StateFlow<TrainingsState> = _state

    private val trainingApi by inject<TrainingRepository>()
    private val authApi by inject<AuthRepository>()

    companion object {
        private const val DAY_PAGE_CHUNK = 40
    }

    init {
        addCalendarChunk()
        selectCalendarDay(DateTimeKtx.currentDateTime())
    }

    fun getTrainings() = launch {
        trainingApi.getTrainings()
            .onStart {
                _state.value = state.value.copy(loading = true)
            }.map {
                it.toTrainingStateList()
            }.onEach {
                _state.value = state.value.copy(
                    loading = false,
                    error = null,
                    trainings = it,
                    calendar = state.value.calendar.syncWithTrainings(it)
                )
            }.catch {
                _state.value = state.value.copy(loading = false, error = it.message)
            }.launchIn(this)
    }

    fun logout(onSuccess: () -> Unit) = launch {
        authApi.logout()
        onSuccess.invoke()
    }

    fun addCalendarChunk() {
        val newList = state.value.calendar + addEarlyCalendarChunk(
            count = DAY_PAGE_CHUNK,
            previousList = state.value.calendar.map { it.dateTimeIso }
        ).map { item ->
            SelectableCalendar(
                isSelected = false,
                isToday = DateTimeKtx.isCurrentDate(item),
                dateTimeIso = item,
                day = DateTimeKtx.formattedDate(item) ?: "-",
                weekDay = DateTimeKtx.formattedDayOfWeek(item) ?: "-",
                countOfTrainings = 0
            )
        }.syncWithTrainings(state.value.trainings)

        _state.value = state.value.copy(calendar = newList)
    }

    fun selectCalendarDay(dateTimeIso: String) {
        val newList = state.value.calendar.map {
            val isSelected = DateTimeKtx.isTheSameDate(it.dateTimeIso, dateTimeIso)
            it.copy(isSelected = isSelected)
        }
        _state.value = state.value.copy(calendar = newList)
    }

    private fun List<SelectableCalendar>.syncWithTrainings(trainings: List<Training>) = map { item ->
        val count = trainings.count { DateTimeKtx.isTheSameDate(item.dateTimeIso, it.startDateTime) }
        item.copy(countOfTrainings = count)
    }

    fun clearError() {
        _state.value = state.value.copy(error = null)
    }
}