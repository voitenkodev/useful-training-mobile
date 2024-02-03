package exerciseexamplebuilder.main.mapping

import exerciseexamplebuilder.main.models.Filter
import exerciseexamplebuilder.main.models.FilterPack
import kotlinx.collections.immutable.toPersistentList
import models.ExerciseExampleFilters

internal fun ExerciseExampleFilters.toState(): FilterPack {
    return FilterPack(
        categories = categories.map { Filter(isSelected = false, value = it) }.toPersistentList(),
        weightTypes = weightTypes.map { Filter(isSelected = false, value = it) }.toPersistentList(),
        forceTypes = forceTypes.map { Filter(isSelected = false, value = it) }.toPersistentList(),
        experiences = experiences.map { Filter(isSelected = false, value = it) }.toPersistentList(),
    )
}