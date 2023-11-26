package graph

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import exerciseexamplebuilder.ExerciseExampleBuilderFeature
import exerciseexamples.ExerciseExamplesFeature
import io.github.xxfast.decompose.router.Router
import io.github.xxfast.decompose.router.content.RoutedContent
import io.github.xxfast.decompose.router.rememberRouter

@Parcelize
internal sealed class ProfileRouter : Parcelable {
    data object ExerciseExamples : ProfileRouter()
    data class ExerciseExampleBuilder(val id: String? = null) : ProfileRouter()
}

@Composable
internal fun ProfileGraph() {

    val router: Router<ProfileRouter> = rememberRouter(ProfileRouter::class) {
        listOf(ProfileRouter.ExerciseExamples)
    }

    RoutedContent(router = router, animation = stackAnimation(slide(orientation = Orientation.Horizontal))) { child ->
        when (child) {
            is ProfileRouter.ExerciseExampleBuilder -> ExerciseExampleBuilderFeature(
                exerciseExampleId = child.id,
                back = router::pop
            )

            is ProfileRouter.ExerciseExamples -> ExerciseExamplesFeature(
                toExerciseExampleBuilder = {
                    router.push(ProfileRouter.ExerciseExampleBuilder(it))
                }
            )
        }
    }
}