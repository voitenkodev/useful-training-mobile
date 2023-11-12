package musclepicker.screen

import ExerciseExamplesRepository
import ViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import musclepicker.mapping.toState
import musclepicker.state.State
import org.koin.core.component.inject

internal class MusclePickerViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state

    private val api by inject<ExerciseExamplesRepository>()

    init {
        api
            .observeMuscles()
            .onEach { r -> _state.update { it.copy(muscleTypes = r.toState()) } }
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)

        api.syncMuscles()
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)
    }


    fun selectMuscle(muscleId: String) {
        _state.update {
            val muscleTypes = it.muscleTypes.map { muscleType ->
                val muscles = muscleType.muscles.map { muscle ->
                    if (muscle.id == muscleId) muscle.copy(isSelected = muscle.isSelected.not())
                    else muscle
                }
                muscleType.copy(muscles = muscles)
            }.toImmutableList()
            it.copy(muscleTypes = muscleTypes)
        }
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}