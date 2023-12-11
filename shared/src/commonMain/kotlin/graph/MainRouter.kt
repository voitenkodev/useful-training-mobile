package graph

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import exerciseexample.ExerciseExampleGraph
import exerciseexamples.ExerciseExamplesGraph
import io.github.xxfast.decompose.router.Router
import io.github.xxfast.decompose.router.content.RoutedContent
import io.github.xxfast.decompose.router.rememberRouter
import searchexercise.SearchExerciseComponent
import searchexercise.SearchExerciseController
import searchexercise.SearchExerciseGraph
import trainingbuilder.TrainingGraph

@Parcelize
internal sealed class MainRouter : Parcelable {
    data class Training(val id: String? = null) : MainRouter()
    data object ExerciseExamples : MainRouter()
    data class ExerciseExample(val id: String) : MainRouter()
    data object SearchExercise : MainRouter()
    data object BottomMenu : MainRouter()
}

@Composable
internal fun MainGraph(toAuthentication: () -> Unit) {

    val router: Router<MainRouter> = rememberRouter(MainRouter::class) {
        listOf(MainRouter.BottomMenu)
    }

    SearchExerciseComponent {

        RoutedContent(router = router, animation = stackAnimation(slide(orientation = Orientation.Vertical))) { child ->
            when (child) {
                is MainRouter.BottomMenu -> BottomMenuGraph(
                    toTrainingBuilder = { trainingId: String? -> router.push(MainRouter.Training(trainingId)) },
                    toTrainingDetails = {},
                    toAuthentication = toAuthentication,
                    toExerciseExamples = { router.push(MainRouter.ExerciseExamples) }
                )

                is MainRouter.Training -> {
                    val api = SearchExerciseController.api

                    TrainingGraph(
                        close = router::pop,
                        searchExerciseExampleId = api.exerciseExampleId,
                        toSearchExerciseExample = { router.push(MainRouter.SearchExercise) },
                        toExerciseExampleDetails = { router.push(MainRouter.ExerciseExample("todo")) }
                    )
                }

                is MainRouter.ExerciseExamples -> ExerciseExamplesGraph(
                    toExerciseExampleDetails = { router.push(MainRouter.ExerciseExample("todo")) }
                )

                is MainRouter.SearchExercise -> SearchExerciseGraph(
                    close = router::pop,
                    toExerciseExampleDetails = { router.push(MainRouter.ExerciseExample("todo")) }
                )

                is MainRouter.ExerciseExample -> ExerciseExampleGraph(
                    id = child.id,
                    close = router::pop
                )

            }
        }
    }
}