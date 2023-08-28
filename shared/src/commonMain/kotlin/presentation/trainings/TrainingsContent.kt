package presentation.trainings

import Design
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
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import components.Error
import components.Loading
import components.TrainingItem
import components.WeekSummary
import components.roots.ScrollableRoot
import controls.IconPrimary
import controls.TextFieldBody1
import controls.TextFieldH1
import controls.primaryBackground
import presentation.training.Training
import utils.recomposeHighlighter

@Composable
internal fun TrainingsContent(vm: TrainingsViewModel) {

    val state by vm.state.collectAsState()

    val listState = rememberLazyListState()

    LaunchedEffect(Unit) {
        vm.getTrainings()
    }

    Content(
        listState = listState,
        loading = { state.loading },
        error = { state.error },
        clearError = vm::clearError,
        back = vm::back,

        weekDay = { state.weekDay },
        date = { state.date },
        moveToSummary = vm::moveToSummary,
        addTraining = vm::addTraining,
        logout = vm::logout,

        weekTrainings = { state.weekTrainings },
        editTraining = vm::editTraining,
        reviewTraining = vm::reviewTraining
    )
}

@Composable
private fun Content(
    listState: LazyListState,

    loading: () -> Boolean,
    error: () -> String?,
    clearError: () -> Unit,
    back: () -> Unit,

    // HEADER
    weekDay: () -> String,
    date: () -> String,
    moveToSummary: () -> Unit,
    addTraining: () -> Unit,
    logout: () -> Unit,

    // CONTENT
    weekTrainings: () -> Map<WeekInfo, List<Training>>,
    editTraining: (Training) -> Unit,
    reviewTraining: (Training) -> Unit,
) {

    val moveToSummaryProvider by rememberUpdatedState(moveToSummary)
    val addTrainingProvider by rememberUpdatedState(addTraining)

    ScrollableRoot(
        modifier = Modifier
            .fillMaxSize()
            .recomposeHighlighter(),
        listState = listState,
        loading = { Loading(loading) },
        error = { Error(message = error, close = clearError) },
        back = { PlatformBackHandler(back) },
        header = {
            Header(
                weekDay = weekDay,
                date = date,
                moveToSummary = moveToSummaryProvider,
                logout = logout
            )
        },
        content = {

            weekTrainings().onEach {

                item(key = "week_by_${it.key}") {
                    WeekSummary(
                        modifier = Modifier
                            .recomposeHighlighter(),
                        info = it.key
                    )
                }

                items(it.value, key = { item -> item.id ?: item.hashCode() }) { training ->

                    val trainingProvider by rememberUpdatedState(training)

                    TrainingItem(
                        modifier = Modifier
                            .recomposeHighlighter(),
                        training = training,
                        edit = { editTraining(trainingProvider) },
                        review = { reviewTraining(trainingProvider) }
                    )
                }
            }
        },
        footer = {
            IconPrimary(
                imageVector = Icons.Default.Add,
                modifier = Modifier
                    .height(Design.dp.component)
                    .fillMaxWidth()
                    .background(
                        color = Design.colors.accent_primary,
                        shape = Design.shape.default
                    ).recomposeHighlighter(),
                onClick = addTrainingProvider
            )
        }
    )
}

@Composable
private fun Header(
    weekDay: () -> String,
    date: () -> String,
    moveToSummary: () -> Unit,
    logout: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(Design.dp.bigHeader)
            .primaryBackground()
            .recomposeHighlighter(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Title(
            weekDay = weekDay,
            date = date,
        )

        HeaderButtons(
            moveToSummary = moveToSummary,
            logout = logout
        )
    }
}

@Composable
private fun HeaderButtons(
    modifier: Modifier = Modifier,
    moveToSummary: () -> Unit,
    logout: () -> Unit,
) {
    Row(
        modifier = modifier
            .height(Design.dp.bigHeader)
            .padding(end = Design.dp.padding, bottom = Design.dp.padding)
            .recomposeHighlighter(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.spacedBy(Design.dp.padding, Alignment.End)
    ) {

        IconPrimary(
            imageVector = Icons.Default.ExitToApp,
            modifier = Modifier
                .size(Design.dp.component)
                .background(
                    color = Design.colors.accent_tertiary,
                    shape = Design.shape.default
                ).recomposeHighlighter(),
            onClick = logout
        )
        IconPrimary(
            imageVector = Icons.Default.Search,
            modifier = Modifier
                .size(Design.dp.component)
                .background(
                    color = Design.colors.accent_secondary,
                    shape = Design.shape.default
                ).recomposeHighlighter(),
            onClick = moveToSummary
        )
    }
}

@Composable
private fun Title(
    modifier: Modifier = Modifier,
    weekDay: () -> String,
    date: () -> String,
) = Column(
    modifier = modifier
        .padding(start = Design.dp.padding)
        .recomposeHighlighter()
) {

    TextFieldH1(
        modifier = Modifier
            .wrapContentHeight()
            .recomposeHighlighter(),
        provideText = weekDay,
    )

    TextFieldBody1(
        modifier = Modifier
            .recomposeHighlighter(),
        provideText = date,
    )
}