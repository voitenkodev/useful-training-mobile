package content

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import designsystem.common.DesignComponent
import designsystem.controls.Header
import designsystem.components.InputEmail
import designsystem.components.InputPassword
import designsystem.controls.Root
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
) = Root(
    modifier = modifier,
    header = {
        Header(title = "\uD83D\uDC4B Welcome back!")
    },
    footer = {

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
    },
    content = {

        item {
            TextFieldH2(
                text = "Sign in to your account",
                color = DesignComponent.colors.caption
            )
        }

        item { Spacer(modifier = Modifier.size(16.dp)) }

        item {
            InputEmail(
                modifier = Modifier.fillMaxWidth(),
                value = state.email,
                onValueChange = { update(state.copy(email = it)) }
            )
        }

        item {
            InputPassword(
                modifier = Modifier.fillMaxWidth(),
                value = state.password,
                onValueChange = { update(state.copy(password = it)) }
            )
        }
    }
)