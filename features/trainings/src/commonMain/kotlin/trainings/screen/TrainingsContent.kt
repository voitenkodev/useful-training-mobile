package trainings.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import components.Error
import components.roots.ScreenRoot
import kotlinx.collections.immutable.ImmutableList
import trainings.components.EmptyTraining
import trainings.components.Header
import trainings.components.Trainings
import trainings.state.SelectableCalendar
import trainings.state.Training

@Composable
internal fun TrainingsContent(
    vm: TrainingsViewModel,
    toTrainingById: (trainingId: String) -> Unit,
    toNewTraining: () -> Unit,
    addTrainingWithTemplate: (trainingId: String) -> Unit,
    back: () -> Unit
) {

    val state by vm.state.collectAsState()

    Content(
        loading = { state.loading },
        error = { state.error },
        clearError = vm::clearError,
        back = back,
        newTraining = toNewTraining,
        calendar = state.calendar,
        trainings = state.displayedTrainings,
        openTraining = toTrainingById,
        addCalendarChunk = vm::addCalendarChunk,
        selectCalendarDay = vm::selectCalendarDay,
        trainingWithTemplate = addTrainingWithTemplate
    )
}

@Composable
private fun Content(
    loading: () -> Boolean,
    error: () -> String?,
    clearError: () -> Unit,
    back: () -> Unit,

    calendar: ImmutableList<SelectableCalendar>,
    trainings: ImmutableList<Training>,

    newTraining: () -> Unit,
    openTraining: (trainingId: String) -> Unit,
    trainingWithTemplate: (trainingId: String) -> Unit,
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
                EmptyTraining(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                )
            } else {
                Trainings(
                    trainings = trainings,
                    selectedDateIsToday = selectedDateIsToday,
                    newTraining = newTraining,
                    openTraining = openTraining,
                    trainingWithTemplate = trainingWithTemplate
                )
            }
        }
    }
}