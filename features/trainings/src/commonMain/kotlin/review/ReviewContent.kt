package review

import Design
import PlatformBackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import components.roots.Root
import platformTopInset
import recomposeHighlighter
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
        vm.getTrainings()
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
                .padding(horizontal = Design.dp.paddingM),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingL)
        ) {

            Spacer(
                modifier = Modifier.size(Design.dp.paddingM)
            )

            TrainingTitle(
                titleColor = Design.colors.primary, // PAGE COLOR
                weekDay = { trainingProvider.weekDay },
                date = { trainingProvider.startLongDate },
            )


            ChartsInfo(
                training = trainingProvider
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .recomposeHighlighter()
                        .padding(bottom = Design.dp.paddingM),
                ) {

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
            }
        }
    }
}
