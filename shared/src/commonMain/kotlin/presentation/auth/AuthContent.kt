package presentation.auth

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import design.Design
import design.components.Error
import design.components.Loading
import design.components.Root
import design.components.buttons.ButtonQuestion
import design.components.inputs.InputEmail
import design.components.inputs.InputPassword
import design.controls.ButtonPrimary
import design.controls.TextFieldH1
import design.controls.TextFieldH2

@Composable
internal fun AuthContent(vm: AuthViewModel) {

    val state by vm.state

    Root(
        modifier = Modifier.fillMaxWidth(),
        loading = { Loading(state.loading) },
        error = { Error(message = state.error, close = vm::clearError) },
        back = {},
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

            ButtonPrimary(
                modifier = Modifier.fillMaxWidth(),
                text = "Log In",
                onClick = { vm.login(email = state.email, password = state.password) }
            )

            ButtonQuestion(
                modifier = Modifier.fillMaxWidth(),
                question = "Don't have an account yet?",
                answer = "Sign Up!",
                onClick = { vm.registration(email = state.email, password = state.password) }
            )
        },
        content = {

            TextFieldH2(
                text = "Sign in to your account",
                color = Design.colors.caption
            )

            InputEmail(
                modifier = Modifier.fillMaxWidth(),
                value = state.email,
                onValueChange = vm::updateEmail
            )

            InputPassword(
                modifier = Modifier.fillMaxWidth(),
                value = state.password,
                onValueChange = vm::updatePassword
            )
        }
    )
}