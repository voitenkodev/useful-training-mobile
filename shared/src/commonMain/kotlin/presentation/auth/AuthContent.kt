package presentation.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import design.Design
import design.components.Error
import design.components.Loading
import design.components.buttons.QuestionButton
import design.components.inputs.InputEmail
import design.components.inputs.InputPassword
import design.controls.ButtonPrimary
import design.controls.TextFieldH1
import design.controls.TextFieldH2

@Composable
internal fun AuthContent(vm: AuthViewModel) {

    val state by vm.state

    Column(
        modifier = Modifier.padding(horizontal = Design.dp.padding),
        verticalArrangement = Arrangement.spacedBy(Design.dp.padding)
    ) {

        TextFieldH1(
            modifier = Modifier
                .height(Design.dp.collapsedAppBar)
                .wrapContentHeight(),
            text = "\uD83D\uDC4B Welcome back!",
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.size(16.dp))

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

        Spacer(modifier = Modifier.size(Design.dp.padding))
    }

    Error(message = state.error, close = vm::clearError)

    Loading(state.loading)

//    BackHandler(action = vm::back)
}