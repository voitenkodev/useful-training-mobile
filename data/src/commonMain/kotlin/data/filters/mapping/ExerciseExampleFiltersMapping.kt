package data.filters.mapping

import models.ExerciseExampleFilters
import network.models.ExerciseExampleFiltersDto

internal fun ExerciseExampleFiltersDto.dtoToDomain(): ExerciseExampleFilters {
    return ExerciseExampleFilters(
        categories = categories ?: emptyList(),
        weightTypes = weightTypes ?: emptyList(),
        experiences = experiences ?: emptyList(),
        forceTypes = forceTypes ?: emptyList()
    )
}