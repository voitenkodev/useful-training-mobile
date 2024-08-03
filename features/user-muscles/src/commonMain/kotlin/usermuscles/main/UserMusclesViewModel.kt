package usermuscles.main

import MusclesRepository
import UserRepository
import ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import models.MuscleStatusEnum
import muscles.mapping.toState
import org.koin.core.component.inject

internal class UserMusclesViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state.asStateFlow()

    private val musclesApi by inject<MusclesRepository>()
    private val userApi by inject<UserRepository>()

    init {
        musclesApi
            .observeMuscles()
            .onEach { r ->
                val muscleGroupState = r.toState(
                    eachMuscle = { m ->
                        val isSelected = when (m.status) {
                            MuscleStatusEnum.EXCLUDED -> false
                            MuscleStatusEnum.UNKNOWN -> null
                            else -> true
                        }
                        m.toState(isSelected = isSelected ?: false)
                    }
                )

                _state.update { it.copy(muscleGroups = muscleGroupState) }
            }
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)

        musclesApi.syncUserMuscles()
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)
    }

    fun selectMuscle(id: String) {
        _state.update {
            it.copy(loadingById = id)
        }

        val muscle = state.value.muscleGroups
            .flatMap { it.muscles }
            .find { it.id == id } ?: return

        val flow = if (muscle.isSelected.not()) userApi.deleteExcludedMuscle(muscle.id)
        else userApi.setExcludedMuscle(muscle.id)

        flow
            .flatMapConcat { musclesApi.syncUserMuscles() }
            .catch { r -> _state.update { it.copy(error = r.message, loadingById = null) } }
            .onEach { _state.update { it.copy(loadingById = null) } }
            .launchIn(this)
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}