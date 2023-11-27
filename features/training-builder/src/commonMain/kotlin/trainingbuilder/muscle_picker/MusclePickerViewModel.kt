package trainingbuilder.muscle_picker

import ExerciseExamplesRepository
import ViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import org.koin.core.component.inject
import trainingbuilder.muscle_picker.factory.muscleImage
import trainingbuilder.muscle_picker.mapping.toState
import trainingbuilder.muscle_picker.state.MuscleTypeEnum
import trainingbuilder.muscle_picker.state.State

internal class MusclePickerViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state

    private val exerciseExampleApi by inject<ExerciseExamplesRepository>()

    init {
        exerciseExampleApi
            .observeMuscleTypes()
            .onEach { r -> _state.update { it.copy(muscleTypes = r.toState()) } }
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)

        exerciseExampleApi.syncMuscleTypes()
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
                    imageVector = image
                )
            }.toImmutableList()

            it.copy(muscleTypes = muscleTypes)
        }
    }

    fun selectMuscleType(id: String) {
        _state.update {
            val muscleTypes = it.muscleTypes.map { muscleType ->
                if (id != muscleType.id) return@map muscleType

                val muscles = muscleType.muscles.map { muscle ->
                    muscle.copy(isSelected = muscleType.muscles.any { m -> m.isSelected.not() })
                }
                val image = muscleImage(
                    muscleTypeEnumState = muscleType.type,
                    muscles = muscles
                )
                muscleType.copy(
                    muscles = muscles,
                    imageVector = image
                )

            }.toImmutableList()

            it.copy(muscleTypes = muscleTypes)
        }
    }

    fun selectFullBody() {
        _state.update {
            val newValue = it.muscleTypes.all { mt -> mt.muscles.all { m -> m.isSelected } }.not()

            val muscleTypes = it.muscleTypes.map { muscleType ->
                val muscles = muscleType.muscles.map { m ->
                    m.copy(isSelected = newValue)
                }
                val image = muscleImage(
                    muscleTypeEnumState = muscleType.type,
                    muscles = muscles
                )
                muscleType.copy(
                    muscles = muscles,
                    imageVector = image
                )
            }.toImmutableList()

            it.copy(muscleTypes = muscleTypes)
        }
    }

    fun selectUpperBody() {
        _state.update {
            val newValue = it.muscleTypes
                .filterNot { mt -> mt.type == MuscleTypeEnum.LEGS }
                .all { mt -> mt.muscles.all { m -> m.isSelected } }.not()

            val muscleTypes = it.muscleTypes.map { muscleType ->
                val muscles = muscleType.muscles.map { muscle ->
                    muscle.copy(isSelected = if (muscleType.type == MuscleTypeEnum.LEGS) muscle.isSelected else newValue)
                }
                val image = muscleImage(
                    muscleTypeEnumState = muscleType.type,
                    muscles = muscles
                )
                muscleType.copy(
                    muscles = muscles,
                    imageVector = image
                )
            }.toImmutableList()

            it.copy(muscleTypes = muscleTypes)
        }
    }

    fun selectLowerBody() {
        _state.update {
            val newValue = it.muscleTypes
                .filter { mt -> mt.type == MuscleTypeEnum.LEGS }
                .all { mt -> mt.muscles.all { m -> m.isSelected } }.not()

            val muscleTypes = it.muscleTypes.map { muscleType ->
                val muscles = muscleType.muscles.map { muscle ->
                    muscle.copy(isSelected = if (muscleType.type != MuscleTypeEnum.LEGS) muscle.isSelected else newValue)
                }
                val image = muscleImage(
                    muscleTypeEnumState = muscleType.type,
                    muscles = muscles
                )
                muscleType.copy(
                    muscles = muscles,
                    imageVector = image
                )
            }.toImmutableList()

            it.copy(muscleTypes = muscleTypes)
        }
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}