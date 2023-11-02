package registration.screen

import PlatformBackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import components.Error
import components.Loading
import components.roots.Root
import components.states.keyboardFloatAsState
import molecule.PaddingL
import platformInsets
import registration.components.PreviewPage
import registration.state.TokenStatus

@Composable
internal fun RegistrationContent(
    vm: RegistrationViewModel,
    toTrainings: () -> Unit,
    back: () -> Unit
) {

    val state by vm.state.collectAsState()

    LaunchedEffect(state.tokenStatus) {
        if (state.tokenStatus == TokenStatus.Available) toTrainings.invoke()
    }

    Content(
        loading = { state.loading },
        error = { state.error },
        clearError = vm::clearError,
        back = back,
        login = vm::login,
        registration = vm::registration,
        email = { state.email },
        updateEmail = vm::updateEmail,
        password = { state.password },
        updatePassword = vm::updatePassword
    )
}

@Composable
private fun Content(
    loading: () -> Boolean,
    error: () -> String?,
    clearError: () -> Unit,
    back: () -> Unit,

    login: () -> Unit,
    registration: () -> Unit,

    email: () -> String,
    updateEmail: (String) -> Unit,
    password: () -> String,
    updatePassword: (String) -> Unit
) {

    val focus = LocalFocusManager.current

    val loginProvider by rememberUpdatedState {
        focus.clearFocus()
        login.invoke()
    }
    val registrationProvider by rememberUpdatedState {
        focus.clearFocus()
        registration.invoke()
    }
    val backProvider by rememberUpdatedState(back)

    val keyboardFloatAsState = keyboardFloatAsState(
        initialValue = 1f,
        targetValue = 0.3f
    )

    Root(
        loading = { Loading(loading) },
        error = { Error(message = error, close = clearError) },
        back = { PlatformBackHandler(backProvider) },
    ) {

        val pagerState = rememberPagerState(
            pageCount = { 5 }
        )

        Column(modifier = Modifier.platformInsets()) {

            PaddingL()

            HorizontalPager(
                modifier = Modifier.fillMaxSize(),
                state = pagerState,
                userScrollEnabled = false
            ) {
                when (it) {
                    0 -> PreviewPage()
                }
            }
        }
    }
}