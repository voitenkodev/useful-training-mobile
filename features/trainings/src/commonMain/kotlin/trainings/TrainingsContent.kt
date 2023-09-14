package trainings

import PlatformBackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import components.Error
import components.Loading
import components.backgrounds.BrandGradientCenterEnd
import components.backgrounds.BrandGradientCenterStart
import components.overlay.AlphaOverlay
import components.roots.Root
import training.Training
import trainings.components.BottomScreenControls
import trainings.components.TrainingPage

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
        trainings = { state.trainings },
        editTraining = toTrainingById,
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

        BrandGradientCenterEnd()

        BrandGradientCenterStart()

        AlphaOverlay(
            modifier = Modifier.fillMaxSize(),
            condition = { loading().not() },
            animationDuration = 800,
            delayDuration = 200
        )
    }
}