package trainingbuilder

import androidx.compose.runtime.Composable
import rememberViewModel
import trainingbuilder.screen.TrainingContent
import trainingbuilder.screen.TrainingViewModel

@Composable
public fun TrainingFeature(
    trainingId: String?,
    toReview: (trainingId: String) -> Unit,
    back: () -> Unit
) {
    val vm = rememberViewModel(TrainingViewModel::class) { TrainingViewModel() }

    TrainingContent(
        vm = vm,
        trainingId = trainingId,
        toReview = toReview,
        back = back
    )
}
