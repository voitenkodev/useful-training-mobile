package trainings

import androidx.compose.runtime.Composable
import io.github.xxfast.decompose.router.rememberOnRoute
import trainings.screen.TrainingsContent
import trainings.screen.TrainingsViewModel

@Composable
public fun TrainingsFeature(
    toEditTraining: (trainingId: String) -> Unit,
    toNewTraining: () -> Unit,
    addTrainingWithTemplate: (trainingId: String) -> Unit,
    back: () -> Unit,
) {
    val vm = rememberOnRoute(TrainingsViewModel::class) {
        TrainingsViewModel()
    }

    TrainingsContent(
        vm = vm,
        toTrainingById = toEditTraining,
        toNewTraining = toNewTraining,
        addTrainingWithTemplate = addTrainingWithTemplate,
        back = back
    )
}
