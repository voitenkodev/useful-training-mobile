package authentication

import androidx.compose.runtime.Composable
import authentication.screen.AuthenticationContent
import authentication.screen.AuthenticationViewModel
import rememberViewModel

@Composable
public fun AuthenticationFeature(
    toTrainings: () -> Unit,
    back: () -> Unit
) {
    val vm = rememberViewModel(AuthenticationViewModel::class) { AuthenticationViewModel() }

    AuthenticationContent(
        vm = vm,
        toTrainings = toTrainings,
        back = back
    )
}
