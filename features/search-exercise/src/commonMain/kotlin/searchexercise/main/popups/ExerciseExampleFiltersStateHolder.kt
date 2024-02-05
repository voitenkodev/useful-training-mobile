package searchexercise.main.popups

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import searchexercise.main.factories.muscleImage
import searchexercise.main.models.FilterEquipment
import searchexercise.main.models.FilterMuscleGroup
import searchexercise.main.models.FilterPack
import searchexercise.main.models.StatusEnum

internal class ExerciseExampleFiltersStateHolder(
    equipments: ImmutableList<FilterEquipment> = persistentListOf(),
    muscles: ImmutableList<FilterMuscleGroup> = persistentListOf(),
    filterPack: FilterPack = FilterPack()
) {

    private val _state = MutableStateFlow(
        ExerciseExampleFiltersState(
            equipments = equipments,
            muscles = muscles,
            filterPack = filterPack
        )
    )
    val state: StateFlow<ExerciseExampleFiltersState> = _state.asStateFlow()


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
                equipments = it.equipments.map equipMap@{ v ->
                    if (id != v.id) {
                        return@equipMap v
                    }
                    v.copy(
                        status = when (v.status) {
                            StatusEnum.SELECTED -> StatusEnum.UNSELECTED
                            StatusEnum.UNSELECTED -> StatusEnum.SELECTED
                        }
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
            it.copy(
                muscles = it.muscles.map { mt ->
                    val muscles = mt.muscles.map muscleMap@{ m ->
                        if (id != m.id) {
                            return@muscleMap m
                        }

                        m.copy(
                            status = when (m.status) {
                                StatusEnum.SELECTED -> StatusEnum.UNSELECTED
                                StatusEnum.UNSELECTED -> StatusEnum.SELECTED
                            }
                        )
                    }.toPersistentList()

                    mt.copy(
                        muscles = muscles,
                        bodyImageVector = muscleImage(mt.type, muscles)
                    )
                }.toPersistentList()
            )
        }
    }

    fun clearFilters() {
        _state.update {
            it.copy(
                muscles = it.muscles.map { mt ->
                    val muscles = mt.muscles.map muscleMap@{ m -> m.copy(status = StatusEnum.UNSELECTED) }.toPersistentList()
                    mt.copy(muscles = muscles, bodyImageVector = muscleImage(mt.type, muscles))
                }.toPersistentList(),
                equipments = it.equipments.map equipMap@{ v ->
                    v.copy(status = StatusEnum.UNSELECTED)
                }.toPersistentList(),
                filterPack = it.filterPack.copy(
                    forceTypes = it.filterPack.forceTypes.map { item -> item.copy(isSelected = false) }.toPersistentList(),
                    weightTypes = it.filterPack.weightTypes.map { item -> item.copy(isSelected = false) }.toPersistentList(),
                    categories = it.filterPack.categories.map { item -> item.copy(isSelected = false) }.toPersistentList(),
                    experiences = it.filterPack.experiences.map { item -> item.copy(isSelected = false) }.toPersistentList(),
                )
            )
        }
    }
}