package graph

import androidx.compose.runtime.Composable
import authentication.AuthenticationFeature
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import io.github.xxfast.decompose.router.Router
import io.github.xxfast.decompose.router.content.RoutedContent
import io.github.xxfast.decompose.router.rememberRouter
import splash.SplashFeature

@Parcelize
internal sealed class AuthRouter : Parcelable {
    data object Splash : AuthRouter()
    data object Authentication : AuthRouter()
}

@Composable
internal fun AuthGraph(
    toTrainings: () -> Unit
) {

    val router: Router<AuthRouter> = rememberRouter(AuthRouter::class) {
        listOf(AuthRouter.Splash)
    }

    RoutedContent(
        router = router,
    ) { child ->
        when (child) {
            AuthRouter.Splash -> SplashFeature(
                toAuthentication = { router.replaceAll(AuthRouter.Authentication) },
                toTrainings = toTrainings
            )

            AuthRouter.Authentication -> AuthenticationFeature(
                toTrainings = toTrainings,
                back = router::pop
            )
        }
    }
}