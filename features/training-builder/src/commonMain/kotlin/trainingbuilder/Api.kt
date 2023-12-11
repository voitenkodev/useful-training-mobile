package trainingbuilder

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import io.github.xxfast.decompose.router.Router
import io.github.xxfast.decompose.router.content.RoutedContent
import io.github.xxfast.decompose.router.rememberOnRoute
import io.github.xxfast.decompose.router.rememberRouter
import kotlinx.coroutines.flow.Flow
import trainingbuilder.muscle_picker.MusclePickerContent
import trainingbuilder.muscle_picker.MusclePickerViewModel
import trainingbuilder.training_builder.TrainingBuilderContent
import trainingbuilder.training_builder.TrainingBuilderViewModel

@Parcelize
public sealed class TrainingRouter : Parcelable {
    public data class TrainingBuilder(val trainingId: String?, val muscleIds: List<String>) : TrainingRouter()
    public data object MusclePicker : TrainingRouter()
}

@Composable
public fun TrainingGraph(
    close: () -> Unit,
    toSearchExerciseExample: () -> Unit,
    searchExerciseExampleId: Flow<String>,
    toExerciseExampleDetails: (id: String) -> Unit
) {

    val router: Router<TrainingRouter> = rememberRouter(TrainingRouter::class) {
        listOf(TrainingRouter.MusclePicker)
    }

    RoutedContent(router = router, animation = stackAnimation(slide(orientation = Orientation.Horizontal))) { child ->
        when (child) {

            is TrainingRouter.TrainingBuilder -> {
                val vm = rememberOnRoute(TrainingBuilderViewModel::class) {
                    TrainingBuilderViewModel(child.muscleIds)
                }

                TrainingBuilderContent(
                    vm = vm,
                    close = { close.invoke() },
                    toSearchExerciseExample = toSearchExerciseExample,
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
                    apply = { router.push(TrainingRouter.TrainingBuilder(trainingId = null, muscleIds = it)) }
                )
            }
        }
    }
}