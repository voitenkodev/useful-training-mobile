package graph

import androidx.compose.runtime.Composable
import authentication.AuthenticationGraph
import com.arkivanov.decompose.router.stack.replaceAll
import io.github.xxfast.decompose.router.stack.RoutedContent
import io.github.xxfast.decompose.router.stack.Router
import io.github.xxfast.decompose.router.stack.rememberRouter
import kotlinx.serialization.Serializable

@Serializable
internal sealed class RootRouter {
    @Serializable
    data object Auth : RootRouter()

    @Serializable
    data object Main : RootRouter()
}

@Composable
internal fun RootGraph() {

    val router: Router<RootRouter> = rememberRouter(RootRouter::class) {
        listOf(RootRouter.Auth)
    }

    RoutedContent(router = router) { child ->
        when (child) {
            RootRouter.Auth -> AuthenticationGraph(
                toTrainings = { router.replaceAll(RootRouter.Main) }
            )

            RootRouter.Main -> MainGraph(
                toAuthentication = { router.replaceAll(RootRouter.Auth) }
            )
        }
    }
}