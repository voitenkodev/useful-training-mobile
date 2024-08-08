package trainings.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import components.EmptyData
import components.Error
import components.roots.ScreenRoot
import kotlinx.collections.immutable.ImmutableList
import trainings.main.components.Header
import trainings.main.components.Trainings
import trainings.main.models.SelectableCalendar
import trainings.main.models.Training

@Composable
internal fun TrainingsContent(
    vm: TrainingsViewModel,
    toTrainingById: (trainingId: String) -> Unit,
    toNewTraining: () -> Unit
) {

    val state by vm.state.collectAsState()

    Content(
        error = { state.error },
        clearError = vm::clearError,
        newTraining = toNewTraining,
        calendar = state.calendar,
        trainings = state.displayedTrainings,
        openTraining = toTrainingById,
        addCalendarChunk = vm::addCalendarChunk,
        selectCalendarDay = vm::selectCalendarDay
    )
}

@Composable
private fun Content(
    error: () -> String?,
    clearError: () -> Unit,
    calendar: ImmutableList<SelectableCalendar>,
    trainings: ImmutableList<Training>,
    newTraining: () -> Unit,
    openTraining: (trainingId: String) -> Unit,
    addCalendarChunk: () -> Unit,
    selectCalendarDay: (dateTimeIso: String) -> Unit
) {

    val selectedDate = calendar.findLast { it.isSelected } ?: return
    val selectedDateIsToday = selectedDate.isToday

    ScreenRoot(error = { Error(message = error, close = clearError) }) {

        Column {
            Header(
                calendar = calendar,
                onAddMore = addCalendarChunk,
                selectCalendarDay = selectCalendarDay
            )

            if (selectedDateIsToday.not() && trainings.isEmpty()) {
                EmptyData(
                    modifier = Modifier.fillMaxWidth().weight(1f),
                    title = "No one workout",
                    description = "You don't have any workouts at this day"
                )
            } else {
                Trainings(
                    trainings = trainings,
                    selectedDateIsToday = selectedDateIsToday,
                    newTraining = newTraining,
                    openTraining = openTraining
                )
            }
        }
    }
}