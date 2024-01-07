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
                        muscleGroups = result,
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
            val groups = st.muscleGroups.map { muscleGroup ->
                val muscles = muscleGroup.muscles
                    .map { muscle ->
                        if (id == muscle.id) muscle.copy(isSelected = muscle.isSelected.not())
                        else muscle
                    }
                val image = muscleImage(
                    muscleGroupEnumState = muscleGroup.type,
                    muscles = muscles,
                    includedMuscleStatuses = st.includedMuscleStatuses
                )
                muscleGroup.copy(
                    muscles = muscles,
                    isSelected = muscles
                        .filter { st.includedMuscleStatuses.contains(it.status) }
                        .none { m -> m.isSelected.not() },
                    bodyImageVector = image
                )

            }.toImmutableList()

            st.copy(muscleGroups = groups)
        }
    }

    fun selectMuscleGroup(id: String) {
        _state.update { st ->
            val newValue = st.muscleGroups.find { it.id == id }?.let { mt ->
                mt.muscles
                    .filter { st.includedMuscleStatuses.contains(it.status) }
                    .all { m -> m.isSelected }
            }?.not() ?: false

            val groups = st.muscleGroups.map { group ->
                if (id != group.id) return@map group

                val muscles = group.muscles
                    .map { muscle ->
                        if (st.includedMuscleStatuses.contains(muscle.status).not()) muscle
                        else muscle.copy(isSelected = newValue)
                    }
                val image = muscleImage(
                    muscleGroupEnumState = group.type,
                    muscles = muscles,
                    includedMuscleStatuses = st.includedMuscleStatuses
                )
                group.copy(
                    muscles = muscles,
                    isSelected = muscles
                        .filter { st.includedMuscleStatuses.contains(it.status) }
                        .none { m -> m.isSelected.not() },
                    bodyImageVector = image
                )

            }.toImmutableList()

            st.copy(muscleGroups = groups)
        }
    }

    fun selectFullBody() {
        _state.update { st ->
            val newValue = st.muscleGroups.all { mt ->
                mt.muscles
                    .filter { st.includedMuscleStatuses.contains(it.status) }
                    .all { m -> m.isSelected }
            }.not()

            val groups = st.muscleGroups.map { group ->
                val muscles = group.muscles
                    .map { muscle ->
                        if (st.includedMuscleStatuses.contains(muscle.status).not()) muscle
                        else muscle.copy(isSelected = newValue)
                    }
                val image = muscleImage(
                    muscleGroupEnumState = group.type,
                    muscles = muscles,
                    includedMuscleStatuses = st.includedMuscleStatuses
                )
                group.copy(
                    muscles = muscles,
                    isSelected = muscles
                        .filter { st.includedMuscleStatuses.contains(it.status) }
                        .none { m -> m.isSelected.not() },
                    bodyImageVector = image
                )

            }.toImmutableList()

            st.copy(muscleGroups = groups)
        }
    }

    fun selectUpperBody() {
        _state.update { st ->
            val newValue = st.muscleGroups
                .flatMap { it.muscles }
                .filter { m -> m.isSelected }
                .map { m -> m.type }
                .sorted() != st.upperBodyList.sorted()

            val groups = st.muscleGroups
                .map { group ->
                    val muscles = group.muscles
                        .map { muscle ->
                            if (st.includedMuscleStatuses.contains(muscle.status).not()) muscle
                            else muscle.copy(isSelected = if (st.upperBodyList.contains(muscle.type)) newValue else false)
                        }
                    val image = muscleImage(
                        muscleGroupEnumState = group.type,
                        muscles = muscles,
                        includedMuscleStatuses = st.includedMuscleStatuses
                    )
                    group.copy(
                        muscles = muscles,
                        isSelected = muscles
                            .filter { st.includedMuscleStatuses.contains(it.status) }
                            .none { m -> m.isSelected.not() },
                        bodyImageVector = image
                    )
                }.toImmutableList()

            st.copy(muscleGroups = groups)
        }
    }

    fun selectLowerBody() {
        _state.update { st ->
            val newValue = st.muscleGroups
                .flatMap { it.muscles }
                .filter { m -> m.isSelected }
                .map { m -> m.type }
                .sorted() != st.lowerBodyList.sorted()

            val groups = st.muscleGroups.map { group ->
                val muscles = group.muscles
                    .map { muscle ->
                        if (st.includedMuscleStatuses.contains(muscle.status).not()) muscle
                        else muscle.copy(isSelected = if (st.lowerBodyList.contains(muscle.type)) newValue else false)
                    }
                val image = muscleImage(
                    muscleGroupEnumState = group.type,
                    muscles = muscles,
                    includedMuscleStatuses = st.includedMuscleStatuses
                )
                group.copy(
                    muscles = muscles,
                    isSelected = muscles
                        .filter { st.includedMuscleStatuses.contains(it.status) }
                        .none { m -> m.isSelected.not() },
                    bodyImageVector = image
                )
            }.toImmutableList()

            st.copy(muscleGroups = groups)
        }
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}