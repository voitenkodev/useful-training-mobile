package trainings

import Design
import PlatformBackHandler
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import atomic.rememberAccentColorsAsState
import components.BottomScreenControls
import components.Error
import components.Loading
import components.backgrounds.BrandGradientCenterEnd
import components.backgrounds.BrandGradientCenterStart
import components.overlay.AlphaOverlay
import components.roots.Root
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
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
        trainings = { state.trainings },
        openTraining = toTrainingById,
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
    trainings: () -> List<Training>,
    openTraining: (trainingId: String) -> Unit,
) {

    val addTrainingProvider by rememberUpdatedState(newTraining)
    val backProvider by rememberUpdatedState(back)

    val pagerState = rememberPagerState { trainings().size }
    val accentList = rememberAccentColorsAsState()
    val scope = rememberCoroutineScope()
    val animDelay = Design.duration.animM

    val showFrame = remember { mutableStateOf(true) }

    val offset = animateDpAsState(
        targetValue = if (showFrame.value) 0.dp else 250.dp,
        tween(durationMillis = Design.duration.animM)
    )

    Root(
        loading = { Loading(loading) },
        error = { Error(message = error, close = clearError) },
        back = { PlatformBackHandler(backProvider) },
    ) {

        VerticalPager(state = pagerState) {
            val training by rememberUpdatedState(trainings()[it])

            TrainingPage(
                training = training,
                openTraining = {
                    val id = training.id ?: return@TrainingPage
                    scope.launch {
                        showFrame.value = false
                        delay(animDelay.toLong())
                        openTraining.invoke(id)
                    }
                },
                pageColor = Design.colors.content
            )
        }

        BottomScreenControls(
            modifier = Modifier,
            pagerState = pagerState,
            visibilityCondition = { showFrame.value },
            addTraining = addTrainingProvider,
            logout = logout
        )

        BrandGradientCenterEnd(
            modifier = Modifier.offset(x = offset.value),
            color = accentList.value[pagerState.currentPage % accentList.value.size]
        )

        BrandGradientCenterStart(
            modifier = Modifier.offset(x = -(offset.value)),
            color = accentList.value[pagerState.currentPage % accentList.value.size]
        )

        AlphaOverlay(
            modifier = Modifier.fillMaxSize(),
            visibilityCondition = { loading().not() },
            animationDuration = Design.duration.animL,
            delayDuration = 300
        )
    }
}