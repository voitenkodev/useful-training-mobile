package trainingbuilder

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.push
import io.github.xxfast.decompose.router.rememberOnRoute
import io.github.xxfast.decompose.router.stack.RoutedContent
import io.github.xxfast.decompose.router.stack.Router
import io.github.xxfast.decompose.router.stack.rememberRouter
import kotlinx.serialization.Serializable
import trainingbuilder.muscle_picker.MusclePickerContent
import trainingbuilder.muscle_picker.MusclePickerViewModel
import trainingbuilder.training_builder.TrainingBuilderContent
import trainingbuilder.training_builder.TrainingBuilderViewModel

@Serializable
public sealed class TrainingRouter {
    @Serializable
    public data class TrainingBuilder(val trainingId: String?, val muscleIds: List<String>) :
        TrainingRouter()

    @Serializable
    public data object MusclePicker : TrainingRouter()
}

@Composable
public fun TrainingGraph(
    close: () -> Unit,
    toExerciseExamples: () -> Unit,
    searchExerciseExampleId: String?,
    toExerciseExampleDetails: (id: String, isSelectable: Boolean) -> Unit
) {

    val router: Router<TrainingRouter> = rememberRouter(TrainingRouter::class) {
        listOf(TrainingRouter.MusclePicker)
    }


    RoutedContent(
        router = router,
        animation = stackAnimation(slide(orientation = Orientation.Horizontal))
    ) { child ->
        when (child) {

            is TrainingRouter.TrainingBuilder -> {
                val vm = rememberOnRoute(TrainingBuilderViewModel::class) {
                    TrainingBuilderViewModel(child.muscleIds)
                }

                TrainingBuilderContent(
                    vm = vm,
                    close = { close.invoke() },
                    toSearchExerciseExample = toExerciseExamples,
                    searchExerciseExampleId = searchExerciseExampleId,
                    toExerciseExampleDetails = toExerciseExampleDetails
                )
            }

            TrainingRouter.MusclePicker -> {
                val vm = rememberOnRoute(MusclePickerViewModel::class) {
                    MusclePickerViewModel()
                }

                MusclePickerContent(
                    vm = vm,
                    close = close,
                    apply = {
                        router.push(
                            TrainingRouter.TrainingBuilder(
                                trainingId = null,
                                muscleIds = it
                            )
                        )
                    }
                )
            }
        }
    }
}