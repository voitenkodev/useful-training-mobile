package userequipments

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
import userequipments.main.UserEquipmentsContent
import userequipments.main.UserEquipmentsViewModel

@Parcelize
public sealed class UserEquipmentsFeature : Parcelable {
    public data object Main : UserEquipmentsFeature()
}

@Composable
public fun UserEquipmentsGraph(close: () -> Unit) {

    val router: Router<UserEquipmentsFeature> = rememberRouter(UserEquipmentsFeature::class) {
        listOf(UserEquipmentsFeature.Main)
    }

    RoutedContent(router = router, animation = stackAnimation(slide(orientation = Orientation.Horizontal))) { child ->
        when (child) {
            is UserEquipmentsFeature.Main -> {
                val vm = rememberOnRoute(UserEquipmentsViewModel::class) {
                    UserEquipmentsViewModel()
                }

                UserEquipmentsContent(
                    vm = vm,
                    close = close
                )
            }
        }
    }
}
