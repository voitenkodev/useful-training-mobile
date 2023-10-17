package trainings

import DateTimeKtx
import Design
import PlatformBackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import components.Error
import components.Loading
import components.PaginatedCalendar
import components.TrainingItem
import components.placeholders.EmptyTraining
import components.roots.Root
import controls.TextFieldH3
import platformBottomInset
import training.Training

@Composable
fun TrainingsContent(
    vm: TrainingsViewModel,
    toTrainingById: (trainingId: String) -> Unit,
    toNewTraining: () -> Unit,
    addTrainingWithTemplate: (trainingId: String) -> Unit,
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
    logout: () -> Unit,

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

@Composable
private fun NewTraining(newTraining: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(2f)
            .padding(Design.dp.paddingM)
            .border(
                width = 1.dp,
                shape = Design.shape.default,
                color = Design.colors.caption
            ).clickable(onClick = newTraining)
            .clip(shape = Design.shape.default),
        content = {

            TextFieldH3(
                modifier = Modifier
                    .align(Alignment.Center),
                provideText = { "ADD WORKOUT" },
                color = Design.colors.content
            )
        }
    )
}