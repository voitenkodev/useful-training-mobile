package exerciseexamplebuilder.main

import EquipmentsRepository
import MusclesRepository
import ViewModel
import exerciseexamplebuilder.main.factories.muscleImage
import exerciseexamplebuilder.main.mapping.toState
import exerciseexamplebuilder.main.models.MuscleGroup
import exerciseexamplebuilder.main.models.StatusEnum
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import org.koin.core.component.inject

internal class ExerciseExampleBuilderViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state

    private val equipmentsApi by inject<EquipmentsRepository>()
    private val musclesApi by inject<MusclesRepository>()

    init {
        equipmentsApi
            .observeEquipments()
            .onEach { r -> _state.update { it.copy(equipmentGroups = r.toState()) } }
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)

        musclesApi
            .observeMuscles()
            .onEach { r -> _state.update { it.copy(muscleGroups = r.toState()) } }
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)
    }

    fun updateName(value: String) {
        _state.update { it.copy(name = value) }
    }

    fun updateImageUrl(value: String) {
        _state.update { it.copy(imageUrl = value) }
    }

    fun onMuscleBundleChange(values: ImmutableList<MuscleGroup>) {
        _state.update {
            it.copy(muscleGroups = values)
        }
    }

    fun selectMuscle(id: String) {
        _state.update {

            val selectedMuscle = it
                .muscleGroups
                .flatMap { m -> m.muscles }
                .find { f -> f.id == id } ?: return@update it

            val biggestMuscle = it.muscleGroups
                .flatMap { m -> m.muscles }
                .filterNot { f -> f.id == selectedMuscle.id }
                .maxBy { max -> max.percentage }
                .takeIf { t -> t.percentage > it.minimalRange }

            val muscleTypes = it.muscleGroups.map { muscleType ->
                val muscles = muscleType.muscles.map { muscle ->

                    val newValue = if (selectedMuscle.status == StatusEnum.UNSELECTED) StatusEnum.SELECTED else StatusEnum.UNSELECTED

                    val newPercentage =
                        if (selectedMuscle.status == StatusEnum.SELECTED) 0 // become unselected
                        else if (selectedMuscle.status == StatusEnum.UNSELECTED && biggestMuscle == null) it.sliderRange.endInclusive
                        else it.minimalRange

                    return@map when (muscle.id) {
                        selectedMuscle.id -> selectedMuscle.copy(
                            status = newValue,
                            percentage = newPercentage
                        )

                        biggestMuscle?.id -> biggestMuscle.copy(
                            percentage = if (newValue == StatusEnum.SELECTED) biggestMuscle.percentage - newPercentage
                            else biggestMuscle.percentage + selectedMuscle.percentage
                        )

                        else -> muscle
                    }
                }.toPersistentList()

                val image = muscleImage(
                    muscleGroupEnumState = muscleType.type,
                    muscles = muscles
                )
                muscleType.copy(
                    muscles = muscles,
                    bodyImageVector = image
                )

            }.toPersistentList()

            it.copy(muscleGroups = muscleTypes)
        }
    }

    fun clearError() {
        _state.update { it.copy(error = null) }
    }
}