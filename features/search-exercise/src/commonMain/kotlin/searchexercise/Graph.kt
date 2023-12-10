package searchexercise

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import io.github.xxfast.decompose.router.Router
import io.github.xxfast.decompose.router.content.RoutedContent
import io.github.xxfast.decompose.router.rememberOnRoute
import io.github.xxfast.decompose.router.rememberRouter
import searchexercise.main.SearchExerciseContent
import searchexercise.main.SearchExerciseViewModel

@Parcelize
public sealed class ProfileFeature : Parcelable {
    public data object Main : ProfileFeature()
}

@Composable
public fun ProfileFeatureGraph(
    startDirection: ProfileFeature,
    toExerciseExamples: () -> Unit
) {

    val router: Router<ProfileFeature> = rememberRouter(ProfileFeature::class) {
        listOf(startDirection)
    }

    RoutedContent(router = router, animation = stackAnimation(slide(orientation = Orientation.Horizontal))) { child ->
        when (child) {
            is ProfileFeature.Main -> {
                val vm = rememberOnRoute(SearchExerciseViewModel::class) {
                    SearchExerciseViewModel()
                }

                SearchExerciseContent(
                    vm = vm
                )
            }
        }
    }
}
