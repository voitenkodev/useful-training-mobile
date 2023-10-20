package authentication

import androidx.compose.runtime.Composable
import authentication.screen.AuthenticationContent
import authentication.screen.AuthenticationViewModel
import io.github.xxfast.decompose.router.rememberOnRoute

@Composable
public fun AuthenticationFeature(
    toTrainings: () -> Unit,
    back: () -> Unit
) {
    val instance: AuthenticationViewModel = rememberOnRoute(AuthenticationViewModel::class) { AuthenticationViewModel() }

    AuthenticationContent(
        vm = instance,
        toTrainings = toTrainings,
        back = back
    )
}
