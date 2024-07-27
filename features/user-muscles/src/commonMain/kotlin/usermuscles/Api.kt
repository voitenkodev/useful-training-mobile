package usermuscles

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import io.github.xxfast.decompose.router.rememberOnRoute
import io.github.xxfast.decompose.router.stack.RoutedContent
import io.github.xxfast.decompose.router.stack.Router
import io.github.xxfast.decompose.router.stack.rememberRouter
import kotlinx.serialization.Serializable
import usermuscles.main.UserMusclesContent
import usermuscles.main.UserMusclesViewModel

@Serializable
public sealed class UserMusclesFeature {
    @Serializable
    public data object Main : UserMusclesFeature()
}

@Composable
public fun UserMusclesGraph(close: () -> Unit) {

    val router: Router<UserMusclesFeature> = rememberRouter(UserMusclesFeature::class) {
        listOf(UserMusclesFeature.Main)
    }

    RoutedContent(
        router = router,
        animation = stackAnimation(slide(orientation = Orientation.Horizontal))
    ) { child ->
        when (child) {
            is UserMusclesFeature.Main -> {
                val vm = rememberOnRoute(UserMusclesViewModel::class) {
                    UserMusclesViewModel()
                }

                UserMusclesContent(
                    vm = vm,
                    close = close
                )
            }
        }
    }
}
