package trainingbuilder.muscle_picker

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
import trainingbuilder.muscle_picker.factories.muscleImage
import trainingbuilder.muscle_picker.mapping.toState
import trainingbuilder.muscle_picker.models.MuscleTypeEnum

internal class MusclePickerViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state

    private val musclesApi by inject<MusclesRepository>()

    init {
        musclesApi
            .observeMuscles()
            .onEach { r -> _state.update { it.copy(muscleTypes = r.toState(it.includedMuscleStatuses)) } }
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)

        musclesApi.syncUserMuscles()
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)
    }

    fun selectMuscle(id: String) {
        _state.update { st ->
            val muscleTypes = st.muscleTypes.map { muscleType ->
                val muscles = muscleType.muscles
                    .map { muscle ->
                        if (id == muscle.id) muscle.copy(isSelected = muscle.isSelected.not())
                        else muscle
                    }
                val image = muscleImage(
                    muscleTypeEnumState = muscleType.type,
                    muscles = muscles,
                    includedMuscleStatuses = st.includedMuscleStatuses
                )
                muscleType.copy(
                    muscles = muscles,
                    isSelected = muscles
                        .filter { st.includedMuscleStatuses.contains(it.status) }
                        .none { m -> m.isSelected.not() },
                    bodyImageVector = image
                )

            }.toImmutableList()

            st.copy(muscleTypes = muscleTypes)
        }
    }

    fun selectMuscleType(id: String) {
        _state.update { st ->
            val newValue = st.muscleTypes.find { it.id == id }?.let { mt ->
                mt.muscles
                    .filter { st.includedMuscleStatuses.contains(it.status) }
                    .all { m -> m.isSelected }
            }?.not() ?: false

            val muscleTypes = st.muscleTypes.map { muscleType ->
                if (id != muscleType.id) return@map muscleType

                val muscles = muscleType.muscles
                    .map { muscle ->
                        if (st.includedMuscleStatuses.contains(muscle.status).not()) muscle
                        else muscle.copy(isSelected = newValue)
                    }
                val image = muscleImage(
                    muscleTypeEnumState = muscleType.type,
                    muscles = muscles,
                    includedMuscleStatuses = st.includedMuscleStatuses
                )
                muscleType.copy(
                    muscles = muscles,
                    isSelected = muscles
                        .filter { st.includedMuscleStatuses.contains(it.status) }
                        .none { m -> m.isSelected.not() },
                    bodyImageVector = image
                )

            }.toImmutableList()

            st.copy(muscleTypes = muscleTypes)
        }
    }

    fun selectFullBody() {
        _state.update { st ->
            val newValue = st.muscleTypes.all { mt ->
                mt.muscles
                    .filter { st.includedMuscleStatuses.contains(it.status) }
                    .all { m -> m.isSelected }
            }.not()

            val muscleTypes = st.muscleTypes.map { muscleType ->
                val muscles = muscleType.muscles
                    .map { muscle ->
                        if (st.includedMuscleStatuses.contains(muscle.status).not()) muscle
                        else muscle.copy(isSelected = newValue)
                    }
                val image = muscleImage(
                    muscleTypeEnumState = muscleType.type,
                    muscles = muscles,
                    includedMuscleStatuses = st.includedMuscleStatuses
                )
                muscleType.copy(
                    muscles = muscles,
                    isSelected = muscles
                        .filter { st.includedMuscleStatuses.contains(it.status) }
                        .none { m -> m.isSelected.not() },
                    bodyImageVector = image
                )

            }.toImmutableList()

            st.copy(muscleTypes = muscleTypes)
        }
    }

    fun selectUpperBody() {
        _state.update { st ->
            val newValue = st.muscleTypes
                .filterNot { mt -> mt.type == MuscleTypeEnum.LEGS }
                .all { mt ->
                    mt.muscles
                        .filter { st.includedMuscleStatuses.contains(it.status) }
                        .all { m -> m.isSelected }
                }.not()

            val muscleTypes = st.muscleTypes
                .map { muscleType ->
                    val muscles = muscleType.muscles
                        .map { muscle ->
                            if (st.includedMuscleStatuses.contains(muscle.status).not()) muscle
                            else muscle.copy(isSelected = if (muscleType.type == MuscleTypeEnum.LEGS) muscle.isSelected else newValue)
                        }
                    val image = muscleImage(
                        muscleTypeEnumState = muscleType.type,
                        muscles = muscles,
                        includedMuscleStatuses = st.includedMuscleStatuses
                    )
                    muscleType.copy(
                        muscles = muscles,
                        isSelected = muscles
                            .filter { st.includedMuscleStatuses.contains(it.status) }
                            .none { m -> m.isSelected.not() },
                        bodyImageVector = image
                    )
                }.toImmutableList()

            st.copy(muscleTypes = muscleTypes)
        }
    }

    fun selectLowerBody() {
        _state.update { st ->
            val newValue = st.muscleTypes
                .filter { mt -> mt.type == MuscleTypeEnum.LEGS }
                .all { mt ->
                    mt.muscles
                        .filter { st.includedMuscleStatuses.contains(it.status) }
                        .all { m -> m.isSelected }
                }.not()

            val muscleTypes = st.muscleTypes.map { muscleType ->
                val muscles = muscleType.muscles
                    .map { muscle ->
                        if (st.includedMuscleStatuses.contains(muscle.status).not()) muscle
                        else muscle.copy(isSelected = if (muscleType.type != MuscleTypeEnum.LEGS) muscle.isSelected else newValue)
                    }
                val image = muscleImage(
                    muscleTypeEnumState = muscleType.type,
                    muscles = muscles,
                    includedMuscleStatuses = st.includedMuscleStatuses
                )
                muscleType.copy(
                    muscles = muscles,
                    isSelected = muscles
                        .filter { st.includedMuscleStatuses.contains(it.status) }
                        .none { m -> m.isSelected.not() },
                    bodyImageVector = image
                )
            }.toImmutableList()

            st.copy(muscleTypes = muscleTypes)
        }
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}