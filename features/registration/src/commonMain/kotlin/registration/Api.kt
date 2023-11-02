package registration

import androidx.compose.runtime.Composable
import io.github.xxfast.decompose.router.rememberOnRoute
import registration.screen.RegistrationContent
import registration.screen.RegistrationViewModel

@Composable
public fun RegistrationFeature(
    toTrainings: () -> Unit,
    back: () -> Unit
) {
    val vm = rememberOnRoute(RegistrationViewModel::class) {
        RegistrationViewModel()
    }

    RegistrationContent(
        vm = vm,
        toTrainings = toTrainings,
        back = back
    )
}
