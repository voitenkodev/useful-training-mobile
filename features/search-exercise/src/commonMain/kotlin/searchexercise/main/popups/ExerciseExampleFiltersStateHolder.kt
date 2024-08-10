package searchexercise.main.popups

import equipment.EquipmentGroup
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import muscles.MuscleGroup
import muscles.factories.muscleImage
import searchexercise.main.models.FilterPack

internal class ExerciseExampleFiltersStateHolder(
    equipments: ImmutableList<EquipmentGroup> = persistentListOf(),
    muscles: ImmutableList<MuscleGroup> = persistentListOf(),
    filterPack: FilterPack = FilterPack()
) {

    private val _state = MutableStateFlow(
        ExerciseExampleFiltersState(
            equipmentGroups = equipments,
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
            val newGroups = it.equipmentGroups.map equipGroupMap@{ g ->
                val newEquip = g.equipments.map equipMap@{ v ->
                    if (id != v.id) {
                        return@equipMap v
                    }
                    v.copy(isSelected = v.isSelected.not())
                }.toPersistentList()
                g.copy(equipments = newEquip)
            }.toPersistentList()

            it.copy(equipmentGroups = newGroups)
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

                        m.copy(isSelected = m.isSelected.not())
                    }.toPersistentList()

                    mt.copy(
                        muscles = muscles,
                        bodyImageVector = muscleImage(mt.type, muscles, null)
                    )
                }.toPersistentList()
            )
        }
    }

    fun clearFilters() {
        _state.update {
            it.copy(
                muscles = it.muscles.map { mt ->
                    val muscles =
                        mt.muscles.map muscleMap@{ m -> m.copy(isSelected = false) }
                            .toPersistentList()
                    mt.copy(
                        muscles = muscles,
                        bodyImageVector = muscleImage(mt.type, muscles, null)
                    )
                }.toPersistentList(),
                equipmentGroups = it.equipmentGroups.map equipGroupMap@{ g ->
                    val equips = g.equipments.map { it.copy(isSelected = false) }.toPersistentList()
                    g.copy(equipments = equips)
                }.toPersistentList(),
                filterPack = it.filterPack.copy(
                    forceTypes = it.filterPack.forceTypes.map { item -> item.copy(isSelected = false) }
                        .toPersistentList(),
                    weightTypes = it.filterPack.weightTypes.map { item -> item.copy(isSelected = false) }
                        .toPersistentList(),
                    categories = it.filterPack.categories.map { item -> item.copy(isSelected = false) }
                        .toPersistentList(),
                    experiences = it.filterPack.experiences.map { item -> item.copy(isSelected = false) }
                        .toPersistentList(),
                )
            )
        }
    }
}