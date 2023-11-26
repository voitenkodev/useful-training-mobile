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

@Parcelize
internal sealed class MainRouter : Parcelable {
    data class Training(val id: String? = null) : MainRouter()
    data object Profile : MainRouter()
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
                    router.push(MainRouter.Profile)
                }
            )

            is MainRouter.Training -> TrainingGraph(
                id = child.id,
                closeFlow = router::pop,
                toTrainingDetails = {},
            )

            is MainRouter.Profile -> ProfileGraph()
        }
    }
}