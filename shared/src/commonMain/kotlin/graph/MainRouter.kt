package graph

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import exerciseexamples.ExerciseExamplesFeature
import exerciseexamples.ExerciseExamplesGraph
import io.github.xxfast.decompose.router.Router
import io.github.xxfast.decompose.router.content.RoutedContent
import io.github.xxfast.decompose.router.rememberRouter
import trainingbuilder.TrainingGraph
import trainingbuilder.TrainingRouter

@Parcelize
internal sealed class MainRouter : Parcelable {
    data class Training(val id: String? = null) : MainRouter()
    data class ExerciseExamples(val startDirection: ExerciseExamplesFeature) : MainRouter()
    data object BottomMenu : MainRouter()
}

@Composable
internal fun MainGraph(toAuthentication: () -> Unit) {

    val router: Router<MainRouter> = rememberRouter(MainRouter::class) {
        listOf(MainRouter.BottomMenu)
    }

    RoutedContent(router = router, animation = stackAnimation(slide(orientation = Orientation.Vertical))) { child ->
        when (child) {
            is MainRouter.BottomMenu -> BottomMenuGraph(
                toTrainingBuilder = { trainingId: String? ->
                    router.push(MainRouter.Training(trainingId))
                },
                toTrainingDetails = {
                },
                toAuthentication = toAuthentication,
                toExerciseExamples = {
                    router.push(MainRouter.ExerciseExamples(ExerciseExamplesFeature.List))
                }
            )

            is MainRouter.Training -> TrainingGraph(
                startDirection = TrainingRouter.MusclePicker,
                toTrainingDetails = {},
                close = router::pop
            )

            is MainRouter.ExerciseExamples -> ExerciseExamplesGraph(
                startDirection = child.startDirection
            )
        }
    }
}