package profile

import androidx.compose.runtime.Composable
import io.github.xxfast.decompose.router.rememberOnRoute
import profile.screen.ProfileContent
import profile.screen.ProfileViewModel

@Composable
public fun ProfileFeature(
    toExerciseExampleBuilder: (id: String?) -> Unit
) {

    val vm = rememberOnRoute(ProfileViewModel::class) {
        ProfileViewModel()
    }

    ProfileContent(
        vm = vm,
        toExerciseExampleBuilder = toExerciseExampleBuilder
    )
}