package trainings.screen

import DateTimeKtx
import PlatformBackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import components.Error
import components.Loading
import components.placeholders.EmptyTraining
import components.roots.Root
import platformBottomInset
import trainings.components.NewTraining
import trainings.components.PaginatedCalendar
import trainings.components.TrainingItem
import trainings.state.SelectableCalendar
import trainings.state.Training

@Composable
fun TrainingsContent(
    vm: TrainingsViewModel,
    toTrainingById: (trainingId: String) -> Unit,
    toNewTraining: () -> Unit,
    addTrainingWithTemplate: (trainingId: String) -> Unit,
    back: () -> Unit,
) {

    val state by vm.state.collectAsState()

    LaunchedEffect(Unit) {
        vm.getTrainings()
    }

    Content(
        loading = { state.loading },
        error = { state.error },
        clearError = vm::clearError,
        back = back,
        newTraining = toNewTraining,
        calendar = state.calendar,
        trainings = { state.trainings },
        openTraining = toTrainingById,
        addCalendarChunk = vm::addCalendarChunk,
        selectCalendarDay = vm::selectCalendarDay,
        trainingWithTemplate = addTrainingWithTemplate
    )
}

@Composable
private fun Content(
    // BASE
    loading: () -> Boolean,
    error: () -> String?,
    clearError: () -> Unit,
    back: () -> Unit,

    // HEADER
    newTraining: () -> Unit,

    // CONTENT
    calendar: List<SelectableCalendar>,
    trainings: () -> List<Training>,

    openTraining: (trainingId: String) -> Unit,
    trainingWithTemplate: (trainingId: String) -> Unit,
    addCalendarChunk: () -> Unit,
    selectCalendarDay: (dateTimeIso: String) -> Unit,
) {

    val backProvider by rememberUpdatedState(back)

    val selectedDate = calendar.findLast { it.isSelected }?.dateTimeIso ?: return
    val selectedDateIsToday = DateTimeKtx.isCurrentDate(selectedDate)

    val trainingList = remember(trainings(), selectedDate) {
        trainings().filter { training ->
            DateTimeKtx.isTheSameDate(training.startDateTime, selectedDate)
        }
    }

    Root(
        loading = { Loading(loading) },
        error = { Error(message = error, close = clearError) },
        back = { PlatformBackHandler(backProvider) },
    ) {

        if (selectedDateIsToday.not() && trainingList.isEmpty()) {
            EmptyTraining(
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }

        Column {
            PaginatedCalendar(
                calendar = calendar,
                onAddMore = addCalendarChunk,
                selectCalendarDay = selectCalendarDay
            )

            LazyColumn(modifier = Modifier.fillMaxSize()) {

                if (selectedDateIsToday) {
                    item {
                        NewTraining(
                            newTraining = newTraining
                        )
                    }
                }

                items(trainingList) { training ->
                    TrainingItem(
                        training = training,
                        onDetailsClick = {
                            val id = training.id ?: return@TrainingItem
                            openTraining.invoke(id)
                        },
                        onTemplateClick = {
                            val id = training.id ?: return@TrainingItem
                            trainingWithTemplate.invoke(id)
                        }
                    )
                }

                if (trainingList.isNotEmpty()) {
                    item {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .platformBottomInset()
                        )
                    }
                }
            }
        }
    }
}