package authentication.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import authentication.register.models.EquipmentGroup
import authentication.register.models.ExperienceEnum
import authentication.register.models.MuscleGroup
import authentication.register.models.RegistrationStatus
import authentication.register.models.RegistrationSteps
import authentication.register.pages.CredentialsPage
import authentication.register.pages.ExcludeEquipmentPage
import authentication.register.pages.ExcludeMusclePage
import authentication.register.pages.ExperiencePage
import authentication.register.pages.HeightPage
import authentication.register.pages.NamePage
import authentication.register.pages.WeightPage
import com.arkivanov.essenty.backhandler.BackCallback
import components.Error
import components.indication.SlideIndicator
import components.roots.ScreenRoot
import io.github.xxfast.decompose.router.LocalRouterContext
import kotlinx.collections.immutable.ImmutableList
import molecule.PaddingL
import molecule.PaddingXL
import molecule.primaryBackground

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
        updatePasswordRepeat = vm::updatePasswordRepeat,
        muscles = state.muscleGroups,
        selectMuscle = vm::selectMuscle,
        equipments = state.equipmentGroups,
        selectEquipment = vm::selectEquipment,
        experience = state.selectedExperience,
        experiences = state.experiences,
        selectExperience = vm::selectExperience
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

    experiences: ImmutableList<ExperienceEnum>,
    experience: ExperienceEnum?,
    selectExperience: (value: ExperienceEnum) -> Unit,

    muscles: ImmutableList<MuscleGroup>,
    selectMuscle: (id: String) -> Unit,

    equipments: ImmutableList<EquipmentGroup>,
    selectEquipment: (id: String) -> Unit,

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
    val pagerState = rememberPagerState(pageCount = { steps.size })

    LaunchedEffect(selectedStep) {
        pagerState.animateScrollToPage(steps.indexOf(selectedStep))
    }

    ScreenRoot(error = { Error(message = { error }, close = clearError) }) {
        Column(
            modifier = Modifier.primaryBackground().statusBarsPadding(),
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

                    3 -> ExperiencePage(
                        experiences = experiences,
                        experience = experience,
                        update = selectExperience,
                        confirm = nextStep
                    )

                    4 -> ExcludeMusclePage(
                        muscles = muscles,
                        selectMuscle = selectMuscle,
                        confirm = nextStep
                    )

                    5 -> ExcludeEquipmentPage(
                        equipments = equipments,
                        selectEquipment = selectEquipment,
                        confirm = nextStep
                    )

                    6 -> CredentialsPage(
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