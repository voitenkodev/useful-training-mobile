package presentation.auth

import components.BackHandler
import DesignComponent
import GlobalState
import Graph
import Navigator
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.Error
import components.Header
import components.Loading
import components.Root
import components.buttons.QuestionButton
import components.inputs.InputEmail
import components.inputs.InputPassword
import controls.ButtonPrimary
import controls.TextFieldH2
import rememberDispatcher
import selectState

@Composable
fun AuthContent(
    navigator: Navigator
) {

    val state by selectState<GlobalState, AuthState> { this.authState }
    val dispatcher = rememberDispatcher()

    val presenter = remember { AuthPresenter(dispatcher) }
    LaunchedEffect(Unit) {
        presenter.checkAuthorization { navigator.direct(Graph.Trainings, true) }
    }

    Root(
        modifier = Modifier.fillMaxSize(),
        loading = {
            Loading(state.loading)
        },
        error = {
            Error(message = state.error, close = { dispatcher(AuthAction.Error(null)) })
        },
        back = {
            BackHandler(action = { navigator.back() })
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
                onValueChange = { dispatcher(AuthAction.SetEmailAction(it)) }
            )

            InputPassword(
                modifier = Modifier.fillMaxWidth(),
                value = state.password,
                onValueChange = { dispatcher(AuthAction.SetPasswordAction(it)) }
            )
        },
        footer = {

            ButtonPrimary(
                modifier = Modifier.fillMaxWidth(),
                text = "Log In",
                onClick = {
                    dispatcher(AuthAction.Validate)
                    if (state.error == null) presenter.login(email = state.email, password = state.password) {
                        navigator.direct(Graph.Trainings, true)
                    }
                }
            )

            QuestionButton(
                modifier = Modifier.fillMaxWidth(),
                question = "Don't have an account yet?",
                answer = "Sign Up!",
                onClick = {
                    dispatcher(AuthAction.Validate)
                    if (state.error == null) presenter.registration(email = state.email, password = state.password) {
                        navigator.direct(Graph.Trainings, true)
                    }
                }
            )
        }
    )
}