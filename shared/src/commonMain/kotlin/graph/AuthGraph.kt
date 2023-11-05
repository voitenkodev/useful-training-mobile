package graph

import androidx.compose.runtime.Composable
import authentication.AuthenticationFeature
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import io.github.xxfast.decompose.router.Router
import io.github.xxfast.decompose.router.content.RoutedContent
import io.github.xxfast.decompose.router.rememberRouter
import registration.RegistrationFeature
import splash.SplashFeature

@Parcelize
internal sealed class AuthRouter : Parcelable {
    data object Splash : AuthRouter()
    data object Authentication : AuthRouter()
    data object Registration : AuthRouter()
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
        animation  = stackAnimation(slide())
    ) { child ->
        when (child) {
            AuthRouter.Splash -> SplashFeature(
                toAuthentication = { router.replaceAll(AuthRouter.Authentication) },
                toTrainings = toTrainings
            )

            AuthRouter.Authentication -> AuthenticationFeature(
                toTrainings = toTrainings,
                toRegistration = { router.push(AuthRouter.Registration) },
                back = router::pop
            )

            AuthRouter.Registration -> RegistrationFeature(
                toTrainings = toTrainings,
                back = router::pop
            )
        }
    }
}