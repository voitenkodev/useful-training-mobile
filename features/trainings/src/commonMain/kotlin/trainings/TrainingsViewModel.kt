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

class TrainingsViewModel : ViewModel() {

    private val _state = MutableStateFlow(TrainingsState())
    val state: StateFlow<TrainingsState> = _state

    private val trainingApi by inject<TrainingRepository>()
    private val authApi by inject<AuthRepository>()

    init {
        addCalendarChunk()
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
                    trainings = it
                )
            }.catch {
                _state.value = state.value.copy(loading = false, error = it.message)
            }.launchIn(this)
    }

    fun logout(onSuccess: () -> Unit) {
        launch {
            authApi.logout()
            onSuccess.invoke()
        }
    }

    fun addCalendarChunk() {
        val newList = state.value.calendar + addEarlyCalendarChunk(
            count = 20,
            list = state.value.calendar.map { it.dateTimeIso }
        ).map {
            SelectableCalendar(
                isSelected = false,
                isToday = DateTimeKtx.isCurrentDate(it),
                dateTimeIso = it,
                day = DateTimeKtx.formattedDate(it) ?: "-",
                weekDay = DateTimeKtx.formattedDayOfWeek(it) ?: "-",
            )
        }
        _state.value = state.value.copy(calendar = newList)
    }

    fun selectCalendarDay(calendar: SelectableCalendar) {
        val newList = state.value.calendar.map {
            it.copy(
                isSelected = it == calendar
            )
        }
        _state.value = state.value.copy(calendar = newList)
    }

    fun clearError() {
        _state.value = state.value.copy(error = null)
    }
}