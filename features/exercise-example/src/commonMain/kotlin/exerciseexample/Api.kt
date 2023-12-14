package exerciseexample

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import exerciseexample.main.ExerciseExampleContent
import exerciseexample.main.ExerciseExampleViewModel
import io.github.xxfast.decompose.router.Router
import io.github.xxfast.decompose.router.content.RoutedContent
import io.github.xxfast.decompose.router.rememberOnRoute
import io.github.xxfast.decompose.router.rememberRouter


@Parcelize
public sealed class ExerciseExampleFeature : Parcelable {
    public data object Main : ExerciseExampleFeature()
}

@Composable
public fun ExerciseExampleGraph(id: String, close: () -> Unit) {

    val router: Router<ExerciseExampleFeature> = rememberRouter(ExerciseExampleFeature::class) {
        listOf(ExerciseExampleFeature.Main)
    }

    RoutedContent(router = router, animation = stackAnimation(fade())) { child ->
        when (child) {
            is ExerciseExampleFeature.Main -> {
                val vm = rememberOnRoute(ExerciseExampleViewModel::class) {
                    ExerciseExampleViewModel(id)
                }
                ExerciseExampleContent(vm = vm, close = close)
            }
        }
    }
}