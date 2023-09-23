package trainings

import DateTimeKtx
import Design
import PlatformBackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import atomic.rememberAccentColorsAsState
import components.Error
import components.Loading
import components.PaginatedCalendar
import components.TrainingItem
import components.TrainingsControls
import components.backgrounds.BrandGradientCenterEnd
import components.backgrounds.BrandGradientCenterStart
import components.roots.Root
import next
import platformBottomInset
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

    val accentList = rememberAccentColorsAsState()
    val selectedColor = remember { mutableStateOf(accentList.value.first()) }

    LaunchedEffect(selectedDate) {
        val next = accentList.value.next(last = selectedColor.value) ?: return@LaunchedEffect
        selectedColor.value = next
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
                    .fillMaxSize()
                    .platformBottomInset(),
                verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
            ) {

                items(trainingList) { training ->
                    TrainingItem(
                        training = training,
                        color = selectedColor.value,
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

        BrandGradientCenterEnd(color = selectedColor.value)

        BrandGradientCenterStart(color = selectedColor.value)
    }
}