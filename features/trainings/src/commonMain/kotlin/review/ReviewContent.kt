package review

import Design
import PlatformBackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import components.ChartsInfo
import components.Error
import components.Exercises
import components.Loading
import components.SummaryInfo
import components.TrainingTitle
import components.backgrounds.BottomShadowBackground
import components.roots.Root
import platformTopInset
import training.Training

@Composable
fun ReviewContent(
    vm: ReviewViewModel,
    trainingId: String,
    back: () -> Unit,
    toEditTrainingById: (trainingId: String) -> Unit
) {

    val state by vm.state.collectAsState()

    LaunchedEffect(Unit) {
        vm.getTraining(trainingId)
    }

    Content(
        loading = { state.loading },
        error = { state.error },
        clearError = vm::clearError,
        back = back,
        training = { state.reviewTraining },
        editTraining = toEditTrainingById,
        removeTraining = {}
    )
}

@Composable
private fun Content(
    // BASE
    loading: () -> Boolean,
    error: () -> String?,
    clearError: () -> Unit,
    back: () -> Unit,

    // CONTENT
    training: () -> Training,
    editTraining: (trainingId: String) -> Unit,
    removeTraining: (trainingId: String) -> Unit,
) {

    val backProvider by rememberUpdatedState(back)
    val trainingProvider by rememberUpdatedState(training())

    Root(
        loading = { Loading(loading) },
        error = { Error(message = error, close = clearError) },
        back = { PlatformBackHandler(backProvider) },
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .platformTopInset()
                .padding(horizontal = Design.dp.paddingM)
                .verticalScroll(rememberScrollState()),
        ) {

            Spacer(
                modifier = Modifier.size(Design.dp.paddingL)
            )

            TrainingTitle(
                titleColor = Design.colors.content,
                weekDay = { trainingProvider.weekDay },
                date = { trainingProvider.startLongDate },
            )

            Spacer(
                modifier = Modifier.size(Design.dp.paddingL)
            )

            ChartsInfo(
                training = trainingProvider
            )

            Spacer(
                modifier = Modifier.size(Design.dp.paddingL)
            )


            Exercises(
                training = trainingProvider,
            )

            Spacer(
                modifier = Modifier.size(Design.dp.paddingL)
            )

            SummaryInfo(
                training = trainingProvider
            )
        }

        BottomShadowBackground()
    }
}
