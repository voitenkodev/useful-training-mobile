package graph

import RoutedContent
import Router
import androidx.compose.runtime.Composable
import authentication.AuthenticationFeature
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import rememberRouter
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

    val router: Router<AuthRouter> = rememberRouter(AuthRouter::class, listOf(AuthRouter.Splash))

    RoutedContent(
        router = router,
        animation = stackAnimation()
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