package trainings

import Design
import PlatformBackHandler
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import atomic.rememberAccentColorsAsState
import components.Error
import components.Loading
import components.TrainingItem
import components.TrainingsControls
import components.backgrounds.BrandGradientCenterEnd
import components.backgrounds.BrandGradientCenterStart
import components.roots.Root
import conditional
import controls.TextFieldBody1
import controls.TextFieldH1
import controls.TextFieldH2
import controls.accentBackground
import controls.secondaryBackground
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import platformBottomInset
import platformTopInset
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
        addCalendarChunk = vm::addCalendarChunk
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
) {

    val addTrainingProvider by rememberUpdatedState(newTraining)
    val backProvider by rememberUpdatedState(back)

    val pagerState = rememberPagerState { trainings().size }
    val accentList = rememberAccentColorsAsState()
    val scope = rememberCoroutineScope()

    val showFrameDuration = Design.duration.animDurationS
    val showFrame = remember { mutableStateOf(true) }
    val offset = animateDpAsState(
        targetValue = if (showFrame.value) 0.dp else 250.dp,
        tween(durationMillis = showFrameDuration, easing = FastOutLinearInEasing)
    )

    Root(
        loading = { Loading(loading) },
        error = { Error(message = error, close = clearError) },
        back = { PlatformBackHandler(backProvider) },
    ) {

        Column(modifier = Modifier.platformTopInset()) {

            Spacer(Modifier.size(Design.dp.component))

            TextFieldH1(
                modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                provideText = { "October" },
            )

            PaginatedCalendar(
                calendar = calendar,
                onAddMore = addCalendarChunk
            )

            HorizontalPager(
                modifier = Modifier
                    .weight(1f),
                state = pagerState,
                userScrollEnabled = showFrame.value
            ) {

                val training by rememberUpdatedState(trainings()[it])

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .platformBottomInset()
                ) {

                    TrainingItem(
                        training = training
                    )
                }
            }
        }

        TrainingsControls(
            pagerState = pagerState,
            visibilityCondition = { showFrame.value },
            addTraining = addTrainingProvider,
            logout = logout,
            openTraining = {
                val id = trainings()[pagerState.currentPage].id ?: return@TrainingsControls
                scope.launch {
                    showFrame.value = false
                    delay(showFrameDuration.toLong())
                    openTraining.invoke(id)
                }
            }
        )

        BrandGradientCenterEnd(
            modifier = Modifier.offset(x = offset.value),
            color = accentList.value[pagerState.currentPage % accentList.value.size]
        )

        BrandGradientCenterStart(
            modifier = Modifier.offset(x = -(offset.value)),
            color = accentList.value[pagerState.currentPage % accentList.value.size]
        )
    }
}

@Composable
fun PaginatedCalendar(
    calendar: List<SelectableCalendar>,
    onAddMore: () -> Unit
) {

    val lazyColumnListState = rememberLazyListState()

    val shouldStartPaginate = remember {
        derivedStateOf {
            (lazyColumnListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
                ?: -9) >= (lazyColumnListState.layoutInfo.totalItemsCount - 6)
        }
    }

    LaunchedEffect(key1 = shouldStartPaginate.value) {
        if (shouldStartPaginate.value)
            onAddMore.invoke()
    }

    LazyRow(
        state = lazyColumnListState,
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
        contentPadding = PaddingValues(Design.dp.paddingM)
    ) {

        items(calendar) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .conditional(
                        condition = it.isSelected,
                        onYes = { accentBackground() },
                        onNot = { secondaryBackground() }
                    )
            ) {

                TextFieldBody1(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 16.dp),
                    provideText = { it.weekDay },
                    color = Design.colors.caption
                )

                TextFieldH2(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 16.dp),
                    provideText = { it.day },
                    color = Design.colors.content
                )
            }
        }
    }
}
