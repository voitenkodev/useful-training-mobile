package exerciseexamples

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import exerciseexamples.edit.ExerciseExampleBuilderContent
import exerciseexamples.edit.ExerciseExampleBuilderViewModel
import exerciseexamples.list.ExerciseExamplesContent
import exerciseexamples.list.ExerciseExamplesViewModel
import io.github.xxfast.decompose.router.Router
import io.github.xxfast.decompose.router.content.RoutedContent
import io.github.xxfast.decompose.router.rememberOnRoute
import io.github.xxfast.decompose.router.rememberRouter

@Parcelize
public sealed class ExerciseExamplesFeature : Parcelable {
    public data object List : ExerciseExamplesFeature()
    public data class Edit(val id: String? = null) : ExerciseExamplesFeature()
}

@Composable
public fun ExerciseExamplesGraph(startDirection: ExerciseExamplesFeature) {

    val router: Router<ExerciseExamplesFeature> = rememberRouter(ExerciseExamplesFeature::class) {
        listOf(startDirection)
    }

    RoutedContent(router = router, animation = stackAnimation(slide(orientation = Orientation.Horizontal))) { child ->
        when (child) {
            is ExerciseExamplesFeature.Edit -> {
                val vm = rememberOnRoute(ExerciseExampleBuilderViewModel::class) {
                    ExerciseExampleBuilderViewModel(child.id)
                }

                ExerciseExampleBuilderContent(
                    vm = vm,
                    back = router::pop
                )
            }

            is ExerciseExamplesFeature.List -> {
                val vm = rememberOnRoute(ExerciseExamplesViewModel::class) {
                    ExerciseExamplesViewModel()
                }

                ExerciseExamplesContent(
                    vm = vm,
                    toExerciseExampleBuilder = { router.push(ExerciseExamplesFeature.Edit(it)) }
                )
            }
        }
    }
}
