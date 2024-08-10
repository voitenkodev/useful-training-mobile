package exerciseexamplebuilder.main

import ColorUtils
import EquipmentsRepository
import ExerciseExamplesRepository
import FiltersRepository
import MusclesRepository
import ViewModel
import equipment.mapping.toState
import exerciseexamplebuilder.main.mapping.toState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import models.CategoryEnum
import models.ExperienceEnum
import models.ForceTypeEnum
import models.InputExerciseExample
import models.InputExerciseExampleBundle
import models.WeightTypeEnum
import muscles.Coverage
import muscles.MuscleGroup
import muscles.factories.muscleImage
import muscles.mapping.toState
import org.koin.core.component.inject

internal class ExerciseExampleBuilderViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state.asStateFlow()

    private val equipmentsApi by inject<EquipmentsRepository>()
    private val musclesApi by inject<MusclesRepository>()
    private val filtersApi by inject<FiltersRepository>()
    private val exerciseExampleApi by inject<ExerciseExamplesRepository>()

    init {
        equipmentsApi
            .observeEquipments()
            .onEach { r ->
                val groups = r.toState()
                _state.update { it.copy(equipmentGroups = groups) }
            }
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)

        musclesApi
            .observeMuscles()
            .onEach { r ->
                val groups = r.toState(
                    eachMuscle = {
                        it.toState(
                            isSelected = false,
                            coverage = Coverage(
                                percentage = 0,
                                color = ColorUtils.randomColor(),
                            )
                        )
                    }
                )
                _state.update { it.copy(muscleGroups = groups) }
            }
            .catch { r -> _state.update { it.copy(error = r.message) } }
            .launchIn(this)

        filtersApi
            .getExerciseExampleFilters()
            .onStart { _state.update { it.copy(loading = true) } }
            .onEach { r -> _state.update { it.copy(filterPack = r.toState(), loading = false) } }
            .catch { r -> _state.update { it.copy(error = r.message, loading = false) } }
            .launchIn(this)
    }

    fun saveExercise(onSuccess: () -> Unit) {
        val lastState = state.value

        val inputExerciseExample = InputExerciseExample(
            category = CategoryEnum.of(lastState.filterPack.categories.firstOrNull { it.isSelected }?.value),
            experience = ExperienceEnum.of(lastState.filterPack.experiences.firstOrNull { it.isSelected }?.value),
            forceType = ForceTypeEnum.of(lastState.filterPack.forceTypes.firstOrNull { it.isSelected }?.value),
            weightType = WeightTypeEnum.of(lastState.filterPack.weightTypes.firstOrNull { it.isSelected }?.value),
            description = lastState.description,
            imageUrl = lastState.imageUrl,
            name = lastState.name,
            equipmentIds = lastState.equipmentGroups
                .flatMap { it.equipments }
                .filter { it.status == IncludedStatusEnum.INCLUDED }
                .map { it.id },
            exerciseExampleBundles = lastState.muscleGroups
                .flatMap { it.muscles }
                .filter { it.isSelected }
                .map {
                    InputExerciseExampleBundle(
                        muscleId = it.id,
                        percentage = it.coverage?.percentage ?: 0
                    )
                }
        )

        exerciseExampleApi.setExerciseExample(inputExerciseExample)
            .onStart {
                _state.update { it.copy(loading = true) }
            }.onEach {
                _state.update { it.copy(loading = false, error = null) }
                onSuccess.invoke()
            }.catch { t ->
                _state.update { it.copy(loading = false, error = t.message) }
            }.launchIn(this)
    }

    fun updateName(value: String) {
        _state.update { it.copy(name = value) }
    }

    fun updateDescription(value: String) {
        _state.update { it.copy(description = value) }
    }

    fun updateImageUrl(value: String) {
        _state.update { it.copy(imageUrl = value) }
    }

    fun onMuscleBundleChange(values: ImmutableList<MuscleGroup>) {
        _state.update {
            it.copy(muscleGroups = values)
        }
    }

    fun selectCategory(value: String) {
        _state.update {
            val newFilterPack = it.filterPack.copy(
                categories = it.filterPack.categories.map { item ->
                    item.copy(isSelected = item.value == value)
                }.toPersistentList()
            )
            it.copy(filterPack = newFilterPack)
        }
    }

    fun selectWeightType(value: String) {
        _state.update {
            val newFilterPack = it.filterPack.copy(
                weightTypes = it.filterPack.weightTypes.map { item ->
                    item.copy(isSelected = item.value == value)
                }.toPersistentList()
            )
            it.copy(filterPack = newFilterPack)
        }
    }

    fun selectExperience(value: String) {
        _state.update {
            val newFilterPack = it.filterPack.copy(
                experiences = it.filterPack.experiences.map { item ->
                    item.copy(isSelected = item.value == value)
                }.toPersistentList()
            )
            it.copy(filterPack = newFilterPack)
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
                            isSelected = v.isSelected.not()
                        )
                    }.toPersistentList()

                    mt.copy(
                        equipments = equipments
                    )
                }.toPersistentList()
            )
        }
    }

    fun selectForceType(value: String) {
        _state.update {
            val newFilterPack = it.filterPack.copy(
                forceTypes = it.filterPack.forceTypes.map { item ->
                    item.copy(isSelected = item.value == value)
                }.toPersistentList()
            )
            it.copy(filterPack = newFilterPack)
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
                .maxBy { max -> max.coverage?.percentage ?: 0 }
                .takeIf { t -> (t.coverage?.percentage ?: 0) > it.minimalRange }

            val muscleTypes = it.muscleGroups.map { muscleType ->
                val muscles = muscleType.muscles.map { muscle ->

                    val newValue = selectedMuscle.isSelected.not()

                    val newPercentage =
                        if (selectedMuscle.isSelected) 0 // become unselected
                        else if (selectedMuscle.isSelected.not() && biggestMuscle == null) it.sliderRange.endInclusive
                        else it.minimalRange

                    return@map when (muscle.id) {
                        selectedMuscle.id -> selectedMuscle.copy(
                            isSelected = newValue,
                            coverage = selectedMuscle.coverage?.copy(percentage = newPercentage)
                        )

                        biggestMuscle?.id -> biggestMuscle.copy(

                            coverage = if (newValue) {
                                biggestMuscle.coverage?.copy(
                                    percentage = (biggestMuscle.coverage?.percentage
                                        ?: 0) - newPercentage
                                )
                            } else {
                                biggestMuscle.coverage?.copy(
                                    percentage = (biggestMuscle.coverage?.percentage
                                        ?: 0) + (selectedMuscle.coverage?.percentage ?: 0)
                                )
                            }
                        )

                        else -> muscle
                    }
                }.toPersistentList()

                val image = muscleImage(
                    muscleGroupEnumState = muscleType.type,
                    muscles = muscles,
                    includedMuscleStatuses = null
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