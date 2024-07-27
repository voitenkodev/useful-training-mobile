package userequipments

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import io.github.xxfast.decompose.router.rememberOnRoute
import io.github.xxfast.decompose.router.stack.RoutedContent
import io.github.xxfast.decompose.router.stack.Router
import io.github.xxfast.decompose.router.stack.rememberRouter
import kotlinx.serialization.Serializable
import userequipments.main.UserEquipmentsContent
import userequipments.main.UserEquipmentsViewModel

@Serializable
public sealed class UserEquipmentsFeature {
    @Serializable
    public data object Main : UserEquipmentsFeature()
}

@Composable
public fun UserEquipmentsGraph(close: () -> Unit) {

    val router: Router<UserEquipmentsFeature> = rememberRouter(UserEquipmentsFeature::class) {
        listOf(UserEquipmentsFeature.Main)
    }

    RoutedContent(
        router = router,
        animation = stackAnimation(slide(orientation = Orientation.Horizontal))
    ) { child ->
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
