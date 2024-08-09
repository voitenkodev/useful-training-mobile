package trainings.main

import DateTimeKtx
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import components.EmptyData
import components.Error
import components.ShadowBottomButtons
import components.roots.ScreenRoot
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonPrimary
import molecule.ButtonSecondary
import resources.Icons
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
    val currentDay = remember { calendar.findLast { it.isToday }?.dateTimeIso }
    val selectedDateIsToday = selectedDate.isToday
    val formatterDate = remember(selectedDate) {
        DateTimeKtx.formattedLongDate(selectedDate.dateTimeIso)
    }

    val backTodayProvider: () -> Unit = remember {
        {
            currentDay?.let(selectCalendarDay)
        }
    }

    ScreenRoot(error = { Error(message = error, close = clearError) }) {

        Column {
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
                            Design.dp.componentM + Design.dp.paddingL + Design.dp.paddingL
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

        ShadowBottomButtons(
            modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),
            contentPadding = PaddingValues(
                start = Design.dp.paddingL,
                end = Design.dp.paddingL,
                bottom = Design.dp.paddingL
            ),
            navigationBarsPadding = false,
            first = {
                if (selectedDateIsToday.not()) {
                    ButtonSecondary(
                        modifier = Modifier.weight(1f),
                        text = "Today",
                        onClick = backTodayProvider
                    )
                }
            },
            second = {
                if (selectedDateIsToday) {
                    ButtonPrimary(
                        modifier = Modifier.weight(1f),
                        text = "Start workout",
                        backgroundColor = Design.colors.toxic,
                        textColor = Design.colors.primary,
                        onClick = newTraining,
                    )
                }
            }
        )
    }
}