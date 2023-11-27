package graph

import androidx.compose.runtime.Composable
import authentication.AuthenticationGraph
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import io.github.xxfast.decompose.router.Router
import io.github.xxfast.decompose.router.content.RoutedContent
import io.github.xxfast.decompose.router.rememberRouter

@Parcelize
internal sealed class RootRouter : Parcelable {
    data object Auth : RootRouter()
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
                toAuthentication = {
                    router.replaceAll(RootRouter.Auth)
                }
            )
        }
    }
}