package usermuscles

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
import usermuscles.main.UserMusclesContent
import usermuscles.main.UserMusclesViewModel

@Parcelize
public sealed class UserMusclesFeature : Parcelable {
    public data object Main : UserMusclesFeature()
}

@Composable
public fun UserMusclesGraph(close: () -> Unit) {

    val router: Router<UserMusclesFeature> = rememberRouter(UserMusclesFeature::class) {
        listOf(UserMusclesFeature.Main)
    }

    RoutedContent(router = router, animation = stackAnimation(slide(orientation = Orientation.Horizontal))) { child ->
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
