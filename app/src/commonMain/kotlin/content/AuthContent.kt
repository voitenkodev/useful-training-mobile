package content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import designsystem.common.DesignComponent
import designsystem.components.InputEmail
import designsystem.components.InputPassword
import designsystem.controls.ButtonPrimary
import designsystem.controls.TextFieldH1
import designsystem.controls.TextFieldH2
import designsystem.controls.Toolbar
import state.AuthState

@Composable
fun AuthContent(
    state: AuthState,
    update: (AuthState) -> Unit,
    registration: (AuthState) -> Unit,
    login: (AuthState) -> Unit
) = Column(
    modifier = Modifier
        .fillMaxSize()
        .background(color = DesignComponent.colors.primary50)
        .padding(DesignComponent.size.rootSpace),
    verticalArrangement = Arrangement.spacedBy(DesignComponent.size.itemSpace)
) {

    Toolbar()

    TextFieldH1(
        text = "Hello Again!",
    )

    TextFieldH2(
        text = "Welcome back you've been missed!",
    )

    Spacer(modifier = Modifier.size(8.dp))

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

    Spacer(modifier = Modifier.weight(1f))

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