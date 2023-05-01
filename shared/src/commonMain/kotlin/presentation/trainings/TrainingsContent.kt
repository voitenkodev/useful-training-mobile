package presentation.trainings

import PlatformBackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import design.Design
import design.components.Error
import design.components.Loading
import design.components.items.TrainingItem
import design.components.items.WeekSummary
import design.components.roots.ScrollableRoot
import design.controls.IconPrimary
import design.controls.TextFieldBody1
import design.controls.TextFieldH1
import presentation.training.Training

@Composable
internal fun TrainingsContent(vm: TrainingsViewModel) {

    val state by vm.state.collectAsState()

    LaunchedEffect(Unit) { vm.getTrainings() }

    val listState = rememberLazyListState()

    Content(
        listState = listState,
        loading = state.loading,
        error = state.error,
        clearError = vm::clearError,
        back = vm::back,

        weekDay = state.weekDay,
        date = state.date,
        moveToSummary = vm::moveToSummary,
        addTraining = vm::addTraining,

        weekTrainings = state.weekTrainings,
        editTraining = vm::editTraining,
        reviewTraining = vm::reviewTraining
    )
}

@Composable
private fun Content(
    listState: LazyListState,
    loading: Boolean,
    error: String?,
    clearError: () -> Unit,
    back: () -> Unit,

    // HEADER
    weekDay: String,
    date: String,
    moveToSummary: () -> Unit,
    addTraining: () -> Unit,

    // CONTENT
    weekTrainings: Map<WeekInfo, List<Training>>,
    editTraining: (Training) -> Unit,
    reviewTraining: (Training) -> Unit,
) {

    val weekTrainingsProvider by rememberUpdatedState(weekTrainings)

    ScrollableRoot(
        modifier = Modifier.fillMaxSize(),
        listState = listState,
        loading = { Loading(loading) },
        error = { Error(message = error, close = clearError) },
        back = { PlatformBackHandler(back) },
        popups = {},
        header = {

            val moveToSummaryProvider by rememberUpdatedState(moveToSummary)
            val addTrainingProvider by rememberUpdatedState(addTraining)

            Header(
                weekDay = weekDay,
                date = date,
                moveToSummary = moveToSummaryProvider,
                addTraining = addTrainingProvider
            )
        },
        content = {

            weekTrainingsProvider.onEach {

                item(key = "week_by_${it.key}") {
                    WeekSummary(info = it.key)
                }

                items(it.value, key = { it.id ?: it.hashCode() }) { training ->

                    val trainingProvider by rememberUpdatedState(training)

                    TrainingItem(
                        training = training,
                        edit = { editTraining(trainingProvider) },
                        review = { reviewTraining(trainingProvider) }
                    )
                }
            }
        }
    )
}

@Composable
private fun Header(
    weekDay: String,
    date: String,
    moveToSummary: () -> Unit,
    addTraining: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(Design.dp.bigHeader)
            .background(Design.colors.primary),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Title(
            modifier = Modifier,
            weekDay = weekDay,
            date = date,
        )

        HeaderButtons(
            modifier = Modifier,
            moveToSummary = moveToSummary,
            addTraining = addTraining
        )
    }
}

@Composable
private fun HeaderButtons(
    modifier: Modifier = Modifier,
    moveToSummary: () -> Unit,
    addTraining: () -> Unit,
) {
    Row(
        modifier = modifier
            .height(Design.dp.bigHeader)
            .padding(end = Design.dp.padding, bottom = Design.dp.padding),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.spacedBy(Design.dp.padding, Alignment.End)
    ) {

        IconPrimary(
            imageVector = Icons.Default.Search,
            modifier = Modifier
                .size(Design.dp.component)
                .background(
                    color = Design.colors.accent_secondary,
                    shape = Design.shape.default
                ),
            onClick = moveToSummary
        )

        IconPrimary(
            imageVector = Icons.Default.Add,
            modifier = Modifier
                .size(Design.dp.component)
                .background(
                    color = Design.colors.accent_primary,
                    shape = Design.shape.default
                ),
            onClick = addTraining
        )
    }
}

@Composable
private fun Title(
    modifier: Modifier = Modifier,
    weekDay: String,
    date: String,
) = Column(
    modifier = modifier
        .padding(start = Design.dp.padding)
) {

    TextFieldH1(
        modifier = Modifier
            .wrapContentHeight(),
        provideText = { weekDay },
    )

    TextFieldBody1(
        modifier = Modifier,
        provideText = { date },
    )
}