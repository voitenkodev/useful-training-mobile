package authentication

import androidx.compose.runtime.Composable
import authentication.screen.AuthenticationContent
import authentication.screen.AuthenticationViewModel
import io.github.xxfast.decompose.router.rememberOnRoute

@Composable
public fun AuthenticationFeature(
    toTrainings: () -> Unit,
    toRegistration: () -> Unit,
    back: () -> Unit
) {
    val vm = rememberOnRoute(AuthenticationViewModel::class) {
        AuthenticationViewModel()
    }

    AuthenticationContent(
        vm = vm,
        toTrainings = toTrainings,
        toRegistration = toRegistration,
        back = back
    )
}
