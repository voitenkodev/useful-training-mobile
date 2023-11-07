package registration.screen.registration

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.essenty.backhandler.BackCallback
import components.Error
import components.indication.SlideIndicator
import components.roots.Root
import io.github.xxfast.decompose.router.LocalRouterContext
import molecule.PaddingL
import molecule.PaddingXL
import platformTopInset
import registration.components.CredentialsPage
import registration.components.HeightPage
import registration.components.NamePage
import registration.components.WeightPage
import registration.state.RegistrationStatus
import registration.state.RegistrationSteps

@Composable
internal fun RegistrationContent(
    vm: RegistrationViewModel,
    toSuccessRegistration: () -> Unit,
    back: () -> Unit
) {

    val state by vm.state.collectAsState()

    LaunchedEffect(state.registrationStatus) {
        if (state.registrationStatus == RegistrationStatus.Available) toSuccessRegistration.invoke()
    }

    Content(
        loading = state.loading,
        error = state.error,
        clearError = vm::clearError,
        back = back,
        registration = vm::registration,
        name = state.name,
        updateName = vm::updateName,
        weight = state.weight,
        updateWeight = vm::updateWeight,
        height = state.height,
        updateHeight = vm::updateHeight,
        email = state.email,
        updateEmail = vm::updateEmail,
        password = state.password,
        updatePassword = vm::updatePassword,
        nextStep = vm::nextStep,
        previousStep = vm::previousStep,
        steps = state.steps,
        selectedStep = state.selectedStep,
        passwordRepeat = state.passwordRepeat,
        updatePasswordRepeat = vm::updatePasswordRepeat
    )
}

@Composable
private fun Content(
    loading: Boolean,
    error: String?,
    clearError: () -> Unit,
    back: () -> Unit,

    registration: () -> Unit,

    steps: List<RegistrationSteps>,
    selectedStep: RegistrationSteps,
    nextStep: () -> Unit,
    previousStep: (onEmpty: () -> Unit) -> Unit,

    name: String,
    updateName: (String) -> Unit,

    weight: Int,
    updateWeight: (Int) -> Unit,

    height: Int,
    updateHeight: (Int) -> Unit,

    email: String,
    updateEmail: (String) -> Unit,
    password: String,
    updatePassword: (String) -> Unit,
    passwordRepeat: String,
    updatePasswordRepeat: (String) -> Unit
) {

    val backProvider by rememberUpdatedState(back)

    val backHandler = LocalRouterContext.current.backHandler
    backHandler.register(BackCallback { previousStep.invoke(backProvider) })

    Root(error = { Error(message = { error }, close = clearError) }) {

        val pagerState = rememberPagerState(pageCount = { steps.size })

        LaunchedEffect(selectedStep) {
            pagerState.animateScrollToPage(steps.indexOf(selectedStep))
        }

        Column(
            modifier = Modifier.platformTopInset(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            PaddingXL()

            SlideIndicator(pagerState)

            PaddingL()

            HorizontalPager(
                modifier = Modifier.weight(1f),
                state = pagerState,
                userScrollEnabled = false
            ) {
                when (it) {
                    0 -> NamePage(
                        name = name,
                        updateName = updateName,
                        confirm = nextStep
                    )

                    1 -> WeightPage(
                        weight = weight,
                        updateWeight = updateWeight,
                        confirm = nextStep
                    )

                    2 -> HeightPage(
                        height = height,
                        updateHeight = updateHeight,
                        confirm = nextStep
                    )

                    3 -> CredentialsPage(
                        password = password,
                        email = email,
                        updateEmail = updateEmail,
                        updatePassword = updatePassword,
                        passwordRepeat = passwordRepeat,
                        updatePasswordRepeat = updatePasswordRepeat,
                        loading = loading,
                        confirm = registration
                    )
                }
            }
        }
    }
}