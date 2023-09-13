package trainings

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
import recomposeHighlighter
import training.Training

@Composable
fun TrainingsContentOld(
    vm: TrainingsViewModel,
    toTrainingReview: (trainingId: String) -> Unit,
    toTrainingById: (trainingId: String) -> Unit,
    toNewTraining: () -> Unit,
    toSummary: () -> Unit,
    back: () -> Unit,
) {

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
        back = back,

        weekDay = { state.weekDay },
        date = { state.date },
        moveToSummary = toSummary,
        newTraining = toNewTraining,
        logout = vm::logout,

        weekTrainings = { state.weekTrainings },
        editTraining = toTrainingById,
        reviewTraining = toTrainingReview
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
    newTraining: () -> Unit,
    logout: () -> Unit,

    // CONTENT
    weekTrainings: () -> Map<WeekInfo, List<Training>>,
    editTraining: (trainingId: String) -> Unit,
    reviewTraining: (trainingId: String) -> Unit,
) {

    val moveToSummaryProvider by rememberUpdatedState(moveToSummary)
    val addTrainingProvider by rememberUpdatedState(newTraining)

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
                        edit = {
                            val id = trainingProvider.id ?: return@TrainingItem
                            editTraining(id)
                        },
                        review = {
                            val id = trainingProvider.id ?: return@TrainingItem
                            reviewTraining(id)
                        }
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
            .padding(end = Design.dp.paddingM, bottom = Design.dp.paddingM)
            .recomposeHighlighter(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM, Alignment.End)
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