package graph

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import io.github.xxfast.decompose.router.Router
import io.github.xxfast.decompose.router.content.RoutedContent
import io.github.xxfast.decompose.router.rememberRouter
import musclepicker.MusclePickerFeature
import trainingbuilder.TrainingFeature

@Parcelize
internal sealed class TrainingRouter : Parcelable {
    data object MusclePicker : TrainingRouter()
    data class TrainingBuilder(
        val trainingId: String? = null,
        val muscleIds: List<String>
    ) : TrainingRouter()
}

@Composable
internal fun TrainingGraph(
    id: String? = null,
    toTrainingDetails: (id: String) -> Unit,
    closeFlow: () -> Unit
) {

    val router: Router<TrainingRouter> = rememberRouter(TrainingRouter::class) {
        listOf(TrainingRouter.MusclePicker)
    }

    RoutedContent(router = router, animation = stackAnimation(slide(orientation = Orientation.Vertical))) { child ->
        when (child) {
            TrainingRouter.MusclePicker -> MusclePickerFeature(
                apply = { router.push(TrainingRouter.TrainingBuilder(trainingId = null, muscleIds = it)) }
            )

            is TrainingRouter.TrainingBuilder -> TrainingFeature(
                trainingId = child.trainingId,
                muscleIds = child.muscleIds,
                toTrainingDetails = { id -> toTrainingDetails.invoke(id) },
                back = router::pop
            )
        }
    }
}