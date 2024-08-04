package authentication.register

import AuthenticationRepository
import EquipmentsRepository
import IncludedStatusEnum
import MusclesRepository
import UserRepository
import ViewModel
import authentication.register.models.RegistrationStatus
import cmToM
import equipment.mapping.toState
import grToKg
import isEmailValid
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.updateAndGet
import muscles.factories.muscleImage
import muscles.mapping.toState
import org.koin.core.component.inject
import user.ExperienceEnum
import user.mapping.toState

internal class RegistrationViewModel : ViewModel() {

    private val authApi by inject<AuthenticationRepository>()
    private val userApi by inject<UserRepository>()
    private val musclesApi by inject<MusclesRepository>()
    private val equipmentsApi by inject<EquipmentsRepository>()

    private val _state = MutableStateFlow(State())
    val state: StateFlow<State> = _state.asStateFlow()

    init {
        authApi
            .getToken()
            .filterNotNull()
            .onEach {
                _state.update { it.copy(registrationStatus = RegistrationStatus.Available) }
            }
            .launchIn(this)

        musclesApi
            .observeMuscles()
            .onEach { r ->
                val muscleGroup = r.toState(eachMuscle = { m -> m.toState(isSelected = true) })
                _state.update { it.copy(muscleGroups = muscleGroup) }
            }
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)

        equipmentsApi
            .observeEquipments()
            .onEach { r ->
                val equipmentGroups = r.toState(defaultStatus = IncludedStatusEnum.INCLUDED)
                _state.update { it.copy(equipmentGroups = equipmentGroups) }
            }
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)

        musclesApi.syncPublicMuscles()
            .flatMapConcat { equipmentsApi.syncPublicEquipments() }
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)
    }

    fun registration() {
        val last = _state.updateAndGet { it.validate() }

        val experience = last.selectedExperience?.toState()?.toString() ?: return

        val excludeEquipmentIds = last.equipmentGroups
            .flatMap { it.equipments }
            .filter { it.status == IncludedStatusEnum.EXCLUDED }
            .map { it.id }

        val excludeMuscleIds = last.muscleGroups
            .flatMap { it.muscles }
            .filter { it.isSelected.not() }
            .map { it.id }

        if (last.error == null) {
            authApi
                .registration(
                    email = last.email,
                    password = last.password,
                    name = last.name,
                    weight = last.weight.grToKg(),
                    height = last.height.cmToM(),
                    experience = experience,
                    excludeMuscleIds = excludeMuscleIds,
                    excludeEquipmentIds = excludeEquipmentIds,
                )
                .flatMapConcat { userApi.syncUser() }
                .onStart { _state.update { it.copy(loading = true) } }
                .onEach {
                    _state.update {
                        it.copy(
                            registrationStatus = RegistrationStatus.Available,
                            loading = false
                        )
                    }
                }
                .catch { t -> _state.update { it.copy(loading = false, error = t.message) } }
                .launchIn(this)
        }
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }

    fun updateEmail(value: String) {
        _state.update { it.copy(email = value) }
    }

    fun updateName(value: String) {
        _state.update { it.copy(name = value) }
    }

    fun updatePassword(value: String) {
        _state.update { it.copy(password = value) }
    }

    fun selectExperience(value: ExperienceEnum) {
        _state.update {
            it.copy(selectedExperience = value)
        }
    }

    fun selectEquipment(id: String) {
        _state.update {
            it.copy(
                equipmentGroups = it.equipmentGroups.map { mt ->
                    val equipments = mt.equipments.map equipMap@{ v ->
                        if (id != v.id) {
                            return@equipMap v
                        }

                        v.copy(
                            status = when (v.status) {
                                IncludedStatusEnum.INCLUDED -> IncludedStatusEnum.EXCLUDED
                                IncludedStatusEnum.EXCLUDED -> IncludedStatusEnum.INCLUDED
                                null -> null
                            }
                        )
                    }.toPersistentList()

                    mt.copy(
                        equipments = equipments
                    )
                }.toPersistentList()
            )
        }
    }

    fun selectMuscle(id: String) {
        _state.update {
            it.copy(
                muscleGroups = it.muscleGroups.map { mt ->
                    val muscles = mt.muscles.map muscleMap@{ m ->
                        if (id != m.id) {
                            return@muscleMap m
                        }

                        m.copy(isSelected = m.isSelected.not())
                    }.toPersistentList()

                    mt.copy(
                        muscles = muscles,
                        bodyImageVector = muscleImage(mt.type, muscles, null)
                    )
                }.toPersistentList()
            )
        }
    }

    fun updatePasswordRepeat(value: String) {
        _state.update { it.copy(passwordRepeat = value) }
    }

    fun updateWeight(value: Int) {
        _state.update { it.copy(weight = value) }
    }

    fun updateHeight(value: Int) {
        _state.update { it.copy(height = value) }
    }

    fun previousStep(onNextEmpty: () -> Unit) {
        _state.update {
            val newStepIndex = it.steps.indexOf(it.selectedStep).minus(1)
            if (newStepIndex < 0) {
                onNextEmpty.invoke()
                it
            } else it.copy(selectedStep = it.steps[newStepIndex])
        }
    }

    fun nextStep() {
        _state.update {
            val newStepIndex = it.steps.indexOf(it.selectedStep).plus(1)
            if (newStepIndex > it.steps.lastIndex) it
            else it.copy(selectedStep = it.steps[newStepIndex])
        }
    }

    private fun State.validate(): State {

        val newEmail = this.email.trim().lowercase()
        val newPassword = this.password.trim()
        val newPasswordRepeat = this.passwordRepeat.trim()

        val isEmailValid = isEmailValid(newEmail)
        val isPasswordValid = newPassword.length > 5
        val isPasswordRepeatValid = newPasswordRepeat.length > 5
        val passwordIsMatch = newPasswordRepeat == newPassword

        val newError = if (isEmailValid.not()) "Invalid Email Field"
        else if (isPasswordValid.not()) "Invalid password field"
        else if (isPasswordRepeatValid.not()) "Invalid password repeat field"
        else if (passwordIsMatch.not()) "Password mismatch"
        else null

        return this.copy(email = newEmail, password = newPassword, error = newError)
    }
}