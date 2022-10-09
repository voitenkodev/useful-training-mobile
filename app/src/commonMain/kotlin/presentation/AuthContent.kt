package presentation

import AuthSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import designsystem.atomic.DesignComponent
import designsystem.components.Header
import designsystem.components.Root
import designsystem.components.inputs.InputEmail
import designsystem.components.inputs.InputPassword
import designsystem.controls.ButtonPrimary
import designsystem.controls.ButtonSecondary
import designsystem.controls.TextFieldBody2
import designsystem.controls.TextFieldH2
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.mp.KoinPlatformTools
import redux.AuthAction
import redux.AuthState
import redux.Direction
import redux.GlobalState
import redux.NavigatorAction
import redux.rememberDispatcher
import redux.selectState
import utils.rememberComposeLoader


@Composable
fun AuthContent(
    modifier: Modifier = Modifier,
) {

    // todo should be UseCase
    val api = KoinPlatformTools.defaultContext().get().get<AuthSource>()
    val state by selectState<GlobalState, AuthState> { this.authState }

    val dispatcher = rememberDispatcher()
    val loader = rememberComposeLoader()

    LaunchedEffect(Unit) {
        if (api.isAuthorized)
            dispatcher(NavigatorAction.NAVIGATE(Direction.Trainings))
    }

    Root(
        modifier = modifier.fillMaxSize(),
        header = {
            Header(title = "\uD83D\uDC4B Welcome back!")
        },
        footer = {

            ButtonPrimary(
                modifier = Modifier.fillMaxWidth(),
                text = "Log In",
                onClick = {
                    dispatcher(AuthAction.Validate)
                    loader.load {
                        api
                            .login(state.email, state.password)
                            .onEach { dispatcher(NavigatorAction.NAVIGATE(Direction.Trainings)) }
                            .catch { }
                            .launchIn(this)
                    }
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
                        loader.load {
                            api
                                .registration(state.email, state.password)
                                .onEach { dispatcher(NavigatorAction.NAVIGATE(Direction.Trainings)) }
                                .catch { }
                                .launchIn(this)
                        }
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