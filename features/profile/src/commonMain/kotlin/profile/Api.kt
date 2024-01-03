package profile

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
import profile.main.ProfileContent
import profile.main.ProfileViewModel

@Parcelize
public sealed class ProfileFeature : Parcelable {
    public data object Main : ProfileFeature()
}

@Composable
public fun ProfileGraph(
    startDirection: ProfileFeature,
    toExerciseExamples: () -> Unit,
    toMuscles: () -> Unit,
    toEquipment: () -> Unit,
    toWeightHistory: () -> Unit
) {

    val router: Router<ProfileFeature> = rememberRouter(ProfileFeature::class) {
        listOf(startDirection)
    }

    RoutedContent(router = router, animation = stackAnimation(slide(orientation = Orientation.Horizontal))) { child ->
        when (child) {
            is ProfileFeature.Main -> {
                val vm = rememberOnRoute(ProfileViewModel::class) {
                    ProfileViewModel()
                }

                ProfileContent(
                    vm = vm,
                    toExerciseExamples = toExerciseExamples,
                    toWeightHistory = toWeightHistory,
                    toMuscles = toMuscles,
                    toEquipment = toEquipment
                )
            }
        }
    }
}
