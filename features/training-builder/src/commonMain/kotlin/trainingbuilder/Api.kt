package trainingbuilder

import androidx.compose.runtime.Composable
import io.github.xxfast.decompose.router.rememberOnRoute
import trainingbuilder.screen.TrainingContent
import trainingbuilder.screen.TrainingViewModel

@Composable
public fun TrainingFeature(
    trainingId: String?,
    toReview: (trainingId: String) -> Unit,
    back: () -> Unit
) {
    val vm = rememberOnRoute(TrainingViewModel::class) {
        TrainingViewModel()
    }

    TrainingContent(
        vm = vm,
        trainingId = trainingId,
        toReview = toReview,
        back = back
    )
}
