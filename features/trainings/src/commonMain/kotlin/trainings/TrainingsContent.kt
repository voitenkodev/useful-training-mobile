package trainings

import DateTimeKtx
import PlatformBackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import components.Error
import components.Loading
import components.PaginatedCalendar
import components.TrainingItem
import components.TrainingsControls
import components.roots.Root
import training.Training

@Composable
fun TrainingsContent(
    vm: TrainingsViewModel,
    toTrainingById: (trainingId: String) -> Unit,
    toNewTraining: () -> Unit,
    back: () -> Unit,
    toAuth: () -> Unit,
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
        logout = { vm.logout(toAuth) },
        calendar = state.calendar,
        trainings = { state.trainings },
        openTraining = toTrainingById,
        addCalendarChunk = vm::addCalendarChunk,
        selectCalendarDay = vm::selectCalendarDay
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
    logout: () -> Unit,

    // CONTENT
    calendar: List<SelectableCalendar>,
    trainings: () -> List<Training>,

    openTraining: (trainingId: String) -> Unit,
    addCalendarChunk: () -> Unit,
    selectCalendarDay: (dateTimeIso: String) -> Unit,
) {

    val addTrainingProvider by rememberUpdatedState(newTraining)
    val backProvider by rememberUpdatedState(back)

    val selectedDate = calendar.findLast { it.isSelected }?.dateTimeIso ?: return

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

        Column {

            PaginatedCalendar(
                calendar = calendar,
                onAddMore = addCalendarChunk,
                selectCalendarDay = selectCalendarDay
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
            ) {

                items(trainingList) { training ->
                    TrainingItem(
                        training = training,
                        onClick = {
                            val id = training.id ?: return@TrainingItem
                            openTraining.invoke(id)
                        }
                    )
                }
            }
        }

        TrainingsControls(
            addTraining = addTrainingProvider,
            logout = logout
        )
    }
}