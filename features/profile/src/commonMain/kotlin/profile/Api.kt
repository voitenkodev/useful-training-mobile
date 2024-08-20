package profile

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import io.github.xxfast.decompose.router.rememberOnRoute
import io.github.xxfast.decompose.router.stack.RoutedContent
import io.github.xxfast.decompose.router.stack.Router
import io.github.xxfast.decompose.router.stack.rememberRouter
import kotlinx.serialization.Serializable
import profile.main.ProfileContent
import profile.main.ProfileViewModel

@Serializable
public sealed class ProfileFeature {
    @Serializable
    public data object Main : ProfileFeature()
}

@Composable
public fun ProfileGraph(
    startDirection: ProfileFeature,
    toExerciseExamples: () -> Unit,
    toMuscles: () -> Unit,
    toEquipment: () -> Unit,
    toWeightHistory: () -> Unit,
    toTraining: (id: String?) -> Unit,
    toExerciseExampleById: (id: String) -> Unit,
    toExerciseExampleBuilder: () -> Unit
) {

    val router: Router<ProfileFeature> = rememberRouter(ProfileFeature::class) {
        listOf(startDirection)
    }

    RoutedContent(
        router = router,
        animation = stackAnimation(slide(orientation = Orientation.Horizontal))
    ) { child ->
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
                    toEquipment = toEquipment,
                    toTraining = toTraining,
                    toExerciseExampleById = toExerciseExampleById,
                    toExerciseExampleBuilder = toExerciseExampleBuilder
                )
            }
        }
    }
}
