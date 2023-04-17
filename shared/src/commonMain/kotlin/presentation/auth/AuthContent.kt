package presentation.auth

import PlatformBackHandler
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
                    .height(Design.dp.collapsedAppBar)
                    .wrapContentHeight(),
                text = "\uD83D\uDC4B Welcome back!",
                textAlign = TextAlign.Center
            )
        },
        footer = {

            val login by remember {
                mutableStateOf(vm::login)
            }

            ButtonPrimary(
                modifier = Modifier.fillMaxWidth(),
                text = "Log In",
                onClick = login
            )

            val registration by remember {
                mutableStateOf(vm::registration)
            }
            ButtonQuestion(
                modifier = Modifier.fillMaxWidth(),
                question = "Don't have an account yet?",
                answer = "Sign Up!",
                onClick = registration
            )
        },
        content = {
            item(key = "notes") {
                TextFieldBody1(
                    modifier = Modifier,
                    text = "Sign in to your account",
                    color = Design.colors.caption
                )
            }
            item(key = "input_email") {
                val updater by remember {
                    mutableStateOf(vm::updateEmail)
                }

                InputEmail(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.email,
                    onValueChange = updater
                )
            }
            item(key = "input_password") {
                val updater by remember {
                    mutableStateOf(vm::updatePassword)
                }

                InputPassword(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.password,
                    onValueChange = updater
                )
            }
        }
    )
}