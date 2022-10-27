package presentation.auth

import DesignComponent
import GlobalState
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.BackHandler
import components.Error
import components.Header
import components.Loading
import components.Root
import components.buttons.QuestionButton
import components.inputs.InputEmail
import components.inputs.InputPassword
import controls.ButtonPrimary
import controls.TextFieldH2
import selectState

@Composable
fun AuthContent(vm: AuthViewModel) {

    val state by selectState<GlobalState, AuthState> { this.authState }

    Root(
        modifier = Modifier.fillMaxSize(),
        loading = {
            Loading(state.loading)
        },
        error = {
            Error(message = state.error, close = { vm.clearError() })
        },
        back = {
            BackHandler(action = { vm.back() })
        },
        header = {
            Header(title = "\uD83D\uDC4B Welcome back!")
        },
        content = {

            TextFieldH2(
                text = "Sign in to your account",
                color = DesignComponent.colors.caption
            )

            Spacer(modifier = Modifier.size(16.dp))

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
        },
        footer = {

            ButtonPrimary(
                modifier = Modifier.fillMaxWidth(),
                text = "Log In",
                onClick = { vm.login(email = state.email, password = state.password) }
            )

            QuestionButton(
                modifier = Modifier.fillMaxWidth(),
                question = "Don't have an account yet?",
                answer = "Sign Up!",
                onClick = { vm.registration(email = state.email, password = state.password) }
            )
        }
    )
}