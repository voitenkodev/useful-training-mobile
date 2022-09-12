package auth

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import designsystem.common.DesignComponent
import designsystem.components.InputEmail
import designsystem.components.InputPassword
import designsystem.controls.ButtonPrimary
import designsystem.controls.TextFieldH1

@Composable
fun AuthContent(
    state: AuthState,
    update: (AuthState) -> Unit,
    registration: (AuthState) -> Unit,
    login: (AuthState) -> Unit
) = Column(
    modifier = Modifier.fillMaxSize().padding(DesignComponent.size.rootSpace),
    verticalArrangement = Arrangement.spacedBy(DesignComponent.size.itemSpace)
) {

    TextFieldH1(
        text = "Welcome!"
    )

    InputEmail(
        modifier = Modifier.fillMaxWidth(),
        value = state.email,
        onValueChange = { update(state.copy(email = it)) }
    )

    InputPassword(
        modifier = Modifier.fillMaxWidth(),
        value = state.password,
        onValueChange = { update(state.copy(password = it)) }
    )

    Spacer(Modifier.weight(1f))

    ButtonPrimary(
        modifier = Modifier.fillMaxWidth(),
        text = "Login",
        onClick = { login.invoke(state) }
    )

    ButtonPrimary(
        modifier = Modifier.fillMaxWidth(),
        text = "Registration",
        onClick = { registration.invoke(state) }
    )
}