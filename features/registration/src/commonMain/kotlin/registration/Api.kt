package registration

import androidx.compose.runtime.Composable
import io.github.xxfast.decompose.router.rememberOnRoute
import registration.screen.registration.RegistrationContent
import registration.screen.registration.RegistrationViewModel
import registration.screen.success.SuccessRegistrationContent
import registration.screen.success.SuccessRegistrationViewModel

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
    val vm = rememberOnRoute(SuccessRegistrationViewModel::class) {
        SuccessRegistrationViewModel()
    }

    SuccessRegistrationContent(
        vm = vm,
        toTrainings = toTrainings
    )
}