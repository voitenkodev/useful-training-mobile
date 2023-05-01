package presentation.auth

import PlatformBackHandler
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import design.Design
import design.components.Error
import design.components.Loading
import design.components.buttons.ButtonQuestion
import design.components.inputs.InputEmail
import design.components.inputs.InputPassword
import design.components.roots.ScrollableRoot
import design.controls.ButtonPrimary
import design.controls.TextFieldBody1
import design.controls.TextFieldH1

@Composable
internal fun AuthContent(vm: AuthViewModel) {

    val state by vm.state.collectAsState()

    ScrollableRoot(
        modifier = Modifier.fillMaxWidth(),
        loading = { Loading(state.loading) },
        error = { Error(message = state.error, close = vm::clearError) },
        back = { PlatformBackHandler(vm::back) },
        header = {
            TextFieldH1(
                modifier = Modifier
                    .height(Design.dp.bigHeader),
                provideText = { "\uD83D\uDC4B Welcome back!" },
                textAlign = TextAlign.Center
            )
        },
        footer = {
            ButtonPrimary(
                modifier = Modifier.fillMaxWidth(),
                text = "Log In",
                onClick = vm::login
            )

            ButtonQuestion(
                modifier = Modifier.fillMaxWidth(),
                question = "Don't have an account yet?",
                answer = "Sign Up!",
                onClick = vm::registration
            )
        },
        content = {
            item(key = "notes") {
                TextFieldBody1(
                    modifier = Modifier,
                    provideText = { "Sign in to your account" },
                    color = Design.colors.caption
                )
            }
            item(key = "input_email") {
                InputEmail(
                    modifier = Modifier.fillMaxWidth(),
                    provideValue = { state.email },
                    onValueChange = vm::updateEmail
                )
            }
            item(key = "input_password") {
                InputPassword(
                    modifier = Modifier.fillMaxWidth(),
                    provideValue = { state.password },
                    onValueChange = vm::updatePassword
                )
            }
        }
    )
}