package graph

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import io.github.xxfast.decompose.router.Router
import io.github.xxfast.decompose.router.content.RoutedContent
import io.github.xxfast.decompose.router.rememberRouter

@Parcelize
internal sealed class RootRouter : Parcelable {
    data object Auth : RootRouter()
    data object BottomMenu : RootRouter()
}

@Composable
internal fun RootGraph() {

    val router: Router<RootRouter> = rememberRouter(RootRouter::class) {
        listOf(RootRouter.Auth)
    }

    RoutedContent(
        router = router,
    ) { child ->
        when (child) {
            RootRouter.Auth -> AuthGraph(
                toTrainings = { router.replaceAll(RootRouter.BottomMenu) }
            )

            is RootRouter.BottomMenu -> BottomMenuGraph()
        }
    }
}