package trainings

import Design
import PlatformBackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.PagerScope
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import chart.basic.BasicLineChart
import components.Error
import components.Loading
import components.TrainingComponent
import components.backgrounds.BrandGradientCenterEnd
import components.backgrounds.BrandGradientCenterStart
import components.roots.Root
import controls.ButtonPrimaryIcon
import controls.ButtonSecondaryIcon
import controls.TextFieldBody1
import controls.TextFieldH1
import controls.TextFieldH2
import controls.secondaryBackground
import kotlinx.coroutines.launch
import platformInsets
import recomposeHighlighter
import training.Training

@Composable
fun TrainingsContent(
    vm: TrainingsViewModel,
    toTrainingById: (trainingId: String) -> Unit,
    toNewTraining: () -> Unit,
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
        logout = vm::logout,

        trainings = { state.trainings.take(3) },
        editTraining = toTrainingById,
    )
}

@Composable
private fun Content(

    loading: () -> Boolean,
    error: () -> String?,
    clearError: () -> Unit,
    back: () -> Unit,

    // HEADER
    newTraining: () -> Unit,
    logout: () -> Unit,

    // CONTENT
    trainings: () -> List<Training>,
    editTraining: (trainingId: String) -> Unit,
) {

    val addTrainingProvider by rememberUpdatedState(newTraining)
    val backProvider by rememberUpdatedState(back)

    Root(
        loading = { Loading(loading) },
        error = { Error(message = error, close = clearError) },
        back = { PlatformBackHandler(backProvider) },
    ) {

        val pagerState = rememberPagerState { trainings().size }

        VerticalPager(state = pagerState) {
            TrainingPage(
                training = trainings()[it],
                editTraining = editTraining,
            )
        }

        BottomScreenControls(
            pagerState = pagerState,
            addTraining = addTrainingProvider,
            logout = logout
        )
    }
}

@Composable
private fun BoxScope.BottomScreenControls(
    pagerState: PagerState,
    addTraining: () -> Unit,
    logout: () -> Unit
) {

    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .platformInsets()
            .fillMaxHeight()
            .padding(Design.dp.padding)
            .align(Alignment.CenterEnd),
        verticalArrangement = Arrangement.spacedBy(Design.dp.padding)
    ) {

        ButtonPrimaryIcon(
            imageVector = Icons.Default.ExitToApp,
            onClick = logout
        )

        Spacer(modifier = Modifier.weight(1f))

        ButtonPrimaryIcon(
            enabled = pagerState.currentPage > 0,
            imageVector = Icons.Default.KeyboardArrowUp,
            onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(pagerState.currentPage - 1)
                }
            }
        )

        ButtonPrimaryIcon(
            enabled = pagerState.currentPage < (pagerState.pageCount - 1),
            imageVector = Icons.Default.KeyboardArrowDown,
            onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                }
            }
        )

        ButtonSecondaryIcon(
            imageVector = Icons.Default.Add,
            onClick = addTraining,
        )
    }
}

@Composable
private fun PagerScope.TrainingPage(
    training: Training,
    editTraining: (trainingId: String) -> Unit,
) {

    val trainingProvider by rememberUpdatedState(training)

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .platformInsets()
                .padding(Design.dp.padding),
        ) {

            Title(
                weekDay = { training.weekDay },
                date = { training.endOfWeek },
            )

            Spacer(
                modifier = Modifier.size(Design.dp.padding)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(100.dp)
                    .secondaryBackground()
            ) {

            }

            Spacer(modifier = Modifier.size(32.dp))

            TrainingComponent(
                modifier = Modifier
                    .recomposeHighlighter(),
                training = training,
            )

            Spacer(modifier = Modifier.size(8.dp))

            Column(
                modifier = Modifier
                    .width(IntrinsicSize.Min)
            ) {

                BasicLineChart(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(2.0f),
                    values = trainingProvider.exercises.map { it.tonnage.toFloat() },
                    color = Design.colors.accent_secondary
                )

                Spacer(modifier = Modifier.size(4.dp))

                TextFieldH2(
                    provideText = { "TONNAGE" }
                )
            }

            Spacer(modifier = Modifier.size(Design.dp.padding))

            ButtonPrimaryIcon(
                imageVector = Icons.Default.KeyboardArrowRight,
                onClick = {
                    val id = trainingProvider.id ?: return@ButtonPrimaryIcon
                    editTraining(id)
                }
            )
        }

        BrandGradientCenterEnd()

        BrandGradientCenterStart()
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