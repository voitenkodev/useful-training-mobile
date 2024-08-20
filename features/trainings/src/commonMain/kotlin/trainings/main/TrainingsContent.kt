package trainings.main

import DateTimeKtx
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import components.EmptyData
import components.Error
import components.roots.ScreenRoot
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonPrimary
import resources.Icons
import trainings.Training
import trainings.main.components.Header
import trainings.main.components.Trainings
import trainings.main.models.SelectableCalendar

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
    val currentDay = remember { calendar.findLast { it.isToday }?.dateTimeIso }
    val selectedDateIsToday = selectedDate.isToday
    val formatterDate = remember(selectedDate) {
        DateTimeKtx.formattedDate1(selectedDate.dateTimeIso)
    }

    val backTodayProvider: () -> Unit = remember {
        {
            currentDay?.let(selectCalendarDay)
        }
    }

    ScreenRoot(error = { Error(message = error, close = clearError) }) {

        Column(modifier = Modifier.fillMaxSize().statusBarsPadding()) {

            Header(
                calendar = calendar,
                onAddMore = addCalendarChunk,
                selectCalendarDay = selectCalendarDay
            )

            when {
                trainings.isEmpty() -> {
                    EmptyData(
                        modifier = Modifier.fillMaxWidth().weight(1f),
                        icon = Icons.emptyTraining,
                        title = "No one workout",
                        description = "You don't have any workouts\nat $formatterDate"
                    )

                    Spacer(
                        Modifier.height(
                            Design.dp.componentS + Design.dp.paddingL + Design.dp.paddingL
                        )
                    )
                }

                else -> {
                    Trainings(
                        trainings = trainings,
                        openTraining = openTraining
                    )
                }
            }
        }

        ButtonPrimary(
            modifier = Modifier.align(Alignment.BottomEnd).padding(Design.dp.paddingL),
            text = "Start workout",
            leadingIcon = Icons.add,
            onClick = newTraining,
        )
    }
}