package registration

import androidx.compose.runtime.Composable
import io.github.xxfast.decompose.router.rememberOnRoute
import registration.screen.registration.RegistrationContent
import registration.screen.registration.RegistrationViewModel
import registration.screen.success.SuccessRegistrationContent

@Composable
public fun RegistrationFeature(
    toSuccessRegistration: () -> Unit,
    back: () -> Unit
) {
    val vm = rememberOnRoute(RegistrationViewModel::class) {
        RegistrationViewModel()
    }

    RegistrationContent(
        vm = vm,
        toSuccessRegistration = toSuccessRegistration,
        back = back
    )
}

@Composable
public fun SuccessRegistrationFeature(
    toTrainings: () -> Unit
) {

    SuccessRegistrationContent(
        toTrainings = toTrainings
    )
}