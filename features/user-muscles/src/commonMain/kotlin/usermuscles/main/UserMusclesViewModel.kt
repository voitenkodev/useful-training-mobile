package usermuscles.main

import MusclesRepository
import ViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import org.koin.core.component.inject
import usermuscles.main.factories.muscleImage
import usermuscles.main.mapping.toState

internal class UserMusclesViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state

    private val musclesApi by inject<MusclesRepository>()

    init {
        musclesApi
            .observeMuscleTypes()
            .onEach { r -> _state.update { it.copy(muscleTypes = r.toState()) } }
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)

        musclesApi.syncMuscleTypes()
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)
    }

    fun selectMuscle(id: String) {
        _state.update {
            val muscleTypes = it.muscleTypes.map { muscleType ->
                val muscles = muscleType.muscles.map { muscle ->
                    if (id == muscle.id) muscle.copy(isSelected = muscle.isSelected.not())
                    else muscle
                }
                val image = muscleImage(
                    muscleTypeEnumState = muscleType.type,
                    muscles = muscles
                )
                muscleType.copy(
                    muscles = muscles,
                    bodyImageVector = image
                )

            }.toImmutableList()

            it.copy(muscleTypes = muscleTypes)
        }
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}