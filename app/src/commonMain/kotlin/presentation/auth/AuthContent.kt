package presentation.auth

import Design
import GlobalState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.BackHandler
import components.Error
import components.Loading
import components.buttons.QuestionButton
import components.inputs.InputEmail
import components.inputs.InputPassword
import controls.ButtonPrimary
import controls.TextFieldH1
import controls.TextFieldH2
import selectState

@Composable
fun AuthContent(vm: AuthViewModel) {

    val state by selectState<GlobalState, AuthState> { this.authState }

    Column(
        modifier = Modifier.padding(Design.dp.padding),
        verticalArrangement = Arrangement.spacedBy(Design.dp.padding)
    ) {

        TextFieldH1(
            modifier = Modifier.fillMaxWidth(),
            text = "\uD83D\uDC4B Welcome back!"
        )

        TextFieldH2(
            text = "Sign in to your account",
            color = Design.colors.caption
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

        Spacer(modifier = Modifier.weight(1f))

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

    Error(message = state.error, close = vm::clearError)
    Loading(state.loading)
    BackHandler(action = vm::back)
}