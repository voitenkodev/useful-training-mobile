package searchexercise.main.mapping

import kotlinx.collections.immutable.toPersistentList
import models.ExerciseExampleFilters
import searchexercise.main.models.Filter
import searchexercise.main.models.FilterPack

internal fun ExerciseExampleFilters.toState(): FilterPack {
    return FilterPack(
        categories = categories.map { Filter(isSelected = false, value = it) }.toPersistentList(),
        weightTypes = weightTypes.map { Filter(isSelected = false, value = it) }.toPersistentList(),
        forceTypes = forceTypes.map { Filter(isSelected = false, value = it) }.toPersistentList(),
        experiences = experiences.map { Filter(isSelected = false, value = it) }.toPersistentList(),
    )
}