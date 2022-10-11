package presentation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import DesignComponent
import components.Header
import components.Root
import components.buttons.QuestionButton
import components.inputs.InputEmail
import components.inputs.InputPassword
import controls.ButtonPrimary
import controls.TextFieldH2
import data.repository.AuthRepository
import globalKoin
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import redux.AuthAction
import redux.AuthState
import redux.Direction
import redux.GlobalState
import redux.NavigatorAction
import redux.rememberDispatcher
import redux.selectState
import utils.rememberComposeCoroutineContext

@Composable
fun AuthContent() {

    val api = globalKoin().get<AuthRepository>()
    val launcher = rememberComposeCoroutineContext()

    val state by selectState<GlobalState, AuthState> { this.authState }
    val dispatcher = rememberDispatcher()

    LaunchedEffect(Unit) {
        if (api.isAuthorized)
            dispatcher(NavigatorAction.NAVIGATE(Direction.Trainings))
    }

    Root(
        modifier = Modifier.fillMaxSize(),
        header = {
            Header(title = "\uD83D\uDC4B Welcome back!")
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
        },
        footer = {

            ButtonPrimary(
                modifier = Modifier.fillMaxWidth(),
                text = "Log In",
                onClick = {
                    dispatcher(AuthAction.Validate)
                    launcher.call {
                        api
                            .login(state.email, state.password)
                            .onEach { dispatcher(NavigatorAction.NAVIGATE(Direction.Trainings)) }
                            .catch { }
                            .launchIn(this)
                    }
                }
            )

            QuestionButton(
                modifier = Modifier.fillMaxWidth(),
                question = "Don't have an account yet?",
                answer = "Sign Up!",
                onClick = {
                    dispatcher(AuthAction.Validate)
                    launcher.call {
                        api
                            .registration(state.email, state.password)
                            .onEach { dispatcher(NavigatorAction.NAVIGATE(Direction.Trainings)) }
                            .catch { }
                            .launchIn(this)
                    }
                }
            )
        }
    )
}