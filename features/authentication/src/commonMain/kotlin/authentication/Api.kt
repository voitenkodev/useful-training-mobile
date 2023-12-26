package authentication

import androidx.compose.runtime.Composable
import authentication.intro.IntroContent
import authentication.intro.IntroViewModel
import authentication.login.AuthenticationContent
import authentication.login.AuthenticationViewModel
import authentication.register.RegistrationContent
import authentication.register.RegistrationViewModel
import authentication.splash.SplashContent
import authentication.splash.SplashViewModel
import authentication.success.SuccessRegistrationContent
import authentication.success.SuccessRegistrationViewModel
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import io.github.xxfast.decompose.router.Router
import io.github.xxfast.decompose.router.content.RoutedContent
import io.github.xxfast.decompose.router.rememberOnRoute
import io.github.xxfast.decompose.router.rememberRouter

@Parcelize
public sealed class AuthenticationRouter : Parcelable {
    public data object Splash : AuthenticationRouter()
    public data object Intro : AuthenticationRouter()
    public data object Login : AuthenticationRouter()
    public data object Registration : AuthenticationRouter()
    public data object SuccessRegistration : AuthenticationRouter()
}

@Composable
public fun AuthenticationGraph(toTrainings: () -> Unit) {

    val router: Router<AuthenticationRouter> = rememberRouter(AuthenticationRouter::class) {
        listOf(AuthenticationRouter.Splash)
    }

    RoutedContent(router = router, animation = stackAnimation(slide())) { child ->
        when (child) {
            AuthenticationRouter.Splash -> {
                val vm = rememberOnRoute(SplashViewModel::class) {
                    SplashViewModel()
                }

                SplashContent(
                    vm = vm,
                    toTrainings = toTrainings,
                    toAuthentication = { router.replaceAll(AuthenticationRouter.Intro) }
                )
            }

            AuthenticationRouter.Intro -> {
                val vm = rememberOnRoute(IntroViewModel::class) {
                    IntroViewModel()
                }

                IntroContent(
                    vm = vm,
                    toLogin = { router.push(AuthenticationRouter.Login) },
                    toRegistration = { router.push(AuthenticationRouter.Registration) }
                )
            }

            AuthenticationRouter.Login -> {
                val vm = rememberOnRoute(AuthenticationViewModel::class) {
                    AuthenticationViewModel()
                }

                AuthenticationContent(
                    vm = vm,
                    toTrainings = toTrainings,
                    toRegistration = { router.push(AuthenticationRouter.Registration) }
                )
            }

            AuthenticationRouter.Registration -> {
                val vm = rememberOnRoute(RegistrationViewModel::class) {
                    RegistrationViewModel()
                }

                RegistrationContent(
                    vm = vm,
                    toSuccessRegistration = { router.push(AuthenticationRouter.SuccessRegistration) },
                    back = router::pop
                )
            }

            AuthenticationRouter.SuccessRegistration -> {
                val vm = rememberOnRoute(SuccessRegistrationViewModel::class) {
                    SuccessRegistrationViewModel()
                }

                SuccessRegistrationContent(
                    vm = vm,
                    toTrainings = toTrainings
                )
            }
        }
    }
}