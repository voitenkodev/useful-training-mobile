package presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import designsystem.atomic.DesignComponent
import designsystem.components.inputs.InputEmail
import designsystem.components.inputs.InputPassword
import designsystem.controls.ButtonPrimary
import designsystem.controls.ButtonSecondary
import designsystem.controls.Header
import designsystem.controls.Root
import designsystem.controls.TextFieldBody2
import designsystem.controls.TextFieldH2
import redux.AuthAction
import redux.AuthState
import redux.GlobalState
import redux.rememberDispatcher
import redux.selectState

@Composable
fun AuthContent(
    modifier: Modifier = Modifier,
    registration: (AuthState) -> Unit,
    login: (AuthState) -> Unit
) {
    val dispatcher = rememberDispatcher()
    val state by selectState<GlobalState, AuthState> { this.authState }

    Root(
        modifier = modifier,
        header = {
            Header(title = "\uD83D\uDC4B Welcome back!")
        },
        footer = {

            ButtonPrimary(
                modifier = Modifier.fillMaxWidth(),
                text = "Log In",
                onClick = {
                    dispatcher(AuthAction.Validate)
                    login.invoke(state)
                }
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
                    onClick = {
                        dispatcher(AuthAction.Validate)
                        registration.invoke(state)
                    }
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

            item {
                Spacer(modifier = Modifier.size(16.dp))
            }

            item {
                InputEmail(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.email,
                    onValueChange = { dispatcher(AuthAction.SetEmailAction(it)) }
                )
            }

            item {
                InputPassword(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.password,
                    onValueChange = { dispatcher(AuthAction.SetPasswordAction(it)) }
                )
            }
        }
    )
}