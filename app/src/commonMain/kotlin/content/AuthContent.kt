package content

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import designsystem.common.DesignComponent
import designsystem.components.InputEmail
import designsystem.components.InputPassword
import designsystem.components.Title
import designsystem.controls.ButtonPrimary
import designsystem.controls.ButtonSecondary
import designsystem.controls.TextFieldBody2
import designsystem.controls.TextFieldH2
import state.AuthState

@Composable
fun AuthContent(
    modifier: Modifier = Modifier,
    state: AuthState,
    update: (AuthState) -> Unit,
    registration: (AuthState) -> Unit,
    login: (AuthState) -> Unit
) = Column(
    modifier = modifier
        .fillMaxSize()
        .padding(DesignComponent.size.rootSpace),
    verticalArrangement = Arrangement.spacedBy(DesignComponent.size.rootSpace)
) {

    Title(
        text = "\uD83D\uDC4B Hello Again!",
    )

    TextFieldH2(
        text = "Welcome back you've been missed!",
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

    Spacer(modifier = Modifier.weight(1f))

    ButtonPrimary(
        modifier = Modifier.fillMaxWidth(),
        text = "Log In",
        onClick = { login.invoke(state) }
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically
    ) {

        TextFieldBody2(
            text = "Don't have an account yet?",
            color = DesignComponent.colors.caption
        )

        ButtonSecondary(
            text = "Sign Up!",
            onClick = { registration.invoke(state) }
        )
    }
}