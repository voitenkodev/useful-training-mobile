package usermuscles.main

import MusclesRepository
import UserRepository
import ViewModel
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import org.koin.core.component.inject
import usermuscles.main.mapping.toState
import usermuscles.main.models.StatusEnum

internal class UserMusclesViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state.asStateFlow()

    private val musclesApi by inject<MusclesRepository>()
    private val userApi by inject<UserRepository>()

    init {
        musclesApi
            .observeMuscles()
            .onEach { r -> _state.update { it.copy(muscleGroups = r.toState()) } }
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)

        musclesApi.syncUserMuscles()
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)
    }

    fun selectMuscle(id: String) {
        _state.update {
            it.copy(
                muscleGroups = it.muscleGroups.map { mt ->
                    mt.copy(
                        muscles = mt.muscles.map { m ->
                            m.copy(loading = id == m.id)
                        }.toPersistentList()
                    )
                }.toPersistentList()
            )
        }

        val muscle = state.value.muscleGroups
            .flatMap { it.muscles }
            .find { it.id == id } ?: return

        val flow = if (muscle.status == StatusEnum.EXCLUDED) userApi.deleteExcludedMuscle(muscle.id)
        else userApi.setExcludedMuscle(muscle.id)

        flow
            .flatMapConcat { musclesApi.syncUserMuscles() }
            .onStart { _state.update { it.copy(loading = true) } }
            .catch { r -> _state.update { it.copy(error = r.message, loading = false) } }
            .onEach { _state.update { it.copy(loading = false) } }
            .launchIn(this)
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}