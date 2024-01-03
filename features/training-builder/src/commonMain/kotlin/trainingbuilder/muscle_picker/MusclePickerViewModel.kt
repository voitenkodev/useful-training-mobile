package trainingbuilder.muscle_picker

import MusclesRepository
import ViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import org.koin.core.component.inject
import trainingbuilder.muscle_picker.factories.muscleImage
import trainingbuilder.muscle_picker.mapping.toState

internal class MusclePickerViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state

    private val musclesApi by inject<MusclesRepository>()

    init {
        musclesApi
            .observeMuscles()
            .onEach { r ->
                _state.update { st ->
                    val result = r.toState(st.includedMuscleStatuses)

                    val filteredTypes = result
                        .flatMap { it.muscles }
                        .filter { st.includedMuscleStatuses.contains(it.status) }
                        .map { it.type }

                    st.copy(
                        muscleTypes = result,
                        lowerBodyList = st.lowerBodyList.filter { filteredTypes.contains(it) }.toPersistentList(),
                        upperBodyList = st.upperBodyList.filter { filteredTypes.contains(it) }.toPersistentList()
                    )
                }
            }
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
                .flatMap { it.muscles }
                .filter { m -> m.isSelected }
                .map { m -> m.type }
                .sorted() != st.upperBodyList.sorted()

            val muscleTypes = st.muscleTypes
                .map { muscleType ->
                    val muscles = muscleType.muscles
                        .map { muscle ->
                            if (st.includedMuscleStatuses.contains(muscle.status).not()) muscle
                            else muscle.copy(isSelected = if (st.upperBodyList.contains(muscle.type)) newValue else false)
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
                .flatMap { it.muscles }
                .filter { m -> m.isSelected }
                .map { m -> m.type }
                .sorted() != st.lowerBodyList.sorted()

            val muscleTypes = st.muscleTypes.map { muscleType ->
                val muscles = muscleType.muscles
                    .map { muscle ->
                        if (st.includedMuscleStatuses.contains(muscle.status).not()) muscle
                        else muscle.copy(isSelected = if (st.lowerBodyList.contains(muscle.type)) newValue else false)
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