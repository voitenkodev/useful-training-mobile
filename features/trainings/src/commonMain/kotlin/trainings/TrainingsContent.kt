package trainings

import Design
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
import components.BottomScreenControls
import components.Error
import components.Loading
import components.backgrounds.BrandGradientCenterEnd
import components.backgrounds.BrandGradientCenterStart
import components.overlay.AlphaOverlay
import components.roots.Root
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

    val accentList = rememberUpdatedState(
        listOf(
            Design.colors.accent_primary,
            Design.colors.accent_secondary,
            Design.colors.accent_tertiary,
            Design.colors.accent_quaternary,
            Design.colors.accent_quinary,
        )
    )

    Root(
        loading = { Loading(loading) },
        error = { Error(message = error, close = clearError) },
        back = { PlatformBackHandler(backProvider) },
    ) {

        val pagerState = rememberPagerState { trainings().size }

        VerticalPager(state = pagerState) {
            val training by rememberUpdatedState(trainings()[it])
            TrainingPage(
                training = training,
                openTraining = {
                    val id = training.id ?: return@TrainingPage
                    openTraining.invoke(id)
                },
                pageColor = accentList.value[it % accentList.value.size]
            )
        }

        BottomScreenControls(
            pagerState = pagerState,
            addTraining = addTrainingProvider,
            logout = logout
        )

        BrandGradientCenterEnd(
            color = accentList.value[pagerState.currentPage % accentList.value.size]
        )

        BrandGradientCenterStart(
            color = accentList.value[pagerState.currentPage % accentList.value.size]
        )

        AlphaOverlay(
            modifier = Modifier.fillMaxSize(),
            condition = { loading().not() },
            animationDuration = 900,
            delayDuration = 300
        )
    }
}