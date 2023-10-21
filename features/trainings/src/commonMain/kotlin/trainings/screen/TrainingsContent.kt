package trainings.screen

import Design
import PlatformBackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import components.Error
import components.Loading
import components.buttons.ButtonQuestion
import components.placeholders.EmptyTraining
import components.roots.Root
import kotlinx.collections.immutable.ImmutableList
import trainings.components.Exercise
import trainings.components.NewTraining
import trainings.components.PaginatedCalendar
import trainings.components.TrainingHeader
import trainings.components.TrainingTitle
import trainings.state.SelectableCalendar
import trainings.state.Training

@Composable
internal fun TrainingsContent(
    vm: TrainingsViewModel,
    toTrainingById: (trainingId: String) -> Unit,
    toNewTraining: () -> Unit,
    addTrainingWithTemplate: (trainingId: String) -> Unit,
    back: () -> Unit,
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
    selectCalendarDay: (dateTimeIso: String) -> Unit,
) {

    val backProvider by rememberUpdatedState(back)

    val selectedDate = calendar.findLast { it.isSelected } ?: return
    val selectedDateIsToday = selectedDate.isToday

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

            if (selectedDateIsToday.not() && trainings.isEmpty()) {
                EmptyTraining(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                )
            } else {
                LazyColumn(modifier = Modifier.fillMaxSize()) {

                    if (selectedDateIsToday) {
                        item {
                            NewTraining(
                                newTraining = newTraining
                            )
                        }
                    }

                    trainings.forEach { training ->

                        item("header:${training.id}") {

                            Spacer(
                                modifier = Modifier.size(Design.dp.paddingM)
                            )

                            TrainingHeader(
                                modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                                training = training
                            )

                            Spacer(
                                modifier = Modifier.size(Design.dp.paddingM)
                            )

                            TrainingTitle(
                                mainTitle = { "At ${training.startDate}" },
                                click = {
                                    val id = training.id ?: return@TrainingTitle
                                    openTraining.invoke(id)
                                },
                            )

                            Spacer(
                                modifier = Modifier.size(Design.dp.paddingM)
                            )
                        }

                        itemsIndexed(
                            training.exercises,
                            key = { _, item -> "${training.id}:${item.id}" }
                        ) { index, item ->

                            val number by rememberUpdatedState(index + 1)

                            Exercise(
                                modifier = Modifier,
                                number = number,
                                exercise = item
                            )
                        }

                        item("footer:${training.id}") {

                            Spacer(
                                modifier = Modifier.size(Design.dp.paddingM)
                            )

                            ButtonQuestion(
                                modifier = Modifier.fillMaxWidth(),
                                question = "Use training as",
                                answer = "Template",
                                onClick = {
                                    val id = training.id ?: return@ButtonQuestion
                                    trainingWithTemplate.invoke(id)
                                }
                            )

                            Spacer(
                                modifier = Modifier.size(Design.dp.paddingS)
                            )
                        }
                    }
                }
            }
        }
    }
}