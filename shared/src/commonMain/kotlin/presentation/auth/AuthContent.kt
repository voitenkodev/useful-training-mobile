package presentation.auth

import PlatformBackHandler
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
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
import utils.recomposeHighlighter

@Composable
internal fun AuthContent(vm: AuthViewModel) {

    val state by vm.state.collectAsState()

    ScrollableRoot(
        modifier = Modifier.fillMaxWidth().recomposeHighlighter(),
        loading = { Loading(state.loading) },
        error = { Error(message = state.error, close = vm::clearError) },
        back = { PlatformBackHandler(vm::back) },
        header = {
            TextFieldH1(
                modifier = Modifier
                    .height(Design.dp.collapsedAppBar)
                    .wrapContentHeight()
                    .recomposeHighlighter(),
                text = "\uD83D\uDC4B Welcome back!",
                textAlign = TextAlign.Center
            )
        },
        footer = {

            ButtonPrimary(
                modifier = Modifier.fillMaxWidth().recomposeHighlighter(),
                text = "Log In",
                onClick = vm::login
            )

            ButtonQuestion(
                modifier = Modifier.fillMaxWidth().recomposeHighlighter(),
                question = "Don't have an account yet?",
                answer = "Sign Up!",
                onClick = vm::registration
            )
        },
        content = {
            item(key = "notes") {
                TextFieldBody1(
                    modifier = Modifier.recomposeHighlighter(),
                    text = "Sign in to your account",
                    color = Design.colors.caption
                )
            }
            item(key = "input_email") {
                InputEmail(
                    modifier = Modifier.fillMaxWidth().recomposeHighlighter(),
                    value = state.email,
                    onValueChange = vm::updateEmail
                )
            }
            item(key = "input_password") {
                InputPassword(
                    modifier = Modifier.fillMaxWidth().recomposeHighlighter(),
                    value = state.password,
                    onValueChange = vm::updatePassword
                )
            }
        }
    )
}